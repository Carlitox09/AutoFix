/*
 *  Alumno: Carlos Agustín Romero.
	Legajo: VINF014512
	SEMINARIO DE PRÁCTICA DE INFORMATICA
 * 
 * 
 */

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Ejecutar la GUI en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            AutoFixGUI gui = new AutoFixGUI(); // Crear instancia de la GUI
            gui.setVisible(true); // Mostrar la GUI
        });
    }
}