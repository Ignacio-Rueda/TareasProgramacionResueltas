package ejercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Clase Persona. Contiene la información de una persona.
 * @author salva
 */
public class Producto {
    private final String nombre;
    private final LocalDate caducidad;
    private final double precio;
    
    public Producto(String nombre, LocalDate caducidad, double precio)
    {
        this.caducidad=caducidad;
        this.nombre=nombre;
        this.precio= precio;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getCaducidad() {
        return this.caducidad;
    }
    
    public double getPrecio() {
        return this.precio;
    }
      
    @Override
    public String toString() {
        return String.format ("{%-10s, %02d/%02d/%4d, %.2f}", 
                this.getNombre(),
                this.caducidad.getDayOfMonth(), this.caducidad.getMonthValue(), this.caducidad.getYear(),               
                this.getPrecio());
    }
}


