package ejercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Ejercicio05 {

    public static void main(String[] args) {

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        final int NUM_DIAS = 7;
        LocalDate fecha = LocalDate.of(2021, 03, 01);
        String[] arrayPersonas = {"Juan", "Luisa", "Clara", "Rogelio", "Francisco"};

        Map<LocalDate, List<String>> mapTurnosPorFecha = new TreeMap<>();
        for (int n = 0; n < NUM_DIAS; n++) {
            mapTurnosPorFecha.put(fecha.plusDays(n), new ArrayList<>());
        }

        int n = 0;
        while (n < mapTurnosPorFecha.size()) {
            int pos0 = n % arrayPersonas.length;
            int pos1 = (pos0 + 1) % arrayPersonas.length;
            int pos2 = (pos0 + 2) % arrayPersonas.length;
            List<String> listaUsuarios = new ArrayList<>();
            listaUsuarios.add(arrayPersonas[pos0]);
            listaUsuarios.add(arrayPersonas[pos1]);
            listaUsuarios.add(arrayPersonas[pos2]);
            mapTurnosPorFecha.put(fecha.plusDays(n), listaUsuarios);
            String strFecha = fecha.plusDays(n).format(formatoFecha);
            n++;
        }
        System.out.println("Contenido inicial del mapa de turnos organizados por fecha:");
        for (Map.Entry<LocalDate, List<String>> pareja : mapTurnosPorFecha.entrySet()) {
            System.out.printf("Fecha %s: %s%n", pareja.getKey().format(formatoFecha), pareja.getValue());
        }
//*****************************************************************************************************************************************//

        /**
         * Partiendo del resultado obtenido por el ejercicio anterior,
         * implementa un programa en Java que explore la estructura de datos que
         * contiene la asignación de turnos organizados por fechas y genere una
         * nueva estructura de datos que contenga la asignación de turnos
         * organizados por personas; Es decir, que se rellene una estructura de
         * tipo Map, en este caso llamada mapTurnosPorPersona, donde->
         *
         * las claves sean los nombres de las personas (objetos de tipo String);
         * los elementos serán listas de fechas (objetos de tipo List).
         */
        //Organización de turnos organizados por personas
        Map<String, List<LocalDate>> mapTurnosPersona = new TreeMap<>();
        System.out.println("Procedemos a explorar la estructura de turnos por fechas para generar la estructura de turnos por personas:\n\n");
        for (Map.Entry<LocalDate, List<String>> turnosPorFecha : mapTurnosPorFecha.entrySet()) {

            List<String> nombrePersona = turnosPorFecha.getValue();
            for (int j = 0; j < nombrePersona.size(); j++) {
                if (!mapTurnosPersona.containsKey(nombrePersona.get(j))) {
                    System.out.printf("Encontramos persona %s por primera vez. Creamos una entrada en el mapa para ella con una lista de fechas vacía%n",nombrePersona.get(j));
                    mapTurnosPersona.put(nombrePersona.get(j), new ArrayList<>());
                }
                LocalDate fechaObtenida = turnosPorFecha.getKey();
                System.out.printf("Asignando a la persona %s la fecha %s%n",nombrePersona.get(j),fechaObtenida.format(formatoFecha));
                List<LocalDate> listaFechas = mapTurnosPersona.get(nombrePersona.get(j));
                listaFechas.add(fechaObtenida);
                mapTurnosPersona.put(nombrePersona.get(j), listaFechas);
            }
            System.out.println("");
        }

    
        System.out.println("Contenido final del mapa de turnos organizado por personas:");
        for(Map.Entry<String,List<LocalDate>> parejas : mapTurnosPersona.entrySet()){
            System.out.printf("Persona %s: %s%n",parejas.getKey(),parejas.getValue());
        }
    
    
    }

}
