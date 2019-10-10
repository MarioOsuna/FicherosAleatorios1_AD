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
public class modificar {
    
     public static void main(String[] args) throws FileNotFoundException, IOException{
          
         Scanner teclado =new Scanner(System.in);
        
         File fichero = new File("AleatorioEmple.dat");          
         
         RandomAccessFile file = new RandomAccessFile(fichero, "rw");
         
          long posicion;
          int id=0,reg=0;
         
          Double salario,importe,NSalario;
          int dep;
          char aux;
          char[] apellido=new char[10];
         
          
         System.out.print("Introduzca id: ");
         id=teclado.nextInt();
         System.out.print("\nIntroduzca Importe: ");
         importe=teclado.nextDouble();          
         
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
                for(int i=0;i<apellido.length;i++){
                  aux=file.readChar();
                  apellido[i]=aux;
                }
                String apellidoS=new String(apellido);

                dep=file.readInt();
                salario=file.readDouble();
                
               
                  
                   NSalario=salario+importe;
                  
               posicion=(id-1)*36;
               posicion=posicion+28;
               file.seek(posicion);              
               file.writeDouble(NSalario);
                System.out.println("ID: "+id+", Apellido: "+apellidoS.trim()+", Departamento: "+dep+",Salario antiguo: "+salario+", Salario nuevo: "+NSalario);

              }
         }
                    
         
          
          file.close();
     }
     
     
    
}
