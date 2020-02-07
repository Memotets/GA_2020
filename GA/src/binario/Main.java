/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.LinkedList;

/**
 *
 * @author memotets89
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Poblacion example = new Poblacion(10);
          System.out.println("Poblacion");
        example.getPoblacion().forEach((Individuo i) ->{
            System.out.println(i.toString());
        });
          System.out.println("");
          System.out.println("Estos son la muestra");
        LinkedList<Individuo> ex = example.generarMuestraRandom(20);
        ex.forEach((Individuo i) ->{
           System.out.println(i.toString());
        });
        
        
//        Poblacion example2 = new Poblacion(ex,10);
//        System.out.println("");
//        
//        Individuo o3 = new Individuo(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
//        Individuo o1 = new Individuo(31);
        
        //o1.calcularFitness();
    }
    
    
    
}
