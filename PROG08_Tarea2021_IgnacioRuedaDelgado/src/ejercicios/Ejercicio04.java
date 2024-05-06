package ejercicios;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Ejercicio04 {

    public static void main(String[] args) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        final int NUM_DIAS = 7;
        LocalDate fecha = LocalDate.of(2021, 03, 01);
        String[] arrayPersonas = {"Juan", "Luisa", "Clara", "Rogelio", "Francisco"};
        /**
         * las claves serán fechas (objetos de tipo LocalDate); los elementos
         * serán listas que contengan nombres de personas (objetos de tipo List.
         */
        Map<LocalDate, List<String>> mapTurnosPorFecha = new TreeMap<>();
        for (int n = 0; n < NUM_DIAS; n++) {
            mapTurnosPorFecha.put(fecha.plusDays(n), new ArrayList<>());
        }
        /**
         * las claves serán las fechas desde el 1 de marzo al 7 de marzo de 2021
         * (objetos de tipo LocalDate); los elementos serán listas vacías, aún
         * sin contener nombres de personas.
         * Cada fecha tendrá asociada tres
         * personas para trabajar ese día. Comenzaremos asignando a la primera
         * persona del array y continuaremos de manera secuencial siguiendo el
         * orden de los nombres en el array. Cuando se vayan a superar los
         * límites del array se volverá a la primera posición (recuerda la
         * utilidad del operador módulo % para estos casos). la primera persona
         * asignada en una fecha no será asignada para el día siguiente, de
         * manera que de un día para otro coincidirán la segunda y tercera
         * persona del día anterior, que serán ahora primera y segunda, y habrá
         * una tercera persona nueva.
         */
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
            System.out.printf("Asignando a la fecha %s la persona %s%n",strFecha,arrayPersonas[pos0]);
            System.out.printf("Asignando a la fecha %s la persona %s%n",strFecha,arrayPersonas[pos1]);
            System.out.printf("Asignando a la fecha %s la persona %s%n%n",strFecha,arrayPersonas[pos2]);
            
            n++;
        }
        System.out.println("Contenido final del mapa de turnos:");
        for(Map.Entry<LocalDate,List<String>> pareja : mapTurnosPorFecha.entrySet()){
            System.out.printf("Fecha %s: %s%n",pareja.getKey().format(formatoFecha),pareja.getValue());
        }


    }

}
