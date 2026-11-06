package Controller;

import Model.Administrativo;
import Model.Obrero;
import Model.Tecnico;
import Model.Repositorio;
import java.util.ArrayList;

public class ControladorEmpleados {
    private Repositorio<Administrativo> repoAdmin;
    private Repositorio<Obrero> repoObrero;
    private Repositorio<Tecnico> repoTecnico;

    public ControladorEmpleados() {
        this.repoAdmin = new Repositorio<>();
        this.repoObrero = new Repositorio<>();
        this.repoTecnico = new Repositorio<>();
    }

    public boolean validarCedula(String cedulaStr) {
        if (cedulaStr == null || !cedulaStr.matches("\\d{10}")) {
            return false;
        }
        return true;
    }

    public String registrarAdministrativo(String nombre, String cedulaStr, String cargo) {
        if (!validarCedula(cedulaStr)) {
            return "Error: La cedula debe tener exactamente 10 digitos numericos.";
        }
        if (nombre == null || nombre.trim().isEmpty() || cargo == null || cargo.trim().isEmpty()) {
            return "Error: Todos los campos son obligatorios.";
        }
        
        Long cedula = Long.valueOf(cedulaStr); // RNF-03: Conversion y boxing a Long
        Administrativo admin = new Administrativo(nombre, cedula, cargo);
        
        if (repoAdmin.agregar(admin)) {
            return "Exito: Administrativo registrado correctamente.";
        }
        return "Error: La cedula ya esta registrada.";
    }

    public String registrarObrero(String nombre, String cedulaStr, String codigo) {
        if (!validarCedula(cedulaStr)) {
            return "Error: La cedula debe tener exactamente 10 digitos numericos.";
        }
        if (nombre == null || nombre.trim().isEmpty() || codigo == null || codigo.trim().isEmpty()) {
            return "Error: Todos los campos son obligatorios.";
        }

        Long cedula = Long.valueOf(cedulaStr);
        Obrero obrero = new Obrero(nombre, cedula, codigo);

        if (repoObrero.agregar(obrero)) {
            return "Exito: Obrero registrado correctamente.";
        }
        return "Error: La cedula ya esta registrada.";
    }

    public String registrarTecnico(String nombre, String cedulaStr, String codigo, String claveAcceso) {
        if (!validarCedula(cedulaStr)) {
            return "Error: La cedula debe tener exactamente 10 digitos numericos.";
        }
        if (nombre == null || nombre.trim().isEmpty() || codigo == null || codigo.trim().isEmpty() || claveAcceso == null || claveAcceso.trim().isEmpty()) {
            return "Error: Todos los campos son obligatorios.";
        }

        Long cedula = Long.valueOf(cedulaStr);
        Tecnico tecnico = new Tecnico(nombre, cedula, codigo, claveAcceso);

        if (repoTecnico.agregar(tecnico)) {
            return "Exito: Tecnico registrado correctamente.";
        }
        return "Error: La cedula ya esta registrada.";
    }

    public String consultarEmpleado(String cedulaStr) {
        if (!validarCedula(cedulaStr)) {
            return "Error: Formato de cedula invalido. Ingrese 10 digitos.";
        }
        Long cedula = Long.valueOf(cedulaStr);

        Administrativo admin = repoAdmin.buscarPorCedula(cedula);
        if (admin != null) {
            return "Tipo: Administrativo\nNombre: " + admin.getNombre() + "\nCedula: " + admin.getCedula() + "\nCargo: " + admin.getCargo();
        }

        Tecnico tecnico = repoTecnico.buscarPorCedula(cedula);
        if (tecnico != null) {
            return "Tipo: Tecnico\nNombre: " + tecnico.getNombre() + "\nCedula: " + tecnico.getCedula() + "\nCodigo: " + tecnico.getCodigo() + "\nClave: ***";
        }

        Obrero obrero = repoObrero.buscarPorCedula(cedula);
        if (obrero != null) {
            return "Tipo: Obrero\nNombre: " + obrero.getNombre() + "\nCedula: " + obrero.getCedula() + "\nCodigo: " + obrero.getCodigo();
        }

        return "Aviso: No se encontro ningun empleado con la cedula ingresada.";
    }

    public ArrayList<Administrativo> getAdministrativos() {
        return repoAdmin.obtenerTodos();
    }

    public ArrayList<Obrero> getObreros() {
        return repoObrero.obtenerTodos();
    }

    public ArrayList<Tecnico> getTecnicos() {
        return repoTecnico.obtenerTodos();
    }
}