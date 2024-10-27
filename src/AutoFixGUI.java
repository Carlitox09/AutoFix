import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AutoFixGUI extends JFrame {
    private AutoFixSystem sistema; // Sistema de gestión de reparaciones
    private JTable table; // Tabla para mostrar el histórico de reparaciones
    private DefaultTableModel tableModel; // Modelo para la tabla

    public AutoFixGUI() {
        sistema = new AutoFixSystem(); // Inicializar el sistema
        setTitle("Sistema de Gestión de Reparaciones 'AutoFix'");
        setSize(800, 600); // Aumentar el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        // Configuración del panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Configuración de la tabla
        String[] columnNames = {"ID", "Vehículo", "Mecánico", "Fecha", "Hora", "Estado"};
        tableModel = new DefaultTableModel(columnNames, 0); // Inicializar el modelo de la tabla
        table = new JTable(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER); // Agregar la tabla al panel

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        JButton btnAgregarReparacion = new JButton("Agregar Reparación");
        JButton btnFinalizarReparacion = new JButton("Finalizar Reparación");
        JButton btnMostrarReparaciones = new JButton("Mostrar Reparaciones");
        JButton btnSalir = new JButton("Salir");

        // Agregar ActionListeners a los botones
        btnAgregarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarReparacion();
            }
        });

        btnFinalizarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarReparacion();
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
        buttonPanel.add(btnAgregarReparacion);
        buttonPanel.add(btnFinalizarReparacion);
        buttonPanel.add(btnMostrarReparaciones);
        buttonPanel.add(btnSalir);

        // Agregar paneles al panel principal
        panel.add(buttonPanel, BorderLayout.NORTH);
        add(panel);
    }

    // Método para agregar una nueva reparación
    private void agregarReparacion() {
        try {
            String marca = JOptionPane.showInputDialog(this, "Ingrese la marca del vehículo:");
            String modelo = JOptionPane.showInputDialog(this, "Ingrese el modelo del vehículo:");
            String añoStr = JOptionPane.showInputDialog(this, "Ingrese el año del vehículo (solo números):");
            String mecanicoNombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del mecánico:");
            String fecha = JOptionPane.showInputDialog(this, "Ingrese la fecha (solo números):");
            String hora = JOptionPane.showInputDialog(this, "Ingrese la hora (solo números):");

            // Validar que los campos no sean nulos y que sean números enteros
            if (marca == null || modelo == null || mecanicoNombre == null || fecha == null || hora == null) {
                throw new IllegalArgumentException("Todos los campos deben ser completados.");
            }

            // Validar que el año, la fecha y la hora sean números enteros
            if (!isNumeric(añoStr) || !isNumeric(fecha) || !isNumeric(hora)) {
                throw new IllegalArgumentException("El año, la fecha y la hora deben ser números enteros.");
            }

            int año = Integer.parseInt(añoStr); // Convertir el año a entero
            Vehiculo vehiculo = new Vehiculo(marca, modelo, año);
            Mecanico mecanico = new Mecanico(mecanicoNombre);
            Reparacion reparacion = new Reparacion(vehiculo, mecanico, fecha, hora, "EN CURSO");
            sistema.agregarReparacion(reparacion);
            JOptionPane.showMessageDialog(this, "Reparación agregada con éxito. ID: " + reparacion.getId());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: El año, la fecha y la hora deben ser números enteros.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // Método para finalizar una reparación
    private void finalizarReparacion() {
        try {
            String idStr = JOptionPane.showInputDialog(this, "Ingrese el ID de la reparación a finalizar:");
            int id = Integer.parseInt(idStr); // Convertir el ID a entero
            sistema.finalizarReparacion(id);
            JOptionPane.showMessageDialog(this, "Reparación finalizada con éxito.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: El ID debe ser un número entero.");
        }
    }

    // Método para mostrar las reparaciones
    private void mostrarReparaciones() {
        ArrayList<Reparacion> reparaciones = sistema.getReparaciones();
        if (reparaciones.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay reparaciones registradas.");
            return;
        }

        // Limpiar la tabla
        tableModel.setRowCount(0);

        // Agregar las reparaciones a la tabla
        for (Reparacion reparacion : reparaciones) {
            Object[] row = {reparacion.getId(), reparacion.getVehiculo().getMarca() + " " + reparacion.getVehiculo().getModelo(),
                            reparacion.getMecanico().getNombre(),
                            reparacion.getFecha(),
                            reparacion.getHora(),
                            reparacion.getEstado()};
            tableModel.addRow(row);
        }
    }

    // Método para verificar si una cadena es numérica
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}