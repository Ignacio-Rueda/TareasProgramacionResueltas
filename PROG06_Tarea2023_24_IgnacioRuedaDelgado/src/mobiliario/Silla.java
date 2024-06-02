
package mobiliario;


public final class Silla extends Asiento implements Ajustable{
    private int numPosicionRespaldo;
    
    public static int MIN_POSICION = 1;
    public static int MAX_POSICION = 4;

    public Silla(double Precio, String descripcion, String tapiceria, String color) throws IllegalArgumentException {
        super(Precio, descripcion, Asiento.MIN_PLAZAS, tapiceria, color);
        this.numPosicionRespaldo = Silla.MIN_PLAZAS;
    }
    @Override
    public String toString(){
        return String.format("%s Posición actual del respaldo: %d" ,
                super.toString(),
                this.numPosicionRespaldo
                );
    }

    @Override
    public int obtenerPosicion() {
       return this.numPosicionRespaldo;
    }

    @Override
    public int subirPosicion() throws IllegalStateException {
       int posAsubir = this.numPosicionRespaldo;
       if(++posAsubir>Silla.MAX_POSICION){
           throw new IllegalStateException(String.format("Error: no se puede subir a la posición %d, ya que la posición máxima es %d",
            posAsubir,
            Silla.MAX_POSICION)
           );
       }
      this.numPosicionRespaldo=posAsubir;
       return this.numPosicionRespaldo;
    }

    @Override
    public int bajarPosicion() throws IllegalStateException {
        int posAbajar = this.numPosicionRespaldo;
        
        if(--posAbajar<Silla.MIN_PLAZAS){
            throw new IllegalStateException(String.format("Error: no se puede bajar a la posición %d, ya que la posición mínima es %d",
                    posAbajar,
                    Silla.MIN_PLAZAS));
        }
       this.numPosicionRespaldo = posAbajar;
       return this.numPosicionRespaldo;
    }


    
}
