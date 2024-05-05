package tarea07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Ejercicio 2. Búsqueda de especies de plantas populares
 *
 * @author Ignacio
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int CANTIDAD_ESPECIES_PLANTAS = 10;
        // Variables de entrada

        // Variables auxiliares
        int contador = 0;
        // Variables de salida
        List<String> listaPlantas1 = new ArrayList<>();
        List<String> listaPlantas2 = new ArrayList<>();
        List<String> listaPlantasPopulares = new ArrayList<>();
        Set<String> conjuntoPlantasPopulares = new HashSet<>();
        List<Integer> listaPosicionesPlantasPopulares = new ArrayList<>();

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("BÚSQUEDA DE ESPECIES DE PLANTAS POPULARES");
        System.out.println("-----------------------------------------");

        // No hay, pues se usa un número fijo de elementos aleatorios
        // Rellenamos la lista con aleatorios hasta que haya CANTIDAD_ESPECIES_PLANTAS
        for (int n = 0; n < CANTIDAD_ESPECIES_PLANTAS; n++) {
            listaPlantas1.add(Utilidades.especiePlantaAleatoria());
            listaPlantas2.add(Utilidades.especiePlantaAleatoria());
        }

        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------
        System.out.printf("1. Contenido inicial de la lista 1: %s%n", listaPlantas1);
        System.out.printf("2. Contenido inicial de la lista 2: %s%n%n", listaPlantas2);

        // Recorremos a la vez las dos listas
        /*for (int n = 0; n < listaPlantas1.size(); n++) {
            if (listaPlantas1.get(n).equals(listaPlantas2.get(n))) {
                listaPlantasPopulares.add(listaPlantas1.get(n));
                conjuntoPlantasPopulares.add(listaPlantas1.get(n));
                String planta = "*" + listaPlantas1.get(n) + "*";
                listaPlantas1.set(n, planta);
                listaPlantas2.set(n, planta);
                listaPosicionesPlantasPopulares.add(n);
            }

        }*/
        
        Iterator <String> it1 = listaPlantas1.iterator();
        Iterator <String> it2 = listaPlantas2.iterator();
        
        while(it1.hasNext()){
            String plantaLista1 = it1.next();
            String plantaLista2 = it2.next();
           if(plantaLista1.equals(plantaLista2) ){
               listaPlantas1.set(contador, "*"+plantaLista1+"*");
               listaPlantas2.set(contador, "*"+plantaLista2+"*");
               listaPlantasPopulares.add(plantaLista1);
               conjuntoPlantasPopulares.add(plantaLista1);
               listaPosicionesPlantasPopulares.add(contador);
           }
           contador++;
       
        }

        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        System.out.printf("1. Contenido final de la lista 1: %s%n", listaPlantas1);
        System.out.printf("2. Contenido final de la lista 2: %s%n", listaPlantas2);
        System.out.printf("3. Contenido final de la lista de especies de plantas populares: %s%n", listaPlantasPopulares);
        System.out.printf("4. Contenido final de la lista de posicones populares: %s%n", listaPosicionesPlantasPopulares);
        System.out.printf("5. Contenido final del conjunto de especies de plantas populares: %s%n", conjuntoPlantasPopulares);

    }
}
