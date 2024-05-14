package tienda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que lee de un fichero binario, donde se grabó una list de objetos
 * Producto y muestra el contenido de lo leído por consola.
 */
public class BinarioProductosToConsola {

    private static final String NOMBRE_ARCHIVO_ENTRADA_BIN_DEFAULT = "productos_entrada.dat";
    private static final String ruta = System.getProperty("user.dir")+File.separator+NOMBRE_ARCHIVO_ENTRADA_BIN_DEFAULT;
    
    /**
     * Método principal
     *
     * @param args argumentos de la línea de ordenes
     */
    public static void main(String[] args) {
        File fichero = new File(ruta);
        List<Producto> listaProductos = new LinkedList<>();
        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero))){
            listaProductos = (List<Producto>)entrada.readObject();
            System.out.println("CONTENIDO DEL ARCHIVO BINARIO");
            System.out.println("-----------------------------");
            System.out.printf("Total productos: %d%n",listaProductos.size());
            for(int n=0;n<listaProductos.size();n++){
                System.out.printf("PRODUCTO %d: %s%n",n+1,listaProductos.get(n));
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