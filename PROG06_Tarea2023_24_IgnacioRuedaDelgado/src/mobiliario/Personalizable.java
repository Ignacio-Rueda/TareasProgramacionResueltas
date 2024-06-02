
package mobiliario;

public interface Personalizable {
    
    String obtenerModulos();
    void anyadirModulo(Modulo modulo) throws IllegalStateException,NullPointerException;
    Modulo extraerModulo() throws IllegalStateException;
}
