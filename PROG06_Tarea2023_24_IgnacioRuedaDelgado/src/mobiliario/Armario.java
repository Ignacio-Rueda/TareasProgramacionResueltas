
package mobiliario;


public final class Armario  extends Almacenaje{
    private final int numPuertas;
    
    public static final int MIN_PUERTAS = 1;
    public static final int MAX_PUERTAS = 6;
    public Armario(double Precio, String descripcion, double anchura, double altura, int numMaxModulos,int numPuertas) throws IllegalArgumentException {
        super(Precio, descripcion, anchura, altura, numMaxModulos);
        if(numPuertas < Armario.MIN_PUERTAS || numPuertas > Armario.MAX_PUERTAS){
            throw new IllegalArgumentException(String.format("No se puede crear el Armario. El número de puertas no está en el rango permitido: %d", numPuertas));
        }
        this.numPuertas = numPuertas;
    }
    
    public int getNumPuertas(){
        return this.numPuertas;
    }
    @Override
    public String toString(){
        return String.format("%s Número de puertas%d", super.toString(),this.numPuertas);
    }
}
