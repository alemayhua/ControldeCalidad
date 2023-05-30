package Controlador;

import Modelo.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import static Controlador.ObjetosIniciales.*;

/**
 *
 * @author alemayhua
 */
public class ControladorModeloColor {

    public static void botonAgregar(JTextField campoTexto1, JTextField campoTexto2, JButton boton) {
        String texto1 = campoTexto1.getText();
        String texto2 = campoTexto2.getText();
        if (boton.equals(vsl.getBtnAgregarModelo())) {
            listaModelos.add(new Modelo(texto1, texto2));
            cargarTabla(listaModelos, vsl.getTblModelos());
        } else {
            listaColores.add(new Color(texto1, texto2));
            cargarTabla(listaColores, vsl.getTblColores());
        }
        ControladorSupervisorLinea.limpiarCampos();
        ControladorOP.llenarCombobox();
    }

    public static void botonBorrar(JTable tabla) {
        int seleccionFila = tabla.getSelectedRow();
        String itemColumna0 = (String) tabla.getValueAt(seleccionFila, 0);
        String itemColumna1 = (String) tabla.getValueAt(seleccionFila, 1);
        if (tabla.equals(vsl.getTblModelos())) {
            Modelo modeloBorrar = null;
            for (Modelo modelo : listaModelos) {
                if (modelo.getSKU().equals(itemColumna0) && modelo.getDenominacion().equals(itemColumna1)) {
                    modeloBorrar = modelo;
                    break;
                }
            }
            if (modeloBorrar != null) {
                listaModelos.remove(modeloBorrar);
                cargarTabla(listaModelos, vsl.getTblModelos());
            }
        } else {
            Color colorBorrar = null;
            for (Color color : listaColores) {
                if (color.getCodigo().equals(itemColumna0) && color.getDescripcion().equals(itemColumna1)) {
                    colorBorrar = color;
                    break;
                }
            }
            if (colorBorrar != null) {
                listaColores.remove(colorBorrar);
                cargarTabla(listaColores, vsl.getTblColores());
            }
        }
        ControladorSupervisorLinea.limpiarCampos();
        ControladorOP.llenarCombobox();
    }

    public static void cargarTabla(ArrayList lista, JTable tablaVista) {
        DefaultTableModel tabla = (DefaultTableModel) tablaVista.getModel();
        tabla.setNumRows(0);
        if (lista == listaModelos) {
            for (Modelo modelo : listaModelos) {
                Object[] fila = {modelo.getSKU(), modelo.getDenominacion()};
                tabla.addRow(fila);
            }
        } else {
            for (Color color : listaColores) {
                Object[] filaColor = {color.getCodigo(), color.getDescripcion()};
                tabla.addRow(filaColor);
            }
        }
    }

    public static void habilitarBotonAgregar(JTextField campoTexto1, JTextField campoTexto2, JButton boton) {
        String texto1 = campoTexto1.getText();
        String texto2 = campoTexto2.getText();
        if (!texto1.isEmpty() && !texto2.isEmpty()) {
            boton.setEnabled(true);
        } else {
            boton.setEnabled(false);
        }
    }

    public static void habilitarBotonBorrar(JTable tabla, JButton botonBorrar) {
        int seleccionFila = tabla.getSelectedRow();
        if (seleccionFila != -1) {
            botonBorrar.setEnabled(true);
        }
    }
}
