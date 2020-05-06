/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author memotets89
 */
public class readSAT {
    public static File archivo;
    public static File geno;
    
    public static File readFile () throws IOException{
                // definir los filtros para lectura
        FileNameExtensionFilter filtro =
        new FileNameExtensionFilter("txt","csv");
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
         return archivo;
    } 
    
    public static int numGenes()throws IOException{
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        
         String linea = br.readLine();
         StringTokenizer tokens=new StringTokenizer(linea," ");
         return Integer.parseInt(tokens.nextToken());
    }
    
    public static String [][] readSat() throws IOException{
        
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        
         String linea;
         ArrayList<String> lineas = new ArrayList<>();
        while((linea=br.readLine())!=null){
            // el proceso de tokenizar
            lineas.add(linea);

         }
        
        //------------Lectura configuración--------------------------------
        String configuracion = lineas.get(0);
        StringTokenizer tokens=new StringTokenizer(configuracion," ");
        int valores[]= new int[tokens.countTokens()];
        int c =0;
        while(tokens.hasMoreTokens()){
                int v = Integer.parseInt(tokens.nextToken());
                valores[c]= v;
                c++;
        }
        
        String matriz[][] = new String [valores[1]][valores[2]];
        //---------------------------------------------------------------
        
        //-------Escritura y envio de matriz-----------------------------
        for (int l = 1; l < lineas.size();l++){
             String aux = lineas.get(l);
             tokens = new StringTokenizer(aux," ");
             
             c=0;
             while(tokens.hasMoreTokens()){
                String v = tokens.nextToken();
                matriz[l-1][c]= v;
                c++;
            }
         }
        return matriz;
        
    }

    public static int[] geno() throws IOException {
        FileReader fr = new FileReader (geno);
        BufferedReader br = new BufferedReader(fr);
        
         String linea = br.readLine();
         StringTokenizer tokens=new StringTokenizer(linea," ");
         int valores[]= new int[tokens.countTokens()];
         int c =0;
         while(tokens.hasMoreTokens()){
                int v = Integer.parseInt(tokens.nextToken());
                valores[c]= v;
                c++;
        }
        return valores;
    }
}
