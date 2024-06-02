package mobiliario;

public abstract class Mueble {

    private final int identificador;
    protected double precio;
    private final String desripcion;

    private static int contadorIdentificador;

    public static final double MIN_PRECIO = 0.01;
    public static final double MAX_PRECIO = 10000.00;

    //Constructor
    
    public Mueble(double precio,String descripcion)throws IllegalArgumentException{
       if(precio < Mueble.MIN_PRECIO || precio > Mueble.MAX_PRECIO){
           throw new IllegalArgumentException(String.format("ERROR: El precio no está en el rango permitido: %.2f", precio));
       } 
       this.precio = precio;
       this.desripcion = descripcion;
       this.identificador = ++Mueble.contadorIdentificador;
    }
    
    
    //Declaración de los métodos
    public int getId() {
        return this.identificador;
    }

    public double getPrecio() {
        return this.precio;
    }

    public String getDescripcion() {
        return this.desripcion;
    }

    @Override
    public String toString() {
        return String.format("Tipo: %-11s Id:%d Precio:%8.2f Descripcion:%-20s",
                getClass().getSimpleName(),
                this.identificador,
                this.precio,
                this.desripcion
        );
    }

}
