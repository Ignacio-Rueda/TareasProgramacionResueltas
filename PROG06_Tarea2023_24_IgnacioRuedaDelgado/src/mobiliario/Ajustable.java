
package mobiliario;


public interface Ajustable {
    
    int obtenerPosicion();
    int subirPosicion() throws IllegalStateException;
    int bajarPosicion() throws IllegalStateException;
}
