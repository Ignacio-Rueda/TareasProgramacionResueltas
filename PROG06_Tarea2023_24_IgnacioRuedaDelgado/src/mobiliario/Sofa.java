
package mobiliario;


public final class Sofa extends Asiento{
    private String composicion;
    public Sofa(double Precio, String descripcion, int numPlazas, String tapiceria, String color,String composicion) throws IllegalArgumentException {
        super(Precio, descripcion, numPlazas, tapiceria, color);
        this.composicion = composicion;
    }
    
    public String getComposicion(){
        return this.composicion;
    }
    
    @Override 
    public String toString(){
        return String.format("%s Composición%s",
                super.toString(),
                this.composicion
                );
    }
    
    
    
}
