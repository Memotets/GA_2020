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
public class Muta {
    static Individuo mutar(Individuo owo){
        return new Individuo(Getpos(owo.getGenotipo()));
    }
    
    
    private static int[] Getpos(int[] a) {
        Random pos1 = new Random();
        Random pos2 = new Random();
        Random pos3 = new Random();
        Random pos4 = new Random();
        int p1,p2,p3,p4;
        double n = Math.random();
        if (n < .25){
            do{
                p1= pos1.nextInt(a.length);
                p2 = pos2.nextInt(a.length);
                p3= pos3.nextInt(a.length);
                p4 = pos4.nextInt(a.length);
                
            }while(
                    p1 == p2 ||
                    p2 == p3 || 
                    p3 == p4 || 
                    p4 == p1 || 
                    p1 == p3 || 
                    p2 == p4 );
            int ret[]= a.clone();
            ret[p1] = a[p4];
            ret[p2] = a[p1];
            ret[p3] = a[p2];
            ret[p4] = a[p3];
            return ret;
        }else if (n < .5){
            do{
                p1= pos1.nextInt(a.length);
                p2 = pos2.nextInt(a.length);
                p3= pos3.nextInt(a.length);
                
            }while(
                    p1 == p2 || 
                    p2 == p3 || 
                    p3 == p1);
            int ret[]= a.clone();
            ret[p1] = a[p3];
            ret[p2] = a[p1];
            ret[p3] = a[p2];
            return ret;
        }else
        {
            do{
                p1= pos1.nextInt(a.length);
                p2 = pos2.nextInt(a.length);
            }while(
                    p1 == p2);
            int ret[]= a.clone();
            ret[p1] = a[p2];
            ret[p2] = a[p1];
            return ret;
        }
    }
    
}
