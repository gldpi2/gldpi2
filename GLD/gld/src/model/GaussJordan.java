package model;

import java.util.LinkedList;

/**
 * Essa classe contém métodos que interpola um polinômio por um conjunto de
 * pontos através do método Gauss-Jordan.
 *
 * @author artur
 *
 */
public class GaussJordan {

    private double[][] matrix, A; //matriz usada para os calculos
    private LinkedList<double[][]> resultList; //lista usada pra retornar a matriz estendida dos coeficientes
    private double[] coefficients; //coeficientes do polinômio interpolador

    public GaussJordan() {
        resultList = new LinkedList<>();
    }

    public void loadFx(double[] fx) {
        resultList.clear();
        coefficients = new double[fx.length];
        A = new double[fx.length][fx.length];
        for (int i = 0; i < fx.length; i++) {
            for (int j = 0; j < fx.length; j++) {
                A[i][j] = Math.pow(i, j);
            }
        }
        this.gaussJodanNoPivoting(this.buildMatrix(A, fx));
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

    private void divideLinePerValue(double[][] coefficients, int line, int collumn) {
        int numTerms = coefficients[0].length - 1; //nro de coeficientes da matriz (nao usa o indice 0)
        for (int i = collumn + 1; i <= numTerms; i++) {
            coefficients[line][i] /= coefficients[line][collumn];
        }
        coefficients[line][collumn] = 1;
    }

    private void zeroTerm(double[][] coefficients, int line, int collumn) {
        int numLines = coefficients.length - 1;
        int numCollumns = coefficients[0].length - 1;
        for (int p = 1; p <= numLines; p++) {
            if (p != line && coefficients[p][collumn] != 0) {
                for (int q = collumn + 1; q <= numCollumns; q++) {
                    coefficients[p][q] -= coefficients[p][collumn] * coefficients[line][q];
                }
                coefficients[p][collumn] = 0;
            }
        }
    }

    private int findBiggestElementInCollumn(int i, int j) {
        double max = matrix[i][i];
        int pos = i;
        int lineSize = matrix.length;
        for (int k = i; k < lineSize; k++) {
            double elementMat = matrix[k][j];
            if (elementMat > max) {
                max = matrix[k][j];
                pos = k;
            }
        }
        return pos;

    }

    private double[][] buildMatrix(double[][] coefficients, double[] terms) {
        int numLines = coefficients.length;
        int numCollumn = coefficients[0].length;
        matrix = new double[numLines + 1][numCollumn + 2];

        for (int i = 1; i <= numLines; i++) {
            for (int j = 1; j <= numCollumn; j++) {
                matrix[i][j] = coefficients[i - 1][j - 1];
            }
            matrix[i][numCollumn + 1] = terms[i - 1];
        }

        return matrix;
    }

    private double[][] formalizeMatrix(double[][] matrix) {
        int numLinhas = matrix.length - 1;
        int numColunas = matrix[0].length - 1;
        double[][] matrizAux = new double[numLinhas][numColunas];

        for (int i = 1; i <= numLinhas; i++) {
            for (int j = 1; j <= numColunas; j++) {
                matrizAux[i - 1][j - 1] = matrix[i][j];
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
        while (i <= numLines && j <= numCollumn) {
            //procura na coluna j um valor nao nulo nas linhas abaixo da linha i+                        
            k = i;
            while (k <= numLines && matrix[k][j] == 0) {
                k++;
            }

            //valor nao nulo achado na linha k
            if (k <= numLines) {

                //troca a linha que contem o valor nao nulo com a linha k
                if (k != i) {
                    changeLines(matrix, i, k, j);
                    resultList.add(formalizeMatrix(matrix));
                }

                //valor da diagonal principal diferente de 1, entao tenta colocar 1 
                if (matrix[i][j] != 1) {
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
        while (i <= numLines && j <= numCollumns) {

            //procura na coluna j um valor nao nulo nas linhas abaixo da linha i
            k = i;
            //encontra onde se encontra o maior elemento da coluna e
            //troca a linha atual por essa linha
            int biggestElementFromCollumn = findBiggestElementInCollumn(k, j);
            changeLines(matrix, i, biggestElementFromCollumn, j);

            while (k <= numLines && matrix[k][j] == 0) {
                k++;
            }
            //valor nao nulo achado na linha k
            if (k <= numLines) {
                //troca a linha que contem o valor nao nulo com a linha k
                if (k != i) {
                    changeLines(matrix, i, k, j);
                    resultList.add(formalizeMatrix(matrix));
                }
                //valor da diagonal principal diferente de 1, entao tenta colocar 1 
                if (matrix[i][j] != 1) {
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

    public double[] estimate(int num_values) {
        double[][] result = resultList.removeLast();
        resultList.add(result);
        double[] return_values = new double[num_values];
        for(int i = 0; i < coefficients.length;i++)
        coefficients[i] = result[i][coefficients.length];
        for(int i = 0; i < return_values.length; i++){
            return_values[i] = 0;
            for(int j =0; j < coefficients.length; j++){
                return_values[i] += coefficients[j]*Math.pow(i+coefficients.length,j);
            }
        }
        return return_values;
    }

}