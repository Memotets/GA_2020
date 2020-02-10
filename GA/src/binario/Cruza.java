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
public class Cruza {
    public static Individuo CruzaMask(int[] mask, Individuo mom, Individuo dad){
        int geno1[] = new int[mask.length];
        int geno2[] = new int[mask.length];
        for (int b =0; b<mask.length; b++){
            if (mask[b] == 1){ geno1[b] = mom.getGeno()[b]; geno2[b] = dad.getGeno()[b];} 
            else {geno1[b] = dad.getGeno()[b]; geno2[b] = mom.getGeno()[b];}
        }
        
        Individuo son1 = new Individuo(geno1);
        Individuo son2 = new Individuo(geno2);
        
        if (son1.getFitness()> son2.getFitness()) return son1;
        return son2;
    }
    
}
