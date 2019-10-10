/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.pkg1_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class eliminar {
     public static void main(String[] args) throws FileNotFoundException, IOException
     {
          Scanner teclado =new Scanner(System.in);

          File fichero = new File("AleatorioEmple.dat");
          
          RandomAccessFile file = new RandomAccessFile(fichero, "rw");
           long posicion;
          int id=0,reg=0;
         
       
         
          
         System.out.print("Introduzca id que desea borrar: ");
         id=teclado.nextInt();
        
         posicion=(id-1)*36; 
         
         if(posicion>=file.length()){
             
         }   
         else
         {
             file.seek(posicion);
              reg=file.readInt();
              if(reg!=id){
                  System.out.println("ID: "+id+", NO EXISTE EMPLEADO - HUECO...");
                  System.exit(3);
              }
              else
              {                   
                                          
                  file.seek(posicion);   
                System.out.println(posicion);
                  file.writeInt(-1);
                  posicion=posicion+4;
                  file.writeChars(Integer.toString(id));
                   posicion=posicion+20;
                    file.seek(posicion);
                   System.out.println(posicion);
                  file.writeInt(0);
                  posicion=posicion+4;
                    file.seek(posicion);
                     System.out.println(posicion);
                  file.writeDouble(0);
                  

              }
         }
          file.close();
     }
    
}
