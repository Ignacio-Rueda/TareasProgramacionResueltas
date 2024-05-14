package textos;

import cesar.TextoEncriptado;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Actividad3 {

    final static private String rutaFichero = System.getProperty("user.dir") + File.separator + "texto_en_claro_salida.txt";

    /**
     * Método principal
     *
     * @param args argumentos de la línea de ordenes
     */
    public static void main(String[] args) {
        File fichero = new File(rutaFichero);
        List<TextoEncriptado> listaEncriptada = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String cadena = "";
            int clave = 0;
            while ((cadena = br.readLine()) != null) {
                listaEncriptada.add(new TextoEncriptado(cadena, ++clave));
            }
            System.out.println("CONTENIDO DEL ARCHIVO DE TEXTO");
            System.out.println("------------------------------");
            System.out.printf("Total de oraciones leídas %d%n", listaEncriptada.size());
            for (int j = 0; j < listaEncriptada.size(); j++) {
                String oracion = listaEncriptada.get(j).getTexto();
                int contadorPalabras =0;
                for (int i = 0; i < oracion.length(); i++) {
                    if(i>0 && oracion.charAt(i)==' ' && oracion.charAt(i-1)!=' '){
                        contadorPalabras++;
                    }
                }
                System.out.printf("ORACIÓN %d - %d palabras: %s%n", j + 1, contadorPalabras+1, oracion);
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
