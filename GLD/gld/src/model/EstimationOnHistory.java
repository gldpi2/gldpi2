/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Fernando
 */
public class EstimationOnHistory {
    
    private double index;
    
    public double pert(double greater, double minor, double better){
        
        index = ((greater + minor + (4*better))/6);
        
        return index;
        
    }    
    
    public static void main(String args[]){
            System.out.println("Indice");
            
            EstimationOnHistory est = new EstimationOnHistory();
            
            System.out.println("Resultado: "+est.pert(300,20,130));
            
        }
}
