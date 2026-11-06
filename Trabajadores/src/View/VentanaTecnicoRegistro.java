package View;

import Controller.ControladorEmpleados;
import javax.swing.*;

public class VentanaTecnicoRegistro extends JFrame {
    public VentanaTecnicoRegistro(ControladorEmpleados controlador) {
        setTitle("Registro Tecnico");
        setSize(350, 280);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 20, 100, 25);
        add(lblNombre);
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(130, 20, 160, 25);
        add(txtNombre);

        JLabel lblCedula = new JLabel("Cedula:");
        lblCedula.setBounds(30, 60, 100, 25);
        add(lblCedula);
        JTextField txtCedula = new JTextField();
        txtCedula.setBounds(130, 60, 160, 25);
        add(txtCedula);

        JLabel lblCodigo = new JLabel("Codigo:");
        lblCodigo.setBounds(30, 100, 100, 25);
        add(lblCodigo);
        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(130, 100, 160, 25);
        add(txtCodigo);

        JLabel lblClave = new JLabel("Clave Acceso:");
        lblClave.setBounds(30, 140, 100, 25);
        add(lblClave);
        JPasswordField txtClave = new JPasswordField();
        txtClave.setBounds(130, 140, 160, 25);
        add(txtClave);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(130, 185, 100, 30);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            String res = controlador.registrarTecnico(txtNombre.getText(), txtCedula.getText(), txtCodigo.getText(), new String(txtClave.getPassword()));
            JOptionPane.showMessageDialog(this, res);
            if (res.startsWith("Exito")) dispose();
        });
    }
}