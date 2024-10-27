import java.util.ArrayList;

public class AutoFixSystem {
    private ArrayList<Reparacion> reparaciones; // Lista de reparaciones

    public AutoFixSystem() {
        reparaciones = new ArrayList<>(); // Inicializar la lista de reparaciones
    }

    // Método para agregar una nueva reparación
    public void agregarReparacion(Reparacion reparacion) {
        reparaciones.add(reparacion);
    }

    // Método para finalizar una reparación usando el ID
    public void finalizarReparacion(int id) {
        for (Reparacion reparacion : reparaciones) {
            if (reparacion.getId() == id) {
                reparacion.setEstado("FINALIZADA");
                return;
            }
        }
    }

    // Método para obtener las reparaciones
    public ArrayList<Reparacion> getReparaciones() {
        return reparaciones;
    }
}