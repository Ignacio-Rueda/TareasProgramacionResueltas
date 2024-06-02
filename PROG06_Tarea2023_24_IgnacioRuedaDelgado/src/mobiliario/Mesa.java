
package mobiliario;


public class Mesa extends Mueble{
    private final String forma;
    private final int numComensales;
    
    public static final int MAX_COMENSALES = 16;
    public static final int MIN_COMENSALES = 4;
    public Mesa(double precio, String descripcion,String forma,int numComensales) throws IllegalArgumentException {
        super(precio, descripcion);
        if(numComensales < Mesa.MIN_COMENSALES || numComensales > Mesa.MAX_COMENSALES){
            throw new IllegalArgumentException(String.format("El número de comensales no está en el rango permitido %d",numComensales));
        }
        this.forma = forma;
        this.numComensales = numComensales;
    }
    public String getForma(){
        return this.forma;
    }
    
    public int getComensales(){
        return this.numComensales;
    }
    
    @Override
    public String toString(){
        return String.format("%s Forma %s Num comensales%d", super.toString(),this.forma,this.numComensales);
    }
}
