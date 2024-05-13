package tarea07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ejercicio 4. Clasificación de especies de plantas coincidentes (con el mismo
 * nombre y en la misma posición)
 *
 * @author Ignacio
 */
public class Ejercicio04 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // Variables auxiliares
        List<String> plantasAleatorias1 = new ArrayList<>(Arrays.asList("PERENNE", "HORTALIZA", "ARBOL", "GRAMINEA", "FLOR", "SUCULENTA", "BULBO", "BULBO", "HIERBA_AROMATICA", "ARBOL", "BULBO", "SUCULENTA", "SUCULENTA", "FLOR", "ARBOL", "SUCULENTA", "SUCULENTA", "PERENNE", "PERENNE", "GRAMINEA"));
        List<String> plantasAleatorias2 = new ArrayList<>(Arrays.asList("GRAMINEA", "FLOR", "FLOR", "ARBUSTO", "PERENNE", "ARBUSTO", "BULBO", "BULBO", "ARBOL", "PERENNE", "BULBO", "HIERBA_AROMATICA", "SUCULENTA", "HIERBA_AROMATICA", "BULBO", "HIERBA_AROMATICA", "GRAMINEA", "GRAMINEA", "ARBUSTO", "GRAMINEA"));

        Map<String, List<Integer>> especiesPlantas = new HashMap<>();
        // Variables de salida
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("CLASIFICACIÓN DE COINCIDENTES");
        System.out.println("-----------------------------");

        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------
        for (int n = 0; n < plantasAleatorias1.size(); n++) {
            boolean coincidencia = false;
            if (plantasAleatorias1.get(n).equals(plantasAleatorias2.get(n))) {
                coincidencia = true;
            }
            if (coincidencia) {
                if (!especiesPlantas.containsKey(plantasAleatorias1.get(n))) {
                    especiesPlantas.put(plantasAleatorias1.get(n), new ArrayList<>());
                }
                especiesPlantas.get(plantasAleatorias1.get(n)).add(n);
            }
        }

        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        System.out.println(especiesPlantas);
    }
}
