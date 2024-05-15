package Ejercicio2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChipBiciIO{

    /**
     * Ruta del archivo donde se lee y escribe la colección de objetos ChipBici
     */
    private String rutaArchivo;

    /**
     * Método constructor
     * @param archivo Ruta del archivo donde se lee y escribe la colección de objetos ChipBici
     */
    public ChipBiciIO(String archivo) {
        this.rutaArchivo = archivo;
    }
 
    /**
     * Método que lee, desde un archivo binario, una colección de objetos ChipBici serializados.
     * @return Lista de objetos ChipBici que estaba almacenada en el archivo binario.
     */
    public List leer() {
        List<ChipBici> listaChipBici=null;
        try(ObjectInputStream leer = new ObjectInputStream(new FileInputStream(rutaArchivo))){
            listaChipBici = (List<ChipBici>)leer.readObject();
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(ClassCastException ex){
            System.out.println(ex.getMessage());
        }
        return listaChipBici;
    }

    /**
     * Método que escribe, en un archivo binario, una colección de objetos ChipBici serializables.
     * @param bicis Lista de objetos ChipBici serializables para almacenar en el archivo binario.
     */
    public void escribir(List bicis) {
        try(ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(rutaArchivo))){
            escribir.writeObject(bicis);
            escribir.flush();
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
       
    }

}
