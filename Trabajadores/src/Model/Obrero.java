package Model;

public class Obrero extends Persona {
 protected String codigo;

 public Obrero(String nombre, Long cedula, String codigo) {
     super(nombre, cedula);
     this.codigo = codigo;
 }

 public String getCodigo() {
     return codigo;
 }

 public void setCodigo(String codigo) {
     this.codigo = codigo;
 }

 @Override
 public void informacion() {
     System.out.println("NOMBRE: " + this.getNombre() + " | CEDULA: " + this.getCedula() + " | CODIGO: " + this.codigo);
 }
}