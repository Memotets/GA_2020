/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author memotets89
 */
public class Individuo {
    private int geno[];
    private int feno;
    private long fitness;
    
    public Individuo(int n){
        this.geno= new int[n];
        IniciarRandom();
        this.calcularFitness();
    }
    public Individuo(int n[]){
        this.geno= n.clone();
        this.calcularFitness();
    }
    public void calcularFitness(){
        calcularFenotipo();
        //2x²+ x+1
        this.fitness= (long) (2*Math.pow(this.feno, 2)+this.feno+1);
     //   System.out.println(this.toString());   
    }
    
    private void calcularFenotipo() {
   //     decodificacion del fenotipo
        String dato = "";
        boolean bin = true; // en caso de que sea un binario valido
        for (int i = 0; i < geno.length; i++) {
            if (geno[i]==0 || geno[i]==1) dato += geno[i];
            else{ bin = false; break;}//caso contrario
        }
        if (bin) feno = Integer.parseInt(dato, 2);
    }

    @Override
    public String toString() {
        return feno + ": " + fitness +". Genotipo: " + Arrays.toString(geno);
    }
    
    

    public int[] getGeno() {
        return geno;
    }

    public void setGeno(int[] geno) {
        this.geno = geno;
    }

    public int getFeno() {
        return feno;
    }

    public void setFeno(int feno) {
        this.feno = feno;
    }

    public long getFitness() {
        return fitness;
    }

    public void setFitness(long fitness) {
        this.fitness = fitness;
    }
    
    
    private void IniciarRandom(){
       Random rn = new Random();
       for(int i =0; i< this.geno.length;i++){
           this.geno[i]=rn.nextInt(2);
       }
    }
}
