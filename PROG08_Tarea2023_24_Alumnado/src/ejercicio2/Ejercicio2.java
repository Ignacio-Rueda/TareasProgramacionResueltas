package ejercicio2;

import java.time.LocalDate;
import java.util.List;

/**
 * Ejercicio 2: Lectura/Escritura de objetos. Serialización.
 *
 * @author profe
 */
public class Ejercicio2 {

    /**
     * Método principal.
     *
     * @param args argumentos que recibe el método
     */
    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        String ruta = System.getProperty("user.dir") + "/recursos/Recetario.dat";
        RecetarioIO bd;
        Recetario miRecetario;
        Receta receta1, receta2, receta3;
      
        // Variables de salida
        // Variables auxiliares
        //----------------------------------------------------------------------
        //                 Entrada de datos + Procesamiento + Salida 
        //----------------------------------------------------------------------
        try {
            // Creo un objeto Recetario y cinco objetos Receta.             
            miRecetario = new Recetario();
            receta1 = new Receta("Ensalada de Pimiento Dulce", "Ensalada",LocalDate.parse("2010-01-23"), 
                    List.of("pimientos dulces", "cebolla", "vinagre","aceite","sal","pimienta"),
                    "Se lavan 4 pimientos dulces, se les quita la parte superior y las semillas y se cortan en tiras."
                            + "Se pela la cebolla y se corta en tiras delgadas."
                            + "En un tazón grande, se mezcla el vinagre, el aceite, la sal y la pimienta."
                            + "Se añade el pimiento dulce y la cebolla y se revuelve hasta que quede todo cubierto."
                            + "Se cubre el tazón y se refrigera durante 30 minutos antes de servir.");
                    
            receta2 = new Receta("Calabacita fantástica", "Acompañamiento", LocalDate.parse("2000-02-02"),
                    List.of("calabacitas", "ajo en polvo", "sal","queso parmesano"),
                    "Se precalienta el horno a 375 grados."
                            + "Se cortan 2 calabacines en rodajas y se extienden en un molde para pastel."
                            + "Sobre las calabitas se rocían dos cucharadas de ajo en polvo,la sal y el queso."
                            + "Se hornea sin cubrir 40 minutos.");
             
            // Añado las recetas creadas al recetario.
            miRecetario.add(receta1);
            miRecetario.add(receta2);
            

            // Muestro por pantalla el listado de recetas que tiene el recetario.
            System.out.printf("He creado y almacenado en el archivo %d recetas.\n\n", miRecetario.numRecetas());
            System.out.println("LISTADO DE RECETAS GUARDADAS EN EL RECETARIO:");
            System.out.println(miRecetario.toString());
        
            // Escribo en el fichero binario a partir de la clase RecetarioIO.
            System.out.println("Escribiendo en el archivo Recetario.dat...");
            bd = new RecetarioIO(ruta);
            bd.escribir(miRecetario);

            // Creo una nueva receta 
            receta3 = new Receta("Pudin de almendras y arroz", "Postre",  LocalDate.parse("2010-01-23"),
                    List.of("leche de almendras", "arroz blanco", "azúcar","vainilla","extracto de almendras","canela","almendras tostadas"),
                    "Se combina 3 tazas de leche de almendras y una taza de arroz en una cacerola y se calienta hasta que hierva."
                            + "Se deja que hierva durante 45 minutos con la tapadera puesta."
                            + "Se añade 1/4 de taza de azúcar, 1 cucharadita de vainilla,1/4 de cucharadita de extracto de almendras y la canela."
                            + "Se revuelve y se sirve en caliente.");
                    
            // Añado las nueva receta al recetario
            miRecetario.add(receta3);
          
            // Muestro por pantalla las recetas que contiene el recetario.
            System.out.printf("\nAhora inserto 1 recetas más. Tengo %d recetas.\n\n",
                    miRecetario.numRecetas());
            System.out.println("LISTADO DE RECETAS GUARDADAS EN EL RECETARIO:");
            System.out.println(miRecetario);

            // Leo del archivo binario, almacenando su contenido en el objeto de tipo Recetario.
            miRecetario = bd.leer();

            // Muestro por pantalla las recetas del recetario (las que se han leído del archivo binario).
            System.out.printf("Leo del archivo %d recetas.\n\n", miRecetario.numRecetas());
            System.out.println("LISTADO DE RECETAS GUARDADAS EN EL FICHERO:");
            System.out.println(miRecetario);

        } catch (NullPointerException e) {
            System.out.printf(e.getMessage());
        }
    }
}
