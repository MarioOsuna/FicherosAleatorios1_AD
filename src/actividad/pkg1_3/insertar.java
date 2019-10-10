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
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Usuario
 */
public class insertar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Scanner teclado =new Scanner(System.in);
        File fichero = new File("AleatorioEmple.dat");
        
        Double salario;
          int dep;
          String apellido;
          RandomAccessFile file = new RandomAccessFile(fichero, "rw");
          long posicion;
          int id=0,reg=0;
          boolean flag=false;         
          long i=0;
          
         System.out.print("Introduzca id: ");
         id=teclado.nextInt();
          
          posicion=(id-1)*36;
        
             for(;;)
             {
              file.seek(i);
              reg=file.readInt();
              if(id==reg){
                  flag=true;
              }
              i=file.getFilePointer()+20+4+8;
              if(i==file.length())
                  break;
             }
              if(flag==false)
              {
                  System.out.print("\nApellido: ");
                  apellido=teclado.next();
                  System.out.print("\nDepartamento: ");
                  dep=teclado.nextInt();
                  System.out.println("\nSalario: ");
                  salario=teclado.nextDouble();
                  StringBuffer buffer=null;   
                                   
                  file.seek(posicion);
                  file.writeInt(id);
                  buffer =new StringBuffer(apellido);
                  buffer.setLength(10);
                  file.writeChars(buffer.toString());
                  file.writeInt(dep);
                  file.writeDouble(salario);
              }
              else{

                  System.out.println("ID: "+id+" YA EXISTE ESTE ID");                
              }       
                   
              
          file.close();
    }
      
   
    
}
