package tienda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Programa de prueba de carga de productos a partir de un archivo de texto
 */
public class TextoProductosToConsola {

    private static final String NOMBRE_ARCHIVO_ENTRADA_TXT_DEFAULT = "productos_entrada.txt";
    private static final String rutaFichero = System.getProperty("user.dir") + File.separator + NOMBRE_ARCHIVO_ENTRADA_TXT_DEFAULT;

    /**
     * Método principal
     *
     * @param args argumentos de la línea de ordenes
     */
    public static void main(String[] args) {

        File fichero = new File(rutaFichero);
        List<Producto> listaProductos = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String expresionRegular = "[0-9]{0,}::[(A-z)||(1-9)|| ]{0,}::[(A-z)||(1-9)|| ]{0,}::[0-9]{1,}.[0-9]{2}";
            String cadena = "";
            while ((cadena = br.readLine()) != null) {
                if (cadena.matches(expresionRegular)) {
                    String[] arrayDatos = cadena.split("::");
                    String id = arrayDatos[0];
                    String nombre = arrayDatos[1];
                    String descripcion = arrayDatos[2];
                    Double precio = Double.parseDouble(arrayDatos[3]);
                    listaProductos.add(new Producto(id, nombre, descripcion, precio));
                }
            }
            System.out.println("CONTENIDO DEL ARCHIVO DE TEXTO");
            System.out.println("------------------------------");
            System.out.printf("Total de productos %s%n",listaProductos.size());
            for (int n = 0; n < listaProductos.size(); n++) {
                System.out.printf("PRODUCTO %d%s%n", n + 1, listaProductos.get(n));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
