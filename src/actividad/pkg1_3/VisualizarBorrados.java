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
public class VisualizarBorrados {
    public static void main(String[] args) throws FileNotFoundException, IOException{
                  File fichero = new File("AleatorioEmple.dat");

        RandomAccessFile file = new RandomAccessFile(fichero, "r");
            Double salario;
          int dep,id;
          char aux;
          char[] apellido=new char[10];
          long posicion=0;         
          
          System.out.println("Registros borrados:");
        for(;;){ 
         file.seek(posicion); 
         id = file.readInt(); 	  	  


       for (int i = 0; i < apellido.length; i++) {         
          aux = file.readChar(); 
          apellido[i] = aux;    
       }

     
       String apellidos = new String(apellido); 
         dep = file.readInt();        
         salario = file.readDouble(); 

         if(id <0)
         System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n",
                 id,   apellidos.trim(), dep, salario);     
      

       posicion= posicion + 36;	 

		  
         if (file.getFilePointer() == file.length())break;
   
        }
         file.close();
    }
}
