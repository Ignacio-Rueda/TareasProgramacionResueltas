package tarea07;

import java.util.HashSet;
import java.util.Set;

/**
 * Ejercicio 1. Creando jardín botánico
 *
 * @author Profesor
 */
public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int CANTIDAD_ESPECIES_PLANTAS = 5;
        // Variables de entrada

        // Variables auxiliares
        int contador1 = 0;//Contador para plantas almacenadas
        int contador2 = 0;//Contador para plantas almacenadas
        Set<String> plantasAleatorias1 = new HashSet<>();
        Set<String> plantasAleatorias2 = new HashSet<>();
        Set<String> unionPlantas;
        Set<String> interseccionPlantas;
        Set<String> diferenciaPlantas;
        // Variables de salida

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // No hay, pues se usa un número fijo de elementos aleatorios
        System.out.println("CONJUNTOS DE ESPECIES DE PLANTAS");
        System.out.println("--------------------------------");

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        // Rellenamos los conjuntos con especies de plantas aleatorias hasta que haya CANTIDAD_ESPECIES_PLANTAS
        while (contador1 < CANTIDAD_ESPECIES_PLANTAS) {
            String planta = Utilidades.especiePlantaAleatoria();
            if (!plantasAleatorias1.contains(planta)) {
                plantasAleatorias1.add(planta);
                contador1++;
            }
        }
        while (contador2 < CANTIDAD_ESPECIES_PLANTAS) {
            String planta = Utilidades.especiePlantaAleatoria();
            if (!plantasAleatorias2.contains(planta)) {
                plantasAleatorias2.add(planta);
                contador2++;
            }
        }

        // Unión de los dos conjuntos
        unionPlantas = new HashSet<>(plantasAleatorias1);
        interseccionPlantas = new HashSet<>(plantasAleatorias1);
        diferenciaPlantas = new HashSet<>(plantasAleatorias2);
        
        unionPlantas.addAll(plantasAleatorias2);
        // Intersección de los conjuntos
        interseccionPlantas.retainAll(plantasAleatorias2);
        // Diferencia de los conjuntos
        diferenciaPlantas.removeAll(plantasAleatorias1);
        //----------------------------------------------
        //              Salida de Resultados 
        //----------------------------------------------
        // Recorremos el conjunto y mostramos su contenido por pantalla
        System.out.printf("Conjunto C1: %s%n", plantasAleatorias1);
        System.out.printf("Conjunto C2: %s%n", plantasAleatorias2);
        System.out.printf("Unión C1 y C2: %s%n", unionPlantas);
        System.out.printf("Intersección C1 y C2: %s%n", interseccionPlantas);
        System.out.printf("Diferencia C2-12: %s%n", diferenciaPlantas);
    }
}
