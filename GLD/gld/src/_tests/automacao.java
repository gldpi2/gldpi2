/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package _tests;

/**
 *
 * @author artur
 */

/*
 * Esta classe assim como o método contido nela foram desenvolvidos exclusi-
 * vamente por demanda do cliente, não representando qualquer valor agre-
 * gado ao produto final.
 */
public class automacao {
    public boolean enableGerator = false;
    public boolean enableKey = false;
    /*
     * Para as variáveis booleanas: 1 representa funcionalidade ativa, 0, desa-
     * tiva;
     * EFC = Energia Fornecida Concessionária;
     * GES = Geração das Energias Sazonais;
     * DCH = Demanda da Carga;
     * value = Valor parâmetro da Demanda de Carga;
     * enableGerator = Ativa Gerador
     * enableKey = Ativa Switch Fonte Padrão/Alternativa
     */
    public void EnableGeratorAndKey(boolean EFC, boolean GES, double DCH, double value){
        boolean v_DCH = (DCH>value);
        //As equações abaixo foram extraídas pela técnica de mapa de Karnaugh;
        enableGerator = (!EFC||(v_DCH&&(!GES)));
        enableKey = (!EFC||v_DCH||GES);
    }
    
//    public static void main(String args[]){
//        automacao a = new automacao();
//        int val1, val2;
//        
//        //Caso 1
//        System.out.println("Caso 1 (111):\n");
//        System.out.println("EnableGeratorAndKey(true,true,2.0,1.0):");
//        a.EnableGeratorAndKey(true,true,2.0,1.0);
//        val1 = a.enableGerator? 1 : 0;
//        val2 = a.enableKey? 1 : 0;
//        System.out.println("enableGerator = "+ a.enableGerator);
//        System.out.println("enableKey = "+ a.enableKey);
//        System.out.println("(111) = ("+ val1 + "" + val2 +")");
//        System.out.println("\n");
//        
//        //Caso 2
//        System.out.println("Caso 2 (110):\n");
//        System.out.println("EnableGeratorAndKey(true,true,1.0,2.0):");
//        a.EnableGeratorAndKey(true,true,1.0,2.0);
//        val1 = a.enableGerator? 1 : 0;
//        val2 = a.enableKey? 1 : 0;
//        System.out.println("enableGerator = "+ a.enableGerator);
//        System.out.println("enableKey = "+ a.enableKey);
//        System.out.println("(110) = ("+ val1 + "" + val2 +")");
//        System.out.println("\n");
//        
//        //Caso 3
//        System.out.println("Caso 3 (101):\n");
//        System.out.println("EnableGeratorAndKey(true,false,2.0,1.0):");
//        a.EnableGeratorAndKey(true,false,2.0,1.0);
//        val1 = a.enableGerator? 1 : 0;
//        val2 = a.enableKey? 1 : 0;
//        System.out.println("enableGerator = "+ a.enableGerator);
//        System.out.println("enableKey = "+ a.enableKey);
//        System.out.println("(101) = ("+ val1 + "" + val2 +")");
//        System.out.println("\n");
//        
//        //Caso 4
//        System.out.println("Caso 4 (100):\n");
//        System.out.println("EnableGeratorAndKey(true,false,1.0,2.0):");
//        a.EnableGeratorAndKey(true,false,1.0,2.0);
//        val1 = a.enableGerator? 1 : 0;
//        val2 = a.enableKey? 1 : 0;
//        System.out.println("enableGerator = "+ a.enableGerator);
//        System.out.println("enableKey = "+ a.enableKey);
//        System.out.println("(100) = ("+ val1 + "" + val2 +")");
//        System.out.println("\n");
//        
//        //Caso 5
//        System.out.println("Caso 5 (011):\n");
//        System.out.println("EnableGeratorAndKey(false,true,2.0,1.0):");
//        a.EnableGeratorAndKey(false,true,2.0,1.0);
//        val1 = a.enableGerator? 1 : 0;
//        val2 = a.enableKey? 1 : 0;
//        System.out.println("enableGerator = "+ a.enableGerator);
//        System.out.println("enableKey = "+ a.enableKey);
//        System.out.println("(011) = ("+ val1 + "" + val2 +")");
//        System.out.println("\n");
//        
//        //Caso 6
//        System.out.println("Caso 6 (010):\n");
//        System.out.println("EnableGeratorAndKey(false,true,1.0,2.0):");
//        a.EnableGeratorAndKey(false,true,1.0,2.0);
//        val1 = a.enableGerator? 1 : 0;
//        val2 = a.enableKey? 1 : 0;
//        System.out.println("enableGerator = "+ a.enableGerator);
//        System.out.println("enableKey = "+ a.enableKey);
//        System.out.println("(010) = ("+ val1 + "" + val2 +")");
//        System.out.println("\n");
//        
//        //Caso 7
//        System.out.println("Caso 7 (001):\n");
//        System.out.println("EnableGeratorAndKey(false,false,2.0,1.0):");
//        a.EnableGeratorAndKey(false,false,2.0,1.0);
//        val1 = a.enableGerator? 1 : 0;
//        val2 = a.enableKey? 1 : 0;
//        System.out.println("enableGerator = "+ a.enableGerator);
//        System.out.println("enableKey = "+ a.enableKey);
//        System.out.println("(001) = ("+ val1 + "" + val2 +")");
//        System.out.println("\n");
//        
//        //Caso 8
//        System.out.println("Caso 8 (000):\n");
//        System.out.println("EnableGeratorAndKey(false,false,1.0,2.0):");
//        a.EnableGeratorAndKey(false,false,1.0,2.0);
//        val1 = a.enableGerator? 1 : 0;
//        val2 = a.enableKey? 1 : 0;
//        System.out.println("enableGerator = "+ a.enableGerator);
//        System.out.println("enableKey = "+ a.enableKey);
//        System.out.println("(000) = ("+ val1 + "" + val2 +")");
//        System.out.println("\n");
//    }
}
