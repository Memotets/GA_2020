/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.Random;

/**
 *
 * @author memotets89
 */
public class Seleccion {
        public static Individuo Aleatoria(Poblacion pActual) {
         Random rn = new Random();
         int pos = rn.nextInt(pActual.getPoblacion().size());
         return new Individuo(
                 pActual.getPoblacion().get(pos).getGeno()
         );
    }

//    private Individuo Torneo(Poblacion pActual) {
//        int pos = 0; 
//        pActual.getPoblacion().forEach((Individuo mejor) ->{
//            if (pos< mejor.getFeno()){
//                
//            }
//        });
//    }
    
}
