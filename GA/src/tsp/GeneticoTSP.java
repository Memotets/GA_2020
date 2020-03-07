/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import binario.*;
import extra.Collection;
import java.util.Random;

/**
 *
 * @author memotets89
 */
public class GeneticoTSP {
    private int numG;
    private double pMuta;
    private Poblacion pActual;
    private final int pSize;
    int ci, n;
    
    public GeneticoTSP(int G, double M,  int pobla, int ci, int n){
        this.numG=G;
        this.pSize= pobla;
        this.pMuta = M;
        this.ci =ci;
        this.n=n;
        this.pActual = new Poblacion(this.pSize, this.ci, this.n);
    }
    
    public void evolucionar(){
        System.out.println("Iniciando 1er generacion");
        //proceso evolutivo que genera nuevas poblaciones
        for (int g=0; g<this.numG;g++) {
            Poblacion neww = new Poblacion();
            //individuo random
            Individuo Mejor = Seleccion.Aleatoria(pActual);
            
            for (int i = 0 ; i < this.pSize; i++){
                
                //seleccion
                Individuo mom = Seleccion.Torneo(pActual);
                Individuo dad = Seleccion.Torneo2do(pActual);
                //cruza
                Individuo hijo = Cruza.Asexual(mom,dad);
                //mutacion
                if (Math.random()<this.pMuta) hijo = Muta.mutar(hijo);
                
                
                if (hijo.getFitness()< Mejor.getFitness()){ 
                    neww.getPoblacion().add(hijo);
                    Mejor = new Individuo(hijo.getGenotipo());
                }
                else neww.getPoblacion().add(Mejor);
            }
            System.out.println(g+": "+Mejor.getFitness());
            this.pActual= new Poblacion(neww);
        }
        
        Individuo Mejor = Seleccion.Torneo(pActual);
        System.out.println("G"+this.numG+": "+Mejor.toString());
        Collection.guardarTSP(Mejor);
    }
    
        public void evolucionar(Individuo mejor){
        //proceso evolutivo que genera nuevas poblaciones
        boolean change=false;
        Individuo Mejor = new Individuo(mejor.getGenotipo());
        
        for (int g=0; g<this.numG;g++) {
            Poblacion neww = new Poblacion();
            //individuo
            if (change) Mejor = Seleccion.Aleatoria(pActual);
            for (int i = 0 ; i < this.pSize; i++){
                
                //seleccion
                Individuo mom = Seleccion.Torneo(pActual);
                Individuo dad = Seleccion.Torneo2do(pActual);
                //cruza
                Individuo hijo = Cruza.Asexual(mom,dad);
                //mutacion
                if (Math.random()<this.pMuta) hijo = Muta.mutar(hijo);
                
                
                if (hijo.getFitness()< Mejor.getFitness()){ 
                    neww.getPoblacion().add(hijo);
                    Mejor = new Individuo(hijo.getGenotipo());
                    change = true;
                }
                else neww.getPoblacion().add(Mejor);

            }
            System.out.println("G"+g+": "+Mejor.toString());
            this.pActual= new Poblacion(neww);
        }
        Mejor = Seleccion.Torneo(pActual);
        Collection.guardarTSP(Mejor);
    }
}
