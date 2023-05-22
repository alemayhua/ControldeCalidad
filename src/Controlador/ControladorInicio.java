package Controlador;

import javax.swing.JOptionPane;
import Modelo.*;

import static Controlador.ObjetosIniciales.vi;
import static Controlador.ObjetosIniciales.*;

/**
 *
 * @author aleja
 */
public class ControladorInicio {

    public static void mostrarInicio() {
        vi.setVisible(true);
        vi.setLocationRelativeTo(null);
        vi.getTxtUsuario().setText("");
        vi.getTxtContrasenia().setText("");
    }

    public static void botonIniciar() {
        String usuario = vi.getTxtUsuario().getText();
        String contrasenia = vi.getTxtContrasenia().getText();
        empleado = null;
        for (Empleado buscarEmpleado : listaEmpleados) {
            if (usuario.equals(buscarEmpleado.getUsuario()) && contrasenia.equals(buscarEmpleado.getContrasenia())) {
                empleado = buscarEmpleado;
                if (buscarEmpleado instanceof SupervisorLinea) {
                    vi.dispose();
                    ControladorSupervisorLinea.mostrarVistaSupervisorLinea();
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Supervisor Calidad: " + empleado.getNombreYApellido());
                    break;
                }
            }
        }
        if (empleado == null) {
            JOptionPane.showMessageDialog(null, "Los datos ingresados no son válidos. Intente nuevamente.");
        }
    }

    public static void botonCerrarSesion() {
        vsl.setVisible(false);
        mostrarInicio();
    }
}
