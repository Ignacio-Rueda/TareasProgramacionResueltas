
package mobiliario;


public final class Sillon extends Asiento implements Ajustable{
    private int numPosAsiento;
    
    public final static int POS_BAJADO = 0;
    public final static int POS_SUBIDO = 1;
    
    public Sillon(double Precio, String descripcion, String tapiceria, String color) throws IllegalArgumentException {
        super(Precio, descripcion, Asiento.MIN_PLAZAS, tapiceria, color);
        this.numPosAsiento = Sillon.POS_BAJADO;
    }

    @Override
    public String toString(){
        return String.format("%s Posición actual de los pies:%s",
                    super.toString(),
                    this.numPosAsiento>0?"Subido":"Bajado"
                );
    }
    
    @Override
    public int obtenerPosicion() {
        return this.numPosAsiento;
    }

    @Override
    public int subirPosicion() throws IllegalStateException {
        int posAsubir = this.numPosAsiento;
        if(++posAsubir >Sillon.POS_SUBIDO){
            throw new IllegalStateException("Error: no se pueden subir los pies del sillón. Ya están subidos");
        }
        
        this.numPosAsiento = posAsubir;
        return this.numPosAsiento;
    }

    @Override
    public int bajarPosicion() throws IllegalStateException {
        int posAbajar = this.numPosAsiento;
        
        if(--posAbajar<Sillon.POS_BAJADO){
            throw new IllegalStateException("Error: no se pueden bajar los pies del sillón. Ya están bajados");
        }
        
        this.numPosAsiento = posAbajar;
        return posAbajar;
    }
    
}
