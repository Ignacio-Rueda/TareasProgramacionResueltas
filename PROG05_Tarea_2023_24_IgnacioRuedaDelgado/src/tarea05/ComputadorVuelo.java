package tarea05;

public class ComputadorVuelo {

    //Atributos objeto,inmutables
    private final String matricula;
    private final String modelo;
    //Atributos objeto,variables
    private boolean volando;
    private String nombrePiloto;
    private int tipoVuelo;
    private int tiempoTotalVuelo;

    private int velocidad;
    private int rumbo;
    private int altitud;

    //Atributos estáticos / de clase
    private static int cantidadTotalAeronaves;
    private static int cantidadAeronavesVolando;
    private static float cantidadHorasVueloTodasAeronaves;

    //Atributos constantes de clase->Asignaciones por omisión
    public static final String PILOTO_DEFECTO = "Juan Perez";
    public static final String MATRICULA_DEFECTO = "EC-ABC";
    public static final String MODELO_DEFECTO = "Cessna 152";
    public static final int MIN_ALTITUD = 1000;
    public static final int MAX_ALTITUD = 3000;
    public static final int VUELO_ESCUELA = 0;
    public static final int VUELO_PRIVADO = 1;

    ////////////////////////////////////////////////////////////////////////////
    //CONSTRUCTORES
    ////////////////////////////////////////////////////////////////////////////
    public ComputadorVuelo(String matricula, String modelo, String piloto) throws NullPointerException, IllegalArgumentException {
        if (matricula == null) {
            throw new NullPointerException("La matrícula de la aeronave no puede ser nula.");
        }
        if (modelo == null) {
            throw new NullPointerException("El modelo no puede ser nulo.");
        }
        if (piloto == null) {
            throw new NullPointerException("El nombre del piloto no puede ser nulo");
        }

        if (!matricula.contains("-") || matricula.substring(0, 1).equals("EC") || matricula.length() != 6) {
            throw new IllegalArgumentException(String.format("El formato de la matrícula es incorrecto%s%n", matricula));
        }
        if (matricula.isEmpty()) {
            throw new IllegalArgumentException("La matrícula contiene una cadena vacía.");
        }
        if (modelo.isEmpty()) {
            throw new IllegalArgumentException("El modelo contiene una cadena vacía.");
        }
        this.matricula = matricula;
        this.modelo = modelo;
        this.nombrePiloto = piloto;
        this.volando = false;
        this.tipoVuelo = ComputadorVuelo.VUELO_ESCUELA;
        this.tiempoTotalVuelo = 0;
        this.velocidad = 0;
        this.rumbo = 0;
        this.altitud = 0;
        ComputadorVuelo.cantidadTotalAeronaves++;
    }

    public ComputadorVuelo(String matricula, String modelo) throws NullPointerException, IllegalArgumentException {
        this(matricula, modelo, ComputadorVuelo.PILOTO_DEFECTO);
    }

    public ComputadorVuelo() {
        this(ComputadorVuelo.MATRICULA_DEFECTO, ComputadorVuelo.MODELO_DEFECTO, ComputadorVuelo.PILOTO_DEFECTO);
    }

    public static ComputadorVuelo[] crearArrayComputadorVuelo(int cantidad) throws IllegalArgumentException {
        if (cantidad < 1 || cantidad > 10) {
            throw new IllegalArgumentException(String.format("Número de aviones incorrecto %d, debe ser mayor o igual que 1 y menor o igual que 10", cantidad));
        }
        ComputadorVuelo[] arrayComputadorVuelo = new ComputadorVuelo[cantidad];

        for (int i = 0; i < cantidad; i++) {
            arrayComputadorVuelo[i] = new ComputadorVuelo();
        }

        return new ComputadorVuelo[]{};
    }

    //Getters y Setters
    public String getMatricula() {
        return this.matricula;
    }

    public String getModelo() {
        return this.modelo;
    }

    public boolean isVolando() {
        return this.volando;
    }

    public String getPiloto() {
        return this.nombrePiloto;
    }

    public int getTipoVuelo() {
        return this.tipoVuelo;
    }

    public int getTiempoTotalVuelo() {
        return this.tiempoTotalVuelo;
    }

    public int getVelocidad() {
        return this.velocidad;
    }

    public int getRumbo() {
        return this.rumbo;
    }

    public int getAltitud() {
        return this.altitud;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setRumbo(int rumbo) {
        this.rumbo = rumbo;
    }

    public void setAltitud(int altitud) {
        if (altitud < ComputadorVuelo.MIN_ALTITUD || altitud > ComputadorVuelo.MAX_ALTITUD) {
            altitud = ComputadorVuelo.MIN_ALTITUD;
        }
        this.altitud = altitud;
    }

    public static int getNumAeronaves() {
        return ComputadorVuelo.cantidadTotalAeronaves;
    }

    public static int getNumAeronavesVolando() {
        return ComputadorVuelo.cantidadAeronavesVolando;
    }

    public static float getNumHorasVuelo() {
        return ComputadorVuelo.cantidadHorasVueloTodasAeronaves;
    }

    //Método despegar
    public void despegar(int tipoVuelo, int velocidad, int altitud) throws IllegalStateException, IllegalArgumentException {
        if (altitud < ComputadorVuelo.MIN_ALTITUD || altitud > ComputadorVuelo.MAX_ALTITUD) {
            throw new IllegalArgumentException(String.format("La altitud de vuelo de %d metros es incorrecta", altitud));
        }
        if (this.isVolando()) {
            throw new IllegalStateException(String.format("%s ya ha despegado y se encuentra fuera del aeropuerto", this.matricula));
        }

        this.tipoVuelo = tipoVuelo;
        this.velocidad = velocidad;
        this.altitud = altitud;
        this.volando = true;
    }

    //Método aterrizar
    public void aterrizar(String aeropuertoSalida, String aeropuertoLlegada, int tiempoVuelo) throws IllegalStateException {
        if (!this.volando) {
            throw new IllegalStateException(String.format("%s ya ha aterrizado y debe despegar de nuevo antes de volver a aterrizar", this.matricula));
        }
        this.tiempoTotalVuelo += tiempoVuelo;
        float horas = tiempoVuelo / 60f;
        ComputadorVuelo.cantidadHorasVueloTodasAeronaves += horas;
        this.volando = false;
        this.velocidad = 0;
        this.altitud = 0;
        this.rumbo = 0;
    }

    //Método toString()
    @Override
    public String toString() {
        return String.format("{Matricula=%s, Modelo=%s,isVolando=%b,Piloto=%s,TipoVuelo=%d, TiempoTotal=%d, V=%d,Rumbo=%d,Altitud=%d metros]%n",
                this.matricula,
                this.modelo,
                this.isVolando(),
                this.nombrePiloto,
                this.tipoVuelo,
                this.tiempoTotalVuelo,
                this.velocidad,
                this.rumbo,
                this.altitud
        );
    }

}
