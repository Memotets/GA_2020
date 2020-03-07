/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.Random;

/**
 *
 * @author memotets89
 */
public class Muta {
    static Individuo mutar(Individuo owo){
        return new Individuo(Getpos(owo.getGenotipo()));
    }
    
    
    private static int[] Getpos(int[] a) {
        Random pos1 = new Random();
        int p1;
        Random pos2= new Random();
        int p2; 
        do{
            p1= pos1.nextInt(a.length);
            p2 = pos2.nextInt(a.length);
        }while(p1 == p2 || p1 == 0 || p2 == 0);
        
        int ret[]= a.clone();
        ret[p1] = a[p2];
        ret[p2] = a[p1];
        return ret;
    }
    
}
