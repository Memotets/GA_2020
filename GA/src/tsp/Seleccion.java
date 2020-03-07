/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class Seleccion {
    public static Individuo Torneo(Poblacion pActual) {
         return pActual.getPoblacion().getFirst();
    }
    
    public static Individuo Torneo2do(Poblacion pActual) {
         return pActual.getPoblacion().get(1);
    }
    
    public static Individuo Aleatoria(Poblacion pActual) {
         Random rn = new Random();
         int pos = rn.nextInt(pActual.getPoblacion().size());
         return new Individuo(
                 pActual.getPoblacion().get(pos).getGenotipo()
         );
    }
}
