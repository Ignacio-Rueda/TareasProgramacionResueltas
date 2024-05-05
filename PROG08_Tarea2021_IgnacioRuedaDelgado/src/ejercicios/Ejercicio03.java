package ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio03 {

    public static void main(String[] args) {
        final int NUM_COLORES = 10;
        String[] arrayColores = {"Negro", "Blanco", "Rojo", "Verde", "Azul", "Amarillo"};
        Map<String, Integer> colorAparicion = new HashMap<>();
        List<String> listaColores = new ArrayList<>();
        //Rellenar mapa.
        for (int n = 0; n < arrayColores.length; n++) {
            colorAparicion.put(arrayColores[n], 0);
        }
        //Rellenar lista
        while (listaColores.size() < NUM_COLORES) {
            int posColor = (int) (Math.random() * 6);
            listaColores.add(arrayColores[posColor]);
        }

        System.out.println("MAPA DE COLORES");
        System.out.println("---------------");
        System.out.println("Contenido inicial del mapa de colores:");
        System.out.println(colorAparicion);
        System.out.println("Lista de colores aleatorios");
        System.out.println(listaColores + "\n\n");
        System.out.println("Procedemos a rellenar el mapa de colores con el número de veces que aparece cada color (frecuencia)\n");

        for (int i = 0; i < arrayColores.length; i++) {
            String color = arrayColores[i];
            int numApariciones = 0;
            for (int j = 0; j < listaColores.size(); j++) {
                if (listaColores.get(j).equals(color)) {
                    numApariciones++;
                }
            }
            colorAparicion.put(color, numApariciones);
        }
        System.out.println("Contenido final del mapa de colores");
        System.out.println(colorAparicion);

    }

}
