package tarea07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Ejercicio 5. Ordenación de especies de plantas (por nombre y longitud)
 *
 * @author Ignacio
 */
public class Ejercicio05 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        final int NUM_ELEMENTOS = 5;

        // Variables de entrada
        // Variables auxiliares
        int contador = 0;
        List<String> especiesPlantas = new ArrayList<>();
        // Variables de salida

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("ORDENACIÓN DE ESPECIES DE PLANTAS");
        System.out.println("---------------------------------");

        //----------------------------------------------
        //     Procesamiento + Salida de resultados
        //----------------------------------------------
        while (contador < NUM_ELEMENTOS) {
            String planta = Utilidades.especiePlantaAleatoria();
            if (!especiesPlantas.contains(planta)) {
                especiesPlantas.add(planta);
                contador++;
            }
        }

        System.out.println("Contenido inicial de la lista:");

        for (int n = 0; n < especiesPlantas.size(); n++) {
            System.out.println(n+1+". "+especiesPlantas.get(n));
        }
        
        System.out.println("Ordenación de la lista por nombre (alfabético)");
        Collections.sort(especiesPlantas, new ComparadorEspeciePlantaPorNombre());
        for (int n = 0; n < especiesPlantas.size(); n++) {
            System.out.println(n+1+". "+especiesPlantas.get(n));
        }
        
        System.out.println("Ordenación de la lista por longitud");
        Collections.sort(especiesPlantas,new ComparadorEspeciePlantaPorLongitud());
        for (int n = 0; n < especiesPlantas.size(); n++) {
            System.out.println(n+1+". "+especiesPlantas.get(n));
        }
    }
}

class ComparadorEspeciePlantaPorNombre implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}

class ComparadorEspeciePlantaPorLongitud implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}
