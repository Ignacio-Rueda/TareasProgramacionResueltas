/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.io.*;

/**
 * Programa para trabajar con archivos de texto.
 * @profesorado
 */
public class Ejercicio1 {
    
    /**
    * Método principal.
    */
    public static void main(String args[]){

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
       
        
        // Variables de salida
        
        
        // Variables auxiliares
        
   
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
        System.out.println ();
	System.out.println ("Archivos cerrados y procesamento finalizado");
	System.out.println ("---------");
        
        
        System.out.println ();
	System.out.println ("Fin del programa.");
    }
    
    /**
     * 
     * @param notaT Nota de teoría que ha obtenido el alumno.
     * @param notaP Nota de las prácicas del alumno.
     * @param cT Coeficiente de lo que puntúa la teoría.
     * @param cP Coeficiente de lo que puntúan las prácticas.
     * @return Nota final del alumno.
     */
    public static double calcularNotaFinal(double notaT, double notaP, double cT, double cP){
        return (notaT*cT)/100 + (notaP*cP)/100;
    }
    
    /**
     * 
     * @param nota Nota final de un alumno.
     * @param aprobado Valor umbral entre el suspenso y el aprobado.
     * @param notable Valor umbral entre el aprobado y el notable.
     * @param sobresaliente Valor umbral entre el notable y el sobresaliente.
     * @return Nota del acta (Suspenso, Aprobado, Notable o Sobresaliente).
     */
    public static String calcularNotaActa(double nota, double aprobado, double notable, double sobresaliente){
        if(nota<aprobado)
            return "Suspenso";
        else if(nota<notable)
            return "Aprobado";
        else if(nota<sobresaliente)
            return "Notable";
        else
            return "Sobresaliente";
                    
    }
}
