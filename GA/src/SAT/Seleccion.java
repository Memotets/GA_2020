/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

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
                 pActual.getPoblacion().get(pos).getGenotipo()
         );
    }
        public static Individuo Torneo(Poblacion pActual) {
         return pActual.getPoblacion().getFirst();
    }
}
