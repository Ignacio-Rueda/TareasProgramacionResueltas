package mobiliario;

import java.util.Arrays;

public abstract class Almacenaje extends Mueble implements Personalizable {

    private double anchura;
    private double altura;
    private final int numMaxModulos;
    private Modulo[] arrayModulo;

    protected int contadorModulosAnyadidos;

    public static final int MIN_MODULOS = 1;
    public static final int MAX_MODULOS = 20;

    public Almacenaje(double Precio, String descripcion, double anchura, double altura, int numMaxModulos) throws IllegalArgumentException {
        super(Precio, descripcion);
        if (numMaxModulos > Almacenaje.MAX_MODULOS || numMaxModulos < Almacenaje.MIN_MODULOS) {
            throw new IllegalArgumentException(String.format("ERROR: No se puede crear el mueble de Almacenaje. El número de módulos no está en el rango permitido: %d",
                    numMaxModulos));
        }
        this.anchura = anchura;
        this.altura = altura;
        this.numMaxModulos = numMaxModulos;
        this.arrayModulo = new Modulo[this.numMaxModulos];
        this.arrayModulo[0] = Modulo.BALDA;
        this.contadorModulosAnyadidos++;
    }

    //Declaración de métodos
    public double getAltura() {
        return this.altura;
    }

    public double getAnchura() {
        return this.anchura;
    }

    public int getNumModulos() {
        return this.numMaxModulos;
    }
  

    public int getModulosAnyadidos() {
        return this.contadorModulosAnyadidos;
    }

    @Override
    public String toString() {
        return String.format("%s Anchura:%.2f Altura: %.2f Módulos máximos: %d añadidos:%s",
                super.toString(),
                this.anchura,
                this.altura,
                this.numMaxModulos,
                Arrays.toString(this.arrayModulo)
        );
    }

    //Métodos interfaz:
    public String obtenerModulos() {
        return Arrays.toString(this.arrayModulo);
    }

    public void anyadirModulo(Modulo modulo) throws IllegalStateException, NullPointerException {
        if (modulo == null) {
            throw new NullPointerException("Error: el módulo a añadir no puede ser nulo");
        }

       
        if (this.contadorModulosAnyadidos >= this.numMaxModulos) {
            throw new IllegalStateException(String.format("Error: no se puede añadir el módulo %s. El número de módulos no puede superar el máximo permitido: %d",
                    modulo,
                    this.numMaxModulos)
            );
        }
        this.arrayModulo[this.contadorModulosAnyadidos] = modulo;
        this.contadorModulosAnyadidos++;
    }

    public Modulo extraerModulo() throws IllegalStateException {
        if (this.contadorModulosAnyadidos == Almacenaje.MIN_MODULOS) {
            throw new IllegalStateException(String.format("Error: no se puede quitar el módulo. El número de módulos no puede ser inferior a %d", Almacenaje.MIN_MODULOS));
        }

        Modulo modulo = this.arrayModulo[this.arrayModulo.length - 1];
        this.arrayModulo[--this.contadorModulosAnyadidos]=null;
        return modulo;
    }

}
