package ejercicios;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio01 {
    
    
    public static void main(String[] args) {
        //Declaración de constantes
        final int NUM_ALEATORIOS = 10;
        Set<Integer> conjuntoAleatorios = new HashSet<>();
        
        while(conjuntoAleatorios.size()<NUM_ALEATORIOS){
            int num =(int) (1+Math.random()*20);
            conjuntoAleatorios.add(num);
        }
        
        System.out.println("COMBINACIÓN ALEATORIA");
        System.out.println("---------------------");
        System.out.println("Los números son: ");
        for(Integer n:conjuntoAleatorios){
            System.out.print(n+" ");
        }

        
    }
   
}
