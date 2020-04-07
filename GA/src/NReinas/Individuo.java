/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NReinas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author memotets89
 */
public class Individuo {
    private int [] genotipo; //representa una configuración: (i,g[i])
    private int fitness;
    //private int n;
    
    public Individuo(int n){
        if (n>3){
            genotipo = new int[n];
            inicializarAleatoriamente();
            CalcularFitness();
           // System.err.println(toString());
        }else{
            System.err.println("El problema de las N-Reinas no puede solucionarse si N es <= 3");
        }
    }
    
    public Individuo(int[] genotipo){
        this.genotipo = genotipo.clone();
        //inicializarAleatoriamente();
        CalcularFitness();
        //System.err.println(toString());
    }

    private void inicializarAleatoriamente() {
        ArrayList numeros = new ArrayList<>();
        for(int i=0;i<this.genotipo.length;i++)numeros.add(i);
        Random rn = new Random();
        for(int x =0; x<this.genotipo.length;x++){
            int n = rn.nextInt(numeros.size());
            this.genotipo[x] = (int) numeros.get(n);
            numeros.remove(n);
        }
    }

    private void CalcularFitness() {
        for(int i =0; i<this.genotipo.length-1;i++){
            fitness += ChoqueSuperior(i);
            fitness += ChoqueInferior(i);
        }
    }
    
    private int ChoqueSuperior(int i){
        int k =0; //k contante de choque;
        if (genotipo[i] !=0){
            int x = i+1;
            int y = genotipo[i]-1;
            while(x != genotipo.length && y!=-1){
                if (y == genotipo[x])k+=2; //como solo busco recorrer en un sentido, agrego 2 choques
                x++; // avanzo en x
                y--; // subo en y   
            }
        }
                    
        return k;
    }
    private int ChoqueInferior(int i){
        int k =0; //k contante de choque;
        if (genotipo[i] != genotipo.length-1){
            int x = i+1;
            int y = genotipo[i]+1;
            while(x != genotipo.length && y!=genotipo.length){
                if (y == genotipo[x])k+=2;//como solo busco recorrer en un sentido, agrego 2 choques
                x++;// avanzo en x
                y++;// subo en y
            }
        }
                    
        return k;
    }

    public int[] getGenotipo() {
        return genotipo;
    }

    public int getFitness() {
        return fitness;
    }

    @Override
    public String toString() {
        return "Individuo{" + "genotipo=" + Arrays.toString(genotipo) + ", fitness=" + fitness + '}';
    }
    
    
}
