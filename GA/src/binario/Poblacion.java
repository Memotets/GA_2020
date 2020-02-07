/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author memotets89
 */
public class Poblacion {
    private LinkedList<Individuo> poblacion;
    private int i;
    
//Aleatoria
    public Poblacion(int i){
        this.i=i;
        this.poblacion = new LinkedList<>();
        InicializacionAleatoria();
    }
    
//Con muestra
    public Poblacion(LinkedList<Individuo> muestra, int i){
        this.i=i;
        this.poblacion = new LinkedList<>();
        for (int x =0; x<muestra.size(); x++) this.poblacion.add(new Individuo(muestra.get(x).getGeno()));
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
    
}
