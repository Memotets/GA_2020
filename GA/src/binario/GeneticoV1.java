/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario;

import java.util.Random;

/**
 *
 * @author memotets89
 */
public class GeneticoV1 {
    private int numG;
    private double pMuta;
    private Poblacion pActual;
    private final int pSize;
    
    public GeneticoV1(int G, double Muta, int pobla){
        this.numG=G;
        this.pMuta= Muta;
        this.pSize= pobla;
        this.pActual = new Poblacion(this.pSize);
    }
    
    public void evolucionar(){
        //proceso evolutivo que genera nuevas poblaciones
        for (int g=0; g<this.numG;g++) {
            Poblacion neww = new Poblacion();
            
            Individuo Mejor = new Individuo(31);
            
            for (int i = 0 ; i < this.pSize; i++){
                //seleccion
                Individuo mom = Seleccion.Aleatoria(pActual);
                Individuo dad = Seleccion.Aleatoria(pActual);
                //cruza
                Individuo hijo = Cruza.CruzaMask(new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1}, mom, dad);
                //mutacion
                if (Math.random()<this.pMuta){
                    Muta.toggel(hijo);
                }
                
                if (hijo.getFeno()> Mejor.getFeno()){ neww.getPoblacion().add(hijo); Mejor = new Individuo(hijo.getGeno());}
                else neww.getPoblacion().add(Mejor);

            }
                            System.out.println("G"+g+": "+Mejor.toString());
            this.pActual= new Poblacion(neww);
        }
    }

}
