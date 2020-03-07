
import extra.Collection;
import tsp.Individuo;
//import binario.Poblacion;
import extra.generadorMatrix;
import tsp.GeneticoTSP;

public class Main {



    public static void main(String[] args) {
        try {
            Individuo.matrizDistancias = generadorMatrix.cargarMatriz();
            for (int i =0; i<3; i++){
                GeneticoTSP prueba0 = new GeneticoTSP(100000, 0.3, 100, 600, Individuo.matrizDistancias[0].length);
                prueba0.evolucionar();
                GeneticoTSP prueba1 = new GeneticoTSP(100000, 0.3, 100, 867, Individuo.matrizDistancias[0].length);
                prueba1.evolucionar();
                GeneticoTSP prueba2 = new GeneticoTSP(100000, 0.3, 100, 4, Individuo.matrizDistancias[0].length);
                prueba2.evolucionar();
                GeneticoTSP prueba3 = new GeneticoTSP(100000, 0.3, 100, 997, Individuo.matrizDistancias[0].length);
                prueba3.evolucionar();
            }
            //System.out.println();
        } catch (Exception e) {
      // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
   
    
    
    
}
