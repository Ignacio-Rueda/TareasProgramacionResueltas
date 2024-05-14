package textos;

import cesar.TextoEncriptado;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Actividad2 {

    private final static String ruta = System.getProperty("user.dir") + File.separator + "texto_encriptado_entrada.dat";
    private final static String rutaDestino = System.getProperty("user.dir") + File.separator + "texto_en_claro_salida.txt";

    /**
     * Método principal
     *
     * @param args argumentos de la línea de ordenes
     */
    public static void main(String[] args) {
        //Deserializar
        File fichero = new File(ruta);
        List<TextoEncriptado> listaTextoEncriptado = new ArrayList<>();
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero))) {
            listaTextoEncriptado = (List<TextoEncriptado>) entrada.readObject();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        //Desencriptar y escribimos
        File ficheroDestino = new File(rutaDestino);

        try (PrintWriter pw = new PrintWriter(new FileWriter(ficheroDestino))) {
            for (int i = 0; i < listaTextoEncriptado.size(); i++) {
                pw.write(String.format("%s%n", listaTextoEncriptado.get(i).descifradoCesar()));
                pw.flush();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
