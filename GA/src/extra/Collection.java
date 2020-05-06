/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

import SAT.Individuo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
//import tsp.Individuo;

/**
 *
 * @author memotets89
 */
public class Collection {
    public static void saveNQueens(NReinas.Individuo ind){
                FileWriter fichero = null;
        PrintWriter pw = null;
        String cT = "NQueens_N"+ind.getGenotipo().length;
        mkDir(cT);
        Date fecha = new Date();
        Calendar c = Calendar.getInstance();
        String nombre= ind.getGenotipo().length+"_"+ind.getFitness()+"_("
                +c.get(Calendar.DATE)+"-"+(c.get(Calendar.MONTH)+1)+")_["
                +fecha.getHours()+":"+fecha.getMinutes()+":"+fecha.getSeconds()+"]"; 
        try
        {
            fichero = new FileWriter(cT+"/"+nombre+".txt");
            pw = new PrintWriter(fichero);
            pw.println(ind.getGenotipo().length);           // tablero de N
            pw.println(ind.getFitness());                   // Numero de choques
            for(int i =0; i<ind.getGenotipo().length;i++){  //  Configuración de tablero
                if (i != (ind.getGenotipo().length-1)) pw.print(ind.getGenotipo()[i]+",");
                else pw.println(ind.getGenotipo()[i]);
            }
            System.out.println("Archivo creado: " + nombre);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
                if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    public static void saveSAT(SAT.Individuo ind){
                FileWriter fichero = null;
        PrintWriter pw = null;
        String cT = "SAT";
        mkDir(cT);
        String nombre= "Pruebas_"+ind.getFitness()+"("+Math.random()+")"; 
        try
        {
            fichero = new FileWriter(cT+"/"+nombre+".txt");
            pw = new PrintWriter(fichero);
            pw.println(ind.getGenotipo().length);           // cantidad de booleans
            pw.println(ind.getFitness());                   // clausulas verdaderas
            pw.println(Individuo.clausulas.length); //numero de clausulas
            pw.println(Individuo.clausulas[0].length); //cantidad de booleans por clausula
            for(int i =0; i<ind.getGenotipo().length;i++){  // combinatoria de booleans
                if (i != (ind.getGenotipo().length-1)) pw.print(ind.getGenotipo()[i]+" ");
                else pw.println(ind.getGenotipo()[i]);
            }
            System.out.println("Archivo creado: " + nombre);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
                if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
     public static void guardarTSP(tsp.Individuo ind){
        FileWriter fichero = null;
        PrintWriter pw = null;
        String cT = ""+ind.getGenotipo().length;
        mkDir(cT);
        String nombre= ind.getGenotipo()[0]+"_"+ind.getFitness()+"_"+new Date(); 
        try
        {
            fichero = new FileWriter(cT+"/"+nombre);
            pw = new PrintWriter(fichero);
            pw.println(ind.getGenotipo().length);
            pw.println(ind.getGenotipo()[0]);
            pw.println(ind.getFitness());
            for(int i =0; i<ind.getGenotipo().length;i++){
                if (i != (ind.getGenotipo().length-1)) pw.print(ind.getGenotipo()[i]+",");
                else pw.println(ind.getGenotipo()[i]);
            }
            System.out.println("Archivo creado: " + nombre);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
                if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }

    }
     
     public static tsp.Individuo LeerTSP() throws FileNotFoundException, IOException{
         // definir los filtros para lectura
        FileNameExtensionFilter filtro =
        new FileNameExtensionFilter(".txt",".csv",".xml");
        // crear un selector de archivos
        JFileChooser selector = new JFileChooser();
        // agregar el filtro al selector
        selector.addChoosableFileFilter(filtro);
        // especificar que solo se puedan abrir archivos
        selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //ejecutar el selector de archivos
        int res = selector.showOpenDialog(null);
        if (res == 1 ){
                return null;}
        File archivo = selector.getSelectedFile();
        FileReader fr = null;
        BufferedReader br = null;

      
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         
         String linea;
         //String nombre = archivo.getName();
         ArrayList<String> lineas = new ArrayList<>();
         
         while((linea=br.readLine())!=null){
            // el proceso de tokenizar
            lineas.add(linea);

         }
         linea = lineas.get(3);
         String[]geno = linea.split(",");
         int[] newGenotipo = new int[geno.length];
         for (int x =0; x<newGenotipo.length;x++)newGenotipo[x] = Integer.parseInt(geno[x]);
         return new tsp.Individuo(newGenotipo); 
        
     }
    
     
     public static void mkDir(String n){
        File directorio = new File(n); //ruta relativa que sale del proyecto, es donde guardaremos todo
        if (!directorio.exists()){ //si no existe
            directorio.mkdir(); // lo crea
            System.out.println("Carpeta creada");
        }else{ // en caso contrario solo indica que existe
            System.out.println("Carpeta existente");
        }
    }
}
