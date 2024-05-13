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
        return null;
        
    }

    /**
     * Método que escribe, en un archivo binario, una colección de objetos ChipBici serializables.
     * @param bicis Lista de objetos ChipBici serializables para almacenar en el archivo binario.
     */
    public void escribir(List bicis) {
       
    }

}
