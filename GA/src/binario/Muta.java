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
public class Muta {
    public static void toggel( Individuo p){
         Random rn = new Random();
         int pos = rn.nextInt(p.getGeno().length);
         if (p.getGeno()[pos] == 1) p.getGeno()[pos] =0;
         else p.getGeno()[pos] = 1;
         p.calcularFitness();
    }
}
