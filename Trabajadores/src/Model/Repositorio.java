package Model;

import java.util.ArrayList;

public class Repositorio<T extends Persona> {
    private ArrayList<T> elementos;

    public Repositorio() {
        this.elementos = new ArrayList<>();
    }

    public boolean agregar(T elemento) {
        // Validacion de cedula duplicada comparando objetos Long (Boxing/Unboxing)
        for (T e : elementos) {
            if (e.getCedula().equals(elemento.getCedula())) {
                return false; 
            }
        }
        elementos.add(elemento);
        return true;
    }

    public T buscarPorCedula(Long cedula) {
        // RNF03:Uso de contador con Integer (boxing/unboxing)
        Integer contador = 0; 
        for (T e : elementos) {
            contador++; 
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<T> obtenerTodos() {
        return elementos;
    }
}