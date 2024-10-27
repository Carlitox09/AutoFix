import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private AutoFixSystem sistema; // Sistema de gestión de reparaciones

    // Constructor para inicializar el menú
    public Menu() {
        sistema = new AutoFixSystem(); // Inicializar el sistema
        setTitle("Menú");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        // Configuración del panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        JButton btnAgregarVehiculo = new JButton("Agregar Vehículo");
        JButton btnAgregarReparacion = new JButton("Agregar Reparación");
        JButton btnMostrarVehiculos = new JButton("Mostrar Vehículos");
        JButton btnMostrarReparaciones = new JButton("Mostrar Reparaciones");
        JButton btnSalir = new JButton("Salir");

        // Agregar ActionListeners a los botones
        btnAgregarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarVehiculo();
            }
        });

        btnAgregarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarReparacion();
            }
        });

        btnMostrarVehiculos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVehiculos();
            }
        });

        btnMostrarReparaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarReparaciones();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Agregar botones al panel de botones
        buttonPanel.add(btnAgregarVehiculo);
        buttonPanel.add(btnAgregarReparacion);
        buttonPanel.add(btnMostrarVehiculos);
        buttonPanel.add(btnMostrarReparaciones);
        buttonPanel.add(btnSalir);

        // Agregar paneles al panel principal
        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);
    }

    // Método para agregar un vehículo
    private void agregarVehiculo() {
        // Implementación para agregar un vehículo
    }

    // Método para agregar una reparación
    private void agregarReparacion() {
        // Implementación para agregar una reparación
    }

    // Método para mostrar los vehículos registrados
    private void mostrarVehiculos() {
        // Implementación para mostrar los vehículos registrados
    }

    // Método para mostrar las reparaciones registradas
    private void mostrarReparaciones() {
        // Implementación para mostrar las reparaciones registradas
    }

    // Método para mostrar el menú
    public void mostrarMenu() {
        setVisible(true);
    }
}