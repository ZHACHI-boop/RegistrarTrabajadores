import Controller.ControladorEmpleados;
import View.VentanaMenuPrincipal;

public class Main {
	public static void main(String[] args) {
		ControladorEmpleados controlador = new ControladorEmpleados();
		java.awt.EventQueue.invokeLater(() -> {
			new VentanaMenuPrincipal(controlador).setVisible(true);
		});
	}
}