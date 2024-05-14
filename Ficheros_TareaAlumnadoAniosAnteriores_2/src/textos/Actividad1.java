package textos;

import cesar.TextoEncriptado;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;


public class Actividad1 {
 
    private static final String ruta = System.getProperty("user.dir")+File.separator+"texto_encriptado_entrada.dat";
    /**
     * Método principal
     *
     * @param args argumentos de la línea de ordenes
     */
    public static void main(String[] args) {
        
        File fichero = new File(ruta);
        List<TextoEncriptado> datosFichero = new ArrayList<>();
        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero))){
            datosFichero = (List<TextoEncriptado>) entrada.readObject();
            System.out.println("CONTENIDO DEL ARCHIVO DE TEXTO");
            System.out.println("------------------------------");
            System.out.printf("Total de oraciones leídas: %d%n",datosFichero.size());
            for(int n=0;n<datosFichero.size();n++){
                String oracion = datosFichero.get(n).descifradoCesar();
                //Contar palabras
                int contador = 0;
                for(int j=0;j<oracion.length();j++){
                    if(j>0 && oracion.charAt(j) == ' ' && oracion.charAt(j-1)!=' '){
                        contador++;
                    }
                }
                System.out.printf("ORACIÓN %d - %d palabras: %s%n",n+1,contador+1,oracion);
                
            }
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        
        
        
    }
}