/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.io.*;

/**
 * Programa para trabajar con archivos de texto.
 *
 * @Ignacio
 */
public class Ejercicio1 {

    /**
     * Método principal.
     */
    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final String rutaCoeficientes = System.getProperty("user.dir") + File.separator + "recursos" + File.separator + "coeficientes.txt";
        final String rutaListadoAlumnos = System.getProperty("user.dir") + File.separator + "recursos" + File.separator + "listadoAlumnos.txt";
        final String rutaActaAlumnos = System.getProperty("user.dir") + File.separator + "recursos" + File.separator + "acta.txt";
        

        // Variables de entrada
        double notaTeorica = 0.0;
        double notaPractica = 0.0;
        double aprobado = 0.0;
        double notable = 0.0;
        double sobresaliente =0.0;

        // Variables de salida
        // Variables auxiliares
        File fichero = new File(rutaCoeficientes);
        //Leer fichero coeficientes
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String cadena = "";
            while ((cadena = br.readLine()) != null) {
                String[] listaPonderacion = cadena.split(";");
                notaTeorica = Double.parseDouble(listaPonderacion[0]);
                notaPractica = Double.parseDouble(listaPonderacion[1]);
                aprobado = Double.parseDouble(listaPonderacion[2]);
                notable = Double.parseDouble(listaPonderacion[3]);
                sobresaliente = Double.parseDouble(listaPonderacion[4]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //Lectura listado alumnos
        File ficheroAlumnos = new File(rutaListadoAlumnos);
        File ficheroActas = new File(rutaActaAlumnos);
        try(BufferedReader br = new BufferedReader(new FileReader(ficheroAlumnos));
                PrintWriter pw = new PrintWriter(new FileWriter(ficheroActas))){
            String cadena = "";
            String nombreAlumno = "";
            String dni = "";
            double notaTeoricaAlumno = 0.0;
            double notaPracticaAlumno = 0.0;
            double calcularNotaFinal = 0.0;
            String calcularNotaActa = "";
            pw.write(String.format("%-30s%-20s%-15s%-15s%-15s%s%n",
                    "Nombre y apellidos",
                    "DNI",
                    "Nota teoría",
                    "Nota práct.",
                    "Nota final",
                    "Nota acta"));
            while((cadena = br.readLine())!= null){
                String [] listaDatosAlumno = cadena.split(";");
                nombreAlumno = listaDatosAlumno[0];
                dni = listaDatosAlumno[1];
                notaTeoricaAlumno = Double.parseDouble(listaDatosAlumno[2]);
                notaPracticaAlumno = Double.parseDouble(listaDatosAlumno[3]);
                calcularNotaFinal = calcularNotaFinal(notaTeoricaAlumno,notaPracticaAlumno,notaTeorica,notaPractica);
                calcularNotaActa = calcularNotaActa(calcularNotaFinal,aprobado,notable,sobresaliente);
                pw.write(String.format("%-30s%-20s%-15.2f%-15.2f%-15.2f%s%n",
                        nombreAlumno,
                        dni,
                        notaTeoricaAlumno,
                        notaPracticaAlumno,
                        calcularNotaFinal,
                        calcularNotaActa));
            }
            
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
       
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("Archivos cerrados y procesamento finalizado");
        System.out.println("---------");

        System.out.println();
        System.out.println("Fin del programa.");
    }

    /**
     *
     * @param notaT Nota de teoría que ha obtenido el alumno.
     * @param notaP Nota de las prácicas del alumno.
     * @param cT Coeficiente de lo que puntúa la teoría.
     * @param cP Coeficiente de lo que puntúan las prácticas.
     * @return Nota final del alumno.
     */
    public static double calcularNotaFinal(double notaT, double notaP, double cT, double cP) {
        return (notaT * cT) / 100 + (notaP * cP) / 100;
    }

    /**
     *
     * @param nota Nota final de un alumno.
     * @param aprobado Valor umbral entre el suspenso y el aprobado.
     * @param notable Valor umbral entre el aprobado y el notable.
     * @param sobresaliente Valor umbral entre el notable y el sobresaliente.
     * @return Nota del acta (Suspenso, Aprobado, Notable o Sobresaliente).
     */
    public static String calcularNotaActa(double nota, double aprobado, double notable, double sobresaliente) {
        if (nota < aprobado) {
            return "Suspenso";
        } else if (nota < notable) {
            return "Aprobado";
        } else if (nota < sobresaliente) {
            return "Notable";
        } else {
            return "Sobresaliente";
        }

    }
}
