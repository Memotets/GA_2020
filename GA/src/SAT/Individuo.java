/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT; // Problema de Satisfactibilidad Booleana

import java.util.Random;


/**
 *
 * @author memotets89
 */
public class Individuo {
    
    public static String[][] clausulas;
    
    private int [] genotipo;
    private int fitness;
    
    public Individuo(int n){
        this.genotipo = new int[n];
        IniciarRandom();
        CalcularFitness();
    }
    public Individuo(int[] genotipo){
        this.genotipo = genotipo;
        CalcularFitness();
    }
    
    private void IniciarRandom(){
       Random rn = new Random();
       for(int i =0; i< this.genotipo.length;i++){
           this.genotipo[i]=rn.nextInt(2);
       }
    }

    public void CalcularFitness() {
        this.fitness =0;
        for (String[] clausula : Individuo.clausulas) {
            for (String booleano : clausula) {
                int gen;
                if (booleano.contains("-")){//si la clausula es negativa (- n)
                    String posicion = booleano.replace("-", "");
                    gen = Integer.parseInt(posicion)-1;
                    if (this.genotipo[gen]== 0){ // tengo que ver si la posicion es 0
                        this.fitness++;
                        break;
                    }
                }else{ //en caso conttrario veo que sea 1
                    gen = Integer.parseInt(booleano)-1;
                    if (this.genotipo[gen]== 1){
                        this.fitness++;
                        break;
                    }
                    
                }
            }
        }
    }

    public int[] getGenotipo() {
        return genotipo;
    }

    public int getFitness() {
        return fitness;
    }

    @Override
    public String toString() {
        return "SAT{" + "genotipo=" + genotipo + ", fitness=" + fitness + '}';
    }
    
    
}
