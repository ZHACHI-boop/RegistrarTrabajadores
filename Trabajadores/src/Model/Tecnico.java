package Model;

//RF-03, DIS-04
public class Tecnico extends Obrero {
 private String claveAcceso;

 public Tecnico(String nombre, Long cedula, String codigo, String claveAcceso) {
     super(nombre, cedula, codigo);
     this.claveAcceso = claveAcceso;
 }

 public String getClaveAcceso() {
     return claveAcceso;
 }

 public void setClaveAcceso(String claveAcceso) {
     this.claveAcceso = claveAcceso;
 }

 @Override
 public void informacion() {
     System.out.println("NOMBRE: " + this.getNombre() + " | CEDULA: " + this.getCedula() + " | CODIGO: " + this.codigo + " | CLAVE: [PROTEGIDA]");
 }
}