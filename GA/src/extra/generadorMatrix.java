/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author memotets89
 */
public class generadorMatrix {
    
    public static int [][] genMatriz(int n, int tope){
        
        int [][] matriz = new int[n][n];
        Random ran = new Random();
        for(int i =0; i < n; i++)
            for (int j =0; j < n; j++){
                if (i == j)break;
                int aux  = ran.nextInt(tope)+1;
                matriz[i][j] = aux;
                matriz[j][i] = aux;
            }
        return matriz;
    }
    
   public static void guardarMatriz(int[][] m, String nombre){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nombre);
            pw = new PrintWriter(fichero);

            for(int x=0; x<m[0].length;x++){
                for(int y=0; y <m.length ; y++){
                    if(y==m.length-1) pw.println(m[x][y]+"");
                    else pw.print(m[x][y]+",");
                    
                }
            }
               

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

    public static int[][] cargarMatriz() throws Exception{
        // definir los filtros para lectura
        FileNameExtensionFilter filtro =
        new FileNameExtensionFilter("Distancias","txt","csv");
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
         String nombre = archivo.getName();
         ArrayList<String> lineas = new ArrayList<>();
         
         while((linea=br.readLine())!=null){
            // el proceso de tokenizar
            lineas.add(linea);

         }
         // tokenizar cada una de las lineas 
         int[][] matriz = new int[lineas.size()][lineas.size()];
         for (int l = 0; l < lineas.size();l++){
             String aux = lineas.get(l);
             StringTokenizer tokens=new StringTokenizer(aux,",");
             int c=0;
             while(tokens.hasMoreTokens()){
                int v = Integer.parseInt(tokens.nextToken());
                matriz[l][c]= v;
                c++;
            }
         }
      
        fr.close();
        return matriz;
    }
}
