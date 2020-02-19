/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author memotets89
 */
public class Poblacion {
    private LinkedList<Individuo> poblacion;
    private int i;
    
    public Poblacion(){
        this.poblacion = new LinkedList<>();
    }    
    
//Aleatoria
    public Poblacion(int i){
        this.i=i;
        this.poblacion = new LinkedList<>();
        InicializacionAleatoria();
    }
    
     public Poblacion(int i, boolean mayor){
         this.i=i;
         this.poblacion = new LinkedList<>();
         if (!mayor){
            InicializacionAleatoria();
        }else{
           inicializacionMayor(); 
        }
    }
    
    //Con población completa
    public Poblacion(Poblacion muestra){
       // this.i=muestra.size();
        this.poblacion = new LinkedList<>();
        muestra.getPoblacion().forEach((Individuo a)-> this.poblacion.add(new Individuo(a.getGeno())));
        
    } 
//Con muestra
    public Poblacion(LinkedList<Individuo> muestra, int i){
        this.i=i;
        this.poblacion = new LinkedList<>();
        muestra.forEach((Individuo a)-> this.poblacion.add(new Individuo(a.getGeno())));
        
    }
    

    private void inicializacionMayor() {
        for(int x = 0; x<this.i;x++){
            this.poblacion.add(new Individuo(31, true));
        }        
    }    

    private void InicializacionAleatoria() {
        for(int x = 0; x<this.i;x++){
            this.poblacion.add(new Individuo(31));
        }
    }
    
    public LinkedList<Individuo> generarMuestraRandom(double n){
        int c = (int) ((n/100)*this.i);
        System.out.println(c);
         
        LinkedList<Individuo> muestra = new LinkedList<>();
        int pa = 0;
        Random rn = new Random();
        for (int x = 0 ; x<c ; x++){
            pa = rn.nextInt(this.i);
            muestra.add(this.poblacion.get(pa));
        }
        return muestra;
    }
    
     public LinkedList<Individuo> generarMuestraMejores(double n){
        int c = (int) ((n/100)*this.i);
        
        LinkedList<Individuo> muestra = new LinkedList<>();
        
        Collections.sort(this.poblacion,new Betters());
        
        for (int i = 0 ; i<c; i++){
            muestra.add(this.poblacion.get(i));
        }
        
        return muestra;
    }

    public LinkedList<Individuo> getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(LinkedList<Individuo> poblacion) {
        this.poblacion = poblacion;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    private static class Betters implements Comparator<Individuo>{
            @Override
            public int compare(Individuo e1, Individuo e2) {
	if(e1.getFeno()> e2.getFeno()){
                        return 1;
	} else {
                        return -1;
                    }
            }
    }
    
}
