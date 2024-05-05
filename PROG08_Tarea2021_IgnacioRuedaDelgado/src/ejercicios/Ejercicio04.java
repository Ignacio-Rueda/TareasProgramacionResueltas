package ejercicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Ejercicio04 {

    public static void main(String[] args) {
       final int NUM_DIAS = 7;
       LocalDate fecha = LocalDate.of(2021, 03,01);
       String[] arrayPersonas = {"Juan", "Luisa", "Clara", "Rogelio", "Francisco"};
       
       Map<LocalDate,List<String>> mapTurnosPorFecha = new TreeMap<>();
       for(int n=0;n<NUM_DIAS;n++){
           mapTurnosPorFecha.put(fecha.plusDays(n),new ArrayList<>());
       }


    }

}
