public class Reparacion {
    private static int idCounter = 1; // Contador estático para generar IDs únicos
    private int id; // ID único de la reparación
    private Vehiculo vehiculo;
    private Mecanico mecanico;
    private String fecha;
    private String hora;
    private String estado;

    public Reparacion(Vehiculo vehiculo, Mecanico mecanico, String fecha, String hora, String estado) {
        this.id = idCounter++; // Asignar ID único y aumentar el contador
        this.vehiculo = vehiculo;
        this.mecanico = mecanico;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public int getId() {
        return id; // Método para obtener el ID
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}