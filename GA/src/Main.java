
import NReinas.GeneticoNReinas;


public class Main {



    public static void main(String[] args) {
        try {
            //Individuo.matrizDistancias = generadorMatrix.cargarMatriz();
            //Individuo p1 = Collection.LeerMejor();x
            GeneticoNReinas prueba1 = new GeneticoNReinas(100000, 0.7, 200, 100);
            prueba1.evolucionar();
        } catch (Exception e) {
      // TODO Auto-generated catch block
            e.printStackTrace();
       }
        //Individuo n1 = new Individuo(5);
        }
   

    }
    
    //6, 3, 1, 4, 7, 5, 2, 0
    

