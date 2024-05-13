package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ejercicio 1: Lectura/escritura de un recetario en ficheros de texto.
 *
 * @author profe
 */
public class Ejercicio1 {

    /**
     * Método principal.
     *
     * @param args argumentos que recibe el método
     */
    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final String rutaRecetas = System.getProperty("user.dir") + "/recursos/ListadoRecetas.txt";
        final String rutaRecetatio = System.getProperty("user.dir") + "/recursos/Recetario.txt";
        // Variables de entrada
        // Variables de salida
        // Variables auxiliares
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/YYYY");

        //----------------------------------------------
        //       Entrada de datos + Procesamiento
        //----------------------------------------------
        // Abrimos archivo de contactos ListadoRecetas.txt
        System.out.println("Abriendo archivo de recetas...");
        Recetario recetario = new Recetario();
        File fichero = new File(rutaRecetas);
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String cadena = "";
            while ((cadena = br.readLine()) != null) {
                List<String> listaIngredientes = new ArrayList<>();
                String[] recetas = cadena.split(";");
                String nombre = recetas[0];
                String tipoPlato = recetas[1];
                LocalDate fechaCreacion = LocalDate.parse(recetas[2]);
                String[] arrayIngredientes = recetas[3].split(",");
                for (String ingrediente : arrayIngredientes) {
                    listaIngredientes.add(ingrediente);
                }
                String instrucciones = recetas[4];

                recetario.add(new Receta(nombre, tipoPlato, fechaCreacion, listaIngredientes, instrucciones));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Cerrando archivo de recetas...");

        System.out.println();

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        // Abrimos el archivo de la agenda Recetario.txt
        System.out.println("Abriendo archivo del recetario...");
        File ficheroDestino = new File(rutaRecetatio);
        String strRecetario = recetario.toString();
        System.out.println(strRecetario);
        try (PrintWriter pw = new PrintWriter(new FileWriter(ficheroDestino))) {
            pw.write("***********************************************************************************************\n");
            pw.write("LIBRO DE RECETAS\n");
            pw.write("***********************************************************************************************\n");
            String[] arrayRecetario = strRecetario.split("\n");//Obtenemos valor por línea
            for (String elemento : arrayRecetario) {
                String[] elementosRecetario = elemento.split(";");//Elementos individuales por línea
                String nombre = elementosRecetario[0].substring(1, elementosRecetario[0].length());
                String tipoPlato = elementosRecetario[1];
                LocalDate fechaCreacion = LocalDate.parse(elementosRecetario[2]);
                String ingredientes = elementosRecetario[3];
                String[] instrucciones = elementosRecetario[4].split("\\.");
                pw.write(String.format("NOMBRE DE LA RECETA:%s%n",nombre));
                pw.write(String.format("TIPO DE PLATO:%s%n",tipoPlato));
                pw.write(String.format("FECHA DE CREACIÓN:%s%n",fechaCreacion.format(formatoFecha)));
                pw.write(String.format("INGREDIENTES:%s%n",ingredientes ));
                pw.write("INSTRUCCIONES" + "\n");
                for (int n = 0; n < instrucciones.length; n++) {
                    pw.write(String.format("%d.- %s.%n", n + 1, instrucciones[n]));
                }
                pw.write("***********************************************************************************************\n");
            }
            pw.flush();

        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Cerrando archivo del recetario...");

        System.out.println();
        System.out.println("Archivos cerrados y procesamiento finalizado");
        System.out.println("---------");
        System.out.println();
        System.out.println("Fin del programa.");
    }
}
