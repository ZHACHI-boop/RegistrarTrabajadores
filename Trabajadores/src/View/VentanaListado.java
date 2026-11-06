package View;

import Controller.ControladorEmpleados;
import Model.Administrativo;
import Model.Obrero;
import Model.Tecnico;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaListado extends JFrame {
    public VentanaListado(ControladorEmpleados controlador) {
        setTitle("Listado de Empleados");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        String[] columnas = {"Tipo", "Nombre", "Cedula", "Detalle"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 20, 440, 260);
        add(scroll);

        for (Administrativo a : controlador.getAdministrativos()) {
            modeloTabla.addRow(new Object[]{"Administrativo", a.getNombre(), a.getCedula(), a.getCargo()});
        }
        for (Obrero o : controlador.getObreros()) {
            modeloTabla.addRow(new Object[]{"Obrero", o.getNombre(), o.getCedula(), o.getCodigo()});
        }
        for (Tecnico t : controlador.getTecnicos()) {
            modeloTabla.addRow(new Object[]{"Tecnico", t.getNombre(), t.getCedula(), t.getCodigo()});
        }
    }
}