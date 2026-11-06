package View;

import Controller.ControladorEmpleados;
import javax.swing.*;

public class VentanaObreroRegistro extends JFrame {
    public VentanaObreroRegistro(ControladorEmpleados controlador) {
        setTitle("Registro Obrero");
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

        JLabel lblCodigo = new JLabel("Codigo:");
        lblCodigo.setBounds(30, 110, 100, 25);
        add(lblCodigo);
        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(130, 110, 160, 25);
        add(txtCodigo);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(130, 150, 100, 30);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            String res = controlador.registrarObrero(txtNombre.getText(), txtCedula.getText(), txtCodigo.getText());
            JOptionPane.showMessageDialog(this, res);
            if (res.startsWith("Exito")) dispose();
        });
    }
}