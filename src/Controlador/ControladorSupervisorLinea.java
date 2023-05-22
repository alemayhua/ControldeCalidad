package Controlador;

import static Controlador.ObjetosIniciales.*;
import static Controlador.ControladorOP.*;

/**
 *
 * @author alemayhua
 */
public class ControladorSupervisorLinea {

    public static void mostrarVistaSupervisorLinea() {
        cargarVistaSupervisorLinea();
        vsl.setTitle("Supervisor Línea");
        vsl.setVisible(true);
        vsl.setLocationRelativeTo(null);
    }

    public static void cargarVistaSupervisorLinea() {
        vsl.getLblEstadoOP().setText("");
        validarOP();
        cargarTablaOP();
        llenarCombobox();
        vsl.getPnlCrearOP().setVisible(true);
        vsl.getRbtnCrearOP().setSelected(true);
        vsl.getPnlGestionarModelos().setVisible(false);
        vsl.getPnlGestionarColores().setVisible(false);
        vsl.getLblSupervisor().setText("Supervisor de Línea");
        vsl.getLblEmpleado().setText(empleado.getNombreYApellido());
        vsl.getLblDni().setText(String.valueOf(empleado.getDni()));
        vsl.getLblCorreo().setText(empleado.getCorreo());
        vsl.getLblFecha().setText(obtenerFecha());
        vsl.getLblNumeroOP().setText(obtenerNumeroOP());
    }

    public static void botonRadioOP() {
        vsl.getPnlGestionarColores().setVisible(false);
        vsl.getPnlGestionarModelos().setVisible(false);
        vsl.getPnlCrearOP().setVisible(true);
        vsl.getLblFecha().setText(obtenerFecha());
        vsl.getLblNumeroOP().setText(obtenerNumeroOP());
    }

    public static void botonRadioGestionarModelos() {
        vsl.getPnlGestionarColores().setVisible(false);
        vsl.getPnlCrearOP().setVisible(false);
        vsl.getPnlGestionarModelos().setVisible(true);
        limpiarCampos();
        Controlador.ControladorModeloColor.cargarTabla(listaModelos, vsl.getTblModelos());
    }

    public static void botonRadioGestionarColores() {
        vsl.getPnlGestionarModelos().setVisible(false);
        vsl.getPnlCrearOP().setVisible(false);
        vsl.getPnlGestionarColores().setVisible(true);
        limpiarCampos();
        ControladorModeloColor.cargarTabla(listaColores, vsl.getTblColores());
    }

    public static void limpiarCampos() {
        vsl.getTxtSKUModelo().setText("");
        vsl.getTxtDenominacionModelo().setText("");
        vsl.getBtnAgregarModelo().setEnabled(false);
        vsl.getBtnBorrarModelo().setEnabled(false);
        vsl.getTxtCodigoColor().setText("");
        vsl.getTxtDescripcionColor().setText("");
        vsl.getBtnAgregarColor().setEnabled(false);
        vsl.getBtnBorrarColor().setEnabled(false);
    }
}
