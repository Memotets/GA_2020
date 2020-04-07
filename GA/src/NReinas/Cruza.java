/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NReinas;

import java.util.Random;

/**
 *
 * @author memotets89
 */
public class Cruza {
    public static Individuo Asexual(Individuo mom, Individuo dad){
        int geno1[] = Getpos(mom.getGenotipo());
        int geno2[] = Getpos(dad.getGenotipo());
        
        Individuo son1 = new Individuo(geno1);
        Individuo son2 = new Individuo(geno2);
        
        if (son1.getFitness()> son2.getFitness()) return son1;
        return son2;
    }

    private static int[] Getpos(int[] a) {
        Random pos1 = new Random();
        int p1;
        Random pos2= new Random();
        int p2=-1; 
        do{
            p1= pos1.nextInt(a.length);
            p2 = pos2.nextInt(a.length);
        }while(p1 == p2);
        
        int ret[]= a.clone();
        ret[p1] = a[p2];
        ret[p2] = a[p1];
        return ret;
    }


}
