package View;

import Controller.ControladorEmpleados;
import javax.swing.*;

public class VentanaConsulta extends JFrame {
    public VentanaConsulta(ControladorEmpleados controlador) {
        setTitle("Consulta de Empleado");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblCedula = new JLabel("Cedula:");
        lblCedula.setBounds(30, 20, 80, 25);
        add(lblCedula);

        JTextField txtCedula = new JTextField();
        txtCedula.setBounds(110, 20, 150, 25);
        add(txtCedula);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(270, 20, 80, 25);
        add(btnBuscar);

        JTextArea txtResultado = new JTextArea();
        txtResultado.setBounds(30, 65, 320, 170);
        txtResultado.setEditable(false);
        add(txtResultado);

        btnBuscar.addActionListener(e -> {
            String res = controlador.consultarEmpleado(txtCedula.getText());
            txtResultado.setText(res);
        });
    }
}