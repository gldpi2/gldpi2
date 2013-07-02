package model;

import java.util.LinkedList;
import java.util.List;



/**
 * Essa classe contém métodos que resolvem um sistema de equações linear por meio do método Gauss-Jordan.
 * @author artur
 * 
 */

public class GaussJordan{
        
        private double[][] matrix; //matriz usada para os calculos
        private List<double[][]> resultList; //lista usada pra retornar as matrizes passo-a-passo
        
        public GaussJordan() {
                resultList = new LinkedList<double[][]>();
        }
        
        private void changeLines(double[][] coefficients, int line1, int line2, int collumn) {
                int numCoeficientes = coefficients[0].length - 1; //nro de coeficientes da matriz (nao usa o indice 0)
                double aux;
                for (int i = collumn; i <= numCoeficientes; i++) {
                        aux = coefficients[line1][i];
                        coefficients[line1][i] = coefficients[line2][i];
                        coefficients[line2][i] = aux;
                }
        }

        private void divideLinePerValue(double[][] coefficients, int line, int collumn){
                int numTerms = coefficients[0].length - 1; //nro de coeficientes da matriz (nao usa o indice 0)
                for(int i = collumn + 1; i <= numTerms; i++) {
                        coefficients[line][i] /= coefficients[line][collumn];
                }
                coefficients[line][collumn] = 1;
        }
        private void zeroTerm(double[][] coefficients, int line, int collumn) {
                int numLines = coefficients.length - 1;
                int numCollumns = coefficients[0].length - 1;
                for(int p = 1; p <= numLines; p++) {
                        if( p != line && coefficients[p][collumn] != 0 ) {
                                for(int q = collumn + 1; q <= numCollumns; q++) {
                                        coefficients[p][q] -= coefficients[p][collumn] * coefficients[line][q];
                                }
                                coefficients[p][collumn] = 0;
                        }
                }
        }
        private int findBiggestElementInCollumn(int i,int j) {
                double max = matrix[i][i];
                //matriz[1][1]; 
//                      Double.MIN_VALUE;
                int pos = i;
                int lineSize = matrix.length;
                for (int k = i; k < lineSize; k++) {
                        double elementMat = matrix[k][j];
                        if(elementMat > max){
                                max = matrix[k][j];
                                pos = k;
                        }
                }
                return pos;
                
        }
        private double[][] buildMatrix(double[][] coefficients, double[] terms) {
                int numLines = coefficients.length;
                int numCollumn = coefficients[0].length;
                matrix = new double[numLines + 1][numCollumn + 2]; //desconsidera os indices 0
                
                for (int i = 1; i <= numLines; i++) {
                        for (int j = 1; j <= numCollumn; j++) {
                                matrix[i][j] = coefficients[i - 1][j - 1];
                        }
                        matrix[i][numCollumn + 1] = terms[i - 1];
                }
                
                return matrix;
        }

        private double[][] formalizeMatrix(double[][] matrix){ // antes era o imprimeMatriz
                int numLinhas = matrix.length - 1; //subtrai 1 pra eliminar indice 0
                int numColunas = matrix[0].length - 1; //subtrai 1 pra eliminar indice 0
                double[][] matrizAux = new double[numLinhas][numColunas];
                                                
                for(int i = 1; i <= numLinhas; i++){
                        for(int j = 1; j <= numColunas; j++){
                                matrizAux[i-1][j-1]=  matrix[i][j];
                        }
                }
                return matrizAux;
        }
        private int gaussJordanPivoting(double[][] matrix) {
                int i, j, k, numLines, numCollumn;
                numLines = matrix.length - 1; //desconsidera os indices 0
                numCollumn = matrix[0].length - 1; //desconsidera os indices 0
                i = 1;
                j = 1;
                while( i <= numLines && j <= numCollumn ){

                        //procura na coluna j um valor nao nulo nas linhas abaixo da linha i
                        k = i;
                        while( k <= numLines && matrix[k][j] == 0 ) {
                                k++;
                        }

                        //valor nao nulo achado na linha k
                        if( k <= numLines ){

                                //troca a linha que contem o valor nao nulo com a linha k
                                if( k != i ) {
                                        changeLines(matrix, i, k, j);
                                        resultList.add(formalizeMatrix(matrix));
                    }

                                //valor da diagonal principal diferente de 1, entao tenta colocar 1 
                    if( matrix[i][j] != 1 ){
                        divideLinePerValue(matrix, i, j);
                        resultList.add(formalizeMatrix(matrix));
                    }

                    //zera todos os outros valores da coluna
                    zeroTerm(matrix, i, j);
                    resultList.add(formalizeMatrix(matrix));
                    i++;
                }
                j++;
            }           

                return i;
        }
        
        private int gaussJodanNoPivoting(double[][] matrix) {
                int i, j, k, numLines, numCollumns;
                numLines = matrix.length - 1; //desconsidera os indices 0
                numCollumns = matrix[0].length - 1; //desconsidera os indices 0
                i = 1;
                j = 1;
                while( i <= numLines && j <= numCollumns ){

                        //procura na coluna j um valor nao nulo nas linhas abaixo da linha i
                        k = i;
                        //encontra onde se encontra o maior elemento da coluna e
                        //troca a linha atual por essa linha
                        int biggestElementFromCollumn = findBiggestElementInCollumn(k, j);
                        changeLines(matrix, i, biggestElementFromCollumn, j);
                        
                        while( k <= numLines && matrix[k][j] == 0 ) {
                                k++;
                        }

                        //valor nao nulo achado na linha k
                        if( k <= numLines ){

                                //troca a linha que contem o valor nao nulo com a linha k
                                if( k != i ) {
                                        changeLines(matrix, i, k, j);
                                        resultList.add(formalizeMatrix(matrix));
                    }

                                //valor da diagonal principal diferente de 1, entao tenta colocar 1 
                    if( matrix[i][j] != 1 ){
                        divideLinePerValue(matrix, i, j);
                        resultList.add(formalizeMatrix(matrix));
                    }

                    //zera todos os outros valores da coluna
                    zeroTerm(matrix, i, j);
                    resultList.add(formalizeMatrix(matrix));
                    i++;
                }
                j++;
            }
                return i;
        }


        private double[][] parseSolution(double[][] matrix) {
                double[][] sol = new double[matrix.length][1];
                double element =0;
                for (int i = 0; i < matrix.length; i++) {
                        int coluna = matrix.length;
                        element = matrix[i][coluna];
                        sol[i][0] = element;
                }
                
                return sol;
                
        }

        public List<double[][]> getResultList() {
                return resultList;
        }
        
        public static void main(String args[]){
            System.out.println("Gerando a matriz!");
            double[] fx = {1};
            double[][] A = new double[fx.length][fx.length];
            List<double[][]> resultado;
            double[][] result;
            
            for(int i = 0; i < fx.length; i++){
                for(int j = 0; j <fx.length; j++){
                    A[i][j] = Math.pow(i, j);
                }
            }
            System.out.println("Matriz Gerada:");
            System.out.print("A =");
            for(int i = 0; i < fx.length; i++){
                for(int j = 0; j < fx.length; j++){
                    System.out.print(A[i][j]+"\t");
                }
                System.out.print(fx[i]+"\n   ");
            }
            System.out.println("");
            
            GaussJordan gj = new GaussJordan();
            gj.gaussJodanNoPivoting(gj.buildMatrix(A, fx));
            resultado = gj.getResultList();
            result = resultado.get(resultado.size()-1);
            System.out.print("A =");
            for(int i = 0; i < fx.length; i++){
                for(int j = 0; j < fx.length+1; j++){
                    System.out.print(result[i][j]+"\t");
                }
                System.out.print("\n   ");
            }
        }
        
}