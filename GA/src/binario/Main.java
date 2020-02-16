/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;


/**
 *
 * @author memotets89
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        GeneticoV1 wop =new GeneticoV1(30, 0.2, 25);
        wop.evolucionMinimizando();
        
    }
    
    
    
}
