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
        
        Poblacion n = new Poblacion(20);
        System.out.println("Poblacion original: ");
        n.getPoblacion().forEach((Individuo a) -> System.out.println(a.toString()));
                System.out.println("");
        System.out.println("Poblacion muestra: ");        
        n.generarMuestraMejores(20).forEach((Individuo a) -> System.out.println(a.toString()));
        
//        GeneticoV1 wop =new GeneticoV1(30, 0.2, 25);
//        wop.evolucionMinimizando();
        
    }
    
    
    
}
