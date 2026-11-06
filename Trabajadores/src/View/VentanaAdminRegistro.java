package View;

import Controller.ControladorEmpleados;
import javax.swing.*;

public class VentanaAdminRegistro extends JFrame {
    public VentanaAdminRegistro(ControladorEmpleados controlador) {
        setTitle("Registro Administrativo");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 30, 100, 25);
        add(lblNombre);
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(130, 30, 160, 25);
        add(txtNombre);

        JLabel lblCedula = new JLabel("Cedula:");
        lblCedula.setBounds(30, 70, 100, 25);
        add(lblCedula);
        JTextField txtCedula = new JTextField();
        txtCedula.setBounds(130, 70, 160, 25);
        add(txtCedula);

        JLabel lblCargo = new JLabel("Cargo:");
        lblCargo.setBounds(30, 110, 100, 25);
        add(lblCargo);
        JTextField txtCargo = new JTextField();
        txtCargo.setBounds(130, 110, 160, 25);
        add(txtCargo);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(130, 150, 100, 30);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            String res = controlador.registrarAdministrativo(txtNombre.getText(), txtCedula.getText(), txtCargo.getText());
            JOptionPane.showMessageDialog(this, res);
            if (res.startsWith("Exito")) dispose();
        });
    }
}