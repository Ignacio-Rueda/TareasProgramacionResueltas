
package mobiliario;

public final class Estanteria extends Almacenaje {
    private final String tipo;
    public Estanteria(double Precio, String descripcion, double anchura, double altura, int numMaxModulos,String tipo) throws IllegalArgumentException {
        super(Precio, descripcion, anchura, altura, numMaxModulos);
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    
    @Override
    public String toString(){
        return String.format("%s Tipo:%s", 
                super.toString(),
                    this.tipo
                );
    }
    @Override
    public void anyadirModulo(Modulo modulo)throws NullPointerException, IllegalArgumentException{

        if(modulo!= null &&!modulo.equals(Modulo.BALDA)){
            throw new IllegalArgumentException(String.format("No se puede añadir un módulo que no sea del tipo%s",Modulo.BALDA));
        }
        super.anyadirModulo(modulo);
    }
}
