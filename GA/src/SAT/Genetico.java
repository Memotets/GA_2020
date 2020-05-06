/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;


import extra.Collection;
import java.util.Random;

/**
 *
 * @author memotets89
 */
public class Genetico {
    private int numG;
    private double pMuta;
    private Poblacion pActual;
    private final int pSize;
    private final int geno;
    
    public Genetico(int G, double Muta, int pobla, int geno){
        this.numG=G;
        this.pMuta= Muta;
        this.pSize= pobla;
        this.geno = geno;
        this.pActual = new Poblacion(this.pSize, this.geno);
    }
    
    public void evolucionar(){
        Individuo Mejor = null;
        //proceso evolutivo que genera nuevas poblaciones
        for (int g=0; g<this.numG;g++) {
            int[] mascara = randomMask(); //genero nueva mascara por generacion
            Poblacion neww = new Poblacion();// poblacion vacia
            //individuo random
            Mejor = new Individuo(geno); //propuesta de mejor aleatorio
            for (int i = 0 ; i < this.pSize; i++){
                //seleccion
                Individuo mom = Seleccion.Torneo(pActual);
                Individuo dad = Seleccion.Aleatoria(pActual);
                //cruza
                
                Individuo hijo = Cruza.CruzaMask(mascara, mom, dad);
                //mutacion
                if (Math.random()<this.pMuta){
                    Muta.toggel(hijo);
                }
                
                if (hijo.getFitness()> Mejor.getFitness()){ 
                    neww.getPoblacion().add(hijo); 
                    Mejor = new Individuo(hijo.getGenotipo());
                }
                else neww.getPoblacion().add(Mejor);

            }
            System.out.println("G"+g+": "+Mejor.toString());
            if(Mejor.getFitness() == Individuo.clausulas.length) break;                
            this.pActual= new Poblacion(neww,geno);
        }   
        Collection.saveSAT(Mejor);
    }

    private int[] randomMask() {
        int[] mask = new int[geno];
        Random rn = new Random();
        for(int i =0; i< mask.length;i++){
           mask[i]=rn.nextInt(2);
       }
        return mask;
    }
}
