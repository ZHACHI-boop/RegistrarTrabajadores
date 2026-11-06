package View;

import Controller.ControladorEmpleados;
import javax.swing.*;

public class VentanaMenuPrincipal extends JFrame {
    private static final long serialVersionUID = 1L;

    public VentanaMenuPrincipal(ControladorEmpleados controlador) {
        setTitle("Sistema de Gestion de Personal");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnAdmin = new JButton("Registrar Administrativo");
        btnAdmin.setBounds(80, 30, 240, 30);
        add(btnAdmin);

        JButton btnObrero = new JButton("Registrar Obrero");
        btnObrero.setBounds(80, 75, 240, 30);
        add(btnObrero);

        JButton btnTecnico = new JButton("Registrar Tecnico");
        btnTecnico.setBounds(80, 120, 240, 30);
        add(btnTecnico);

        JButton btnConsultar = new JButton("Consultar por Cedula");
        btnConsultar.setBounds(80, 165, 240, 30);
        add(btnConsultar);

        JButton btnListar = new JButton("Listar Empleados");
        btnListar.setBounds(80, 210, 240, 30);
        add(btnListar);

        btnAdmin.addActionListener(evt -> new VentanaAdminRegistro(controlador).setVisible(true));
        btnObrero.addActionListener(evt -> new VentanaObreroRegistro(controlador).setVisible(true));
        btnTecnico.addActionListener(evt -> new VentanaTecnicoRegistro(controlador).setVisible(true));
        btnConsultar.addActionListener(evt -> new VentanaConsulta(controlador).setVisible(true));
        btnListar.addActionListener(evt -> new VentanaListado(controlador).setVisible(true));
    }
}