package tienda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Carga en memoria una lista objetos de tipo Producto a partir del fichero
 * binario proporcionado y los muestra por consola tal y como se indica en el
 * ejemplo. El fichero .dat que te proporcionamos contiene una estructura de
 * tipo LinkedList serializada con esos diez productos de ejemplo. Una vez que
 * se tengan los productos en memoria, se generará el archivo de texto
 * productos_salida.txt donde cada producto estará representado por una línea.
 *
 * @author Profesor
 */
public class BinarioProductosToTexto {

    private static final String NOMBRE_ARCHIVO_ENTRADA_BIN_DEFAULT = "productos_entrada.dat";
    private static final String NOMBRE_ARCHIVO_PRODUCTOS_SALIDA = "productos_salida.txt";
    private static final String ruta = System.getProperty("user.dir") +File.separator + NOMBRE_ARCHIVO_ENTRADA_BIN_DEFAULT;
    private static final String rutaFicheroTexto = System.getProperty("user.dir") + File.separator+ NOMBRE_ARCHIVO_PRODUCTOS_SALIDA;

    /**
     * Programa principal de prueba de escritura de productos en un archivo de
     * texto
     *
     * @param args argumentos de la línea de ordenes
     */
    public static void main(String[] args) {
        File fichero = new File(ruta);
        File ficheroTexto = new File(rutaFicheroTexto);
        List<Producto> listaProductos = new LinkedList<>();
        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero))){
            listaProductos = (List<Producto>) entrada.readObject();
        }catch(ClassNotFoundException ex){
            ex.getMessage();
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        
        try(PrintWriter pw = new PrintWriter(new FileWriter(ficheroTexto))){
            for(int n=0;n<listaProductos.size();n++){
                String cadena =listaProductos.get(n).toString().replace(", ", "#");
                cadena = cadena.substring(1,cadena.length()-1);
                pw.print(cadena+"\n");
                pw.flush();
            }
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
