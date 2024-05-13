package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ejercicio02 {

    public static void main(String[] args) {
        List<Integer> listaNumeros = new ArrayList<>();
        final int NUM_ALEATORIOS = 12;

        while (listaNumeros.size() < NUM_ALEATORIOS) {
            int num = (int) (1 + Math.random() * 5);
            listaNumeros.add(num);
        }
        System.out.println("VACIADO DE LISTA");
        System.out.println("----------------");
        System.out.printf("Contenido inicial de la lista %s%n", listaNumeros);
        System.out.printf("Procedemos a ir vaciando su contenido.%n%n");

        while (listaNumeros.size() > 0) {
            Iterator it = listaNumeros.iterator();
            Integer numAeliminar = listaNumeros.get(0);
            System.out.printf("Eliminamos todas las aparicionesdel primer elemento:%d%n", numAeliminar);
            while (it.hasNext()) {
                if (it.next() == numAeliminar) {
                    it.remove();
                }
            }
            System.out.printf("Lista resultante: %s%n", listaNumeros);
        }
    }

}
