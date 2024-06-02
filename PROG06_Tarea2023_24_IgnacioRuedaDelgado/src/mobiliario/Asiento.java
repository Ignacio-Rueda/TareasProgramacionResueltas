
package mobiliario;

public abstract class Asiento extends Mueble {
    private final int numPlazas;
    private final String tapiceria;
    private final String color;
    
    public static final int MIN_PLAZAS = 1;
    public static final int MAX_PLAZAS = 9;
    
    
    public Asiento(double Precio, String descripcion,int numPlazas,String tapiceria,String color) throws IllegalArgumentException {
        super(Precio, descripcion);
        if(numPlazas < Asiento.MIN_PLAZAS || numPlazas > Asiento.MAX_PLAZAS){
            throw new IllegalArgumentException(String.format("El número de plazas no está en el rango permitido: %d",numPlazas));
        }
        this.numPlazas = numPlazas;
        this.tapiceria = tapiceria;
        this.color = color;
    }
    
    
    //Declaración de métodos
    
    public int getNumPlazas(){
        return this.numPlazas;
    }
    
    public String getTapiceria(){
        return this.tapiceria;
    }
    
    public String getColor(){
        return this.color;
    }
    
    //Ampliar método toString
    
    @Override
    public String toString(){
        return String.format("%s Tapicería:%s Color:%s Número de plazas:%d", 
                super.toString(),
                this.tapiceria,
                this.color,
                this.numPlazas
        );
    
    }
}
