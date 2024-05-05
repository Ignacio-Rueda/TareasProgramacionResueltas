package tarea07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

/**
 * Ejercicio 3. Calendario de especies de plantas
 *
 * @author Ignacio
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        final int DIAS_SEMANA = 7;
        // Variables de entrada

        // Variables auxiliares
        LocalDate fechaActual = LocalDate.now().minusDays(1);
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int contadorDias = 1;
        Map<LocalDate, String> calendario = new TreeMap<>();
        // Variables de salida

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("CALENDARIO DE ESPECIES DE PLANTAS");
        System.out.println("---------------------------------");

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        while(contadorDias<DIAS_SEMANA){
            String planta = Utilidades.especiePlantaAleatoria();
            if (!calendario.containsValue(planta)) {
                calendario.put(fechaActual.plusDays(contadorDias), planta);
                contadorDias++;
            }

        }
        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        for (Map.Entry<LocalDate, String> pos : calendario.entrySet()) {
            System.out.printf("Fecha "+pos.getKey().format(formatoFecha) + ": " + pos.getValue() + "\n");
        }

    }
}
