
import SAT.Genetico;
import SAT.Individuo;
import SAT.Muta;
import extra.readSAT;
import java.io.IOException;


public class Main {



    public static void main(String[] args) throws IOException {
        //--Lectura para configurar genetico----
        readSAT.archivo = readSAT.readFile();  
        Individuo.clausulas = readSAT.readSat();
//        readSAT.geno = readSAT.readFile();
        int n = readSAT.numGenes();
//        int g[]= readSAT.geno();
        //--------------------------------------
//        Individuo wop = new Individuo(g);
//        System.out.print(wop.toString());
       Genetico SAT = new Genetico(25000, .5, 25, n);
       SAT.evolucionar();
       
       
        
        System.out.println();
        
        
       
        }
   

    }
    

