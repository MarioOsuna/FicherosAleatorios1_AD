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

/**
 *
 * @author Usuario
 */
public class Consulta {
     public static void main(String[] args) throws FileNotFoundException, IOException{
          File fichero = new File("AleatorioEmple.dat");
          
          RandomAccessFile file = new RandomAccessFile(fichero, "r");
          long posicion;
                  int registro=0,id,dep;
          char aux;
          char[] apellido=new char[10];
          double salario;
          
          registro=9;
          
          posicion=(registro-1)*36;
          if(posicion>=file.length()){
              System.out.println("ID: "+registro+",NO EXISTE EMPLEADO ID DEMASIADO GRANDE...");
          }
          else{
              file.seek(posicion);
              id=file.readInt();
              
              if(id!=registro){
                  System.out.println("ID: "+registro+", NO EXISTE EMPLEADO - HUECO...");
                  System.exit(3);
              }
              for(int i=0;i<apellido.length;i++){
                  aux=file.readChar();
                  apellido[i]=aux;
              }
              String apellidoS=new String(apellido);
              
              dep=file.readInt();
              salario=file.readDouble();
              
              
              
              System.out.println("ID: "+registro+", Apellido: "+apellidoS.trim()+", Departamento: "+dep+", Salario: "+salario);
          }
          file.close();
     }
}
