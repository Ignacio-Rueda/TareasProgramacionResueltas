package ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Clase encargada de realizar la lectura y escritura de objetos Recetario en archivos binarios.
 * @author profe
 */
public class RecetarioIO {
    
    // Ruta del archivo donde se lee y escribe el objeto Recetario
    private String rutaArchivo;

    /**
     * Método constructor
     * @param archivo Ruta del archivo donde se lee y escribe el objeto Recetario
     */
    public RecetarioIO(String archivo) {
        this.rutaArchivo = archivo;
    }
    
 
    // -----------------------------------------------------
    // Ejercicio 2: Métodos que debe implementar el alumnado
    // -----------------------------------------------------
    
    /**
     * Método que lee, desde un archivo binario, un objeto Recetario serializado.
     * @return Objeto Recetario que estaba almacenado en el archivo binario.
     */
    public Recetario leer() {
        Recetario recetario = null;
        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(rutaArchivo))){
           recetario =(Recetario)entrada.readObject();
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        
        return recetario; // Sustituir este return por el código que resuelve el ejercicio 
    }
    
    /**
     * Método que escribe, en un archivo binario, un objeto Recetario serializable.
     * @param recetario Objeto Recetario serializable para almacenar en el archivo binario.
     */   
    public void escribir(Recetario recetario) {
        // Incluir el código que debe realizar el método
        File fichero = new File(rutaArchivo);
        try(ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(fichero))){
            escribir.writeObject(recetario);
            escribir.flush();
           
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
