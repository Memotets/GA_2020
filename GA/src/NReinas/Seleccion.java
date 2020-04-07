/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NReinas;

import java.util.Comparator;
import java.util.LinkedList;
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
        pActual.getPoblacion().sort(new Betters());
         
         return pActual.getPoblacion().getFirst();
    }
    
    public static Individuo Torneo2do(Poblacion pActual) {
        pActual.getPoblacion().sort(new Betters());
         return pActual.getPoblacion().get(1);
    }
    
        private static class Betters implements Comparator<Individuo>{
            @Override
            public int compare(Individuo e1, Individuo e2) {
	if(e1.getFitness()> e2.getFitness()){
                        return 1;
	} else {
                        return -1;
                    }
            }
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
