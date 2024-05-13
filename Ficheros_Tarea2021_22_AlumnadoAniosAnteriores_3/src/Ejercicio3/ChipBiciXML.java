package Ejercicio3;

import java.io.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;

public class ChipBiciXML {

    /**
     * Ruta del archivo donde se lee y escribe la colección de objetos ChipBici
     */
    private String rutaArchivo;
    /**
     * Objeto Xstream que permite la L/E con archivos XML
     */
    private XStream xstream;

    /**
     * Método constructor
     * @param archivo Ruta del archivo donde se lee y escribe la colección de objetos ChipBici
     */
    public ChipBiciXML(String nombreArchivo) {
        super();
        this.rutaArchivo = nombreArchivo;
        xstream = new XStream();
        //Permite asignar privilegios para poder operar con los archivos XML
        xstream.allowTypesByWildcard(new String[] { 
            "Ejercicio3.**",
            "com.mydomain.utilitylibraries.**"
        });
    }

    /**
     * Método que escribe, en un archivo binario, una colección de objetos ChipBici serializables.
     * @param bicis Lista de objetos ChipBici serializables para almacenar en el archivo binario.
     */
    public void escribir(List bicis) {
        
    }

    /**
     * Método que lee, desde un archivo binario, una colección de objetos ChipBici serializados.
     * @return Lista de objetos ChipBici que estaba almacenada en el archivo binario.
     */
    public List leer() {
        return null;
    }
}
