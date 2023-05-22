package Controlador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import Modelo.*;

import static Controlador.ObjetosIniciales.*;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alemayhua
 */
public class ControladorOP {

    public static void llenarCombobox() {
        vsl.getCbNumeroLinea().removeAllItems();
        vsl.getCbDenominacionModelo().removeAllItems();
        vsl.getCbDescripcionColor().removeAllItems();
        Collections.sort(listaLineas, Comparator.comparing(Linea::getNumero));
        for (Linea linea : listaLineas) {
            vsl.getCbNumeroLinea().addItem(String.valueOf(linea.getNumero()));
        }
        for (Modelo modelo : listaModelos) {
            vsl.getCbDenominacionModelo().addItem(modelo.getDenominacion());
        }
        for (Color color : listaColores) {
            vsl.getCbDescripcionColor().addItem(color.getDescripcion());
        }
    }

    public static void llenarLabels(JComboBox combobox) {
        if (combobox.getItemCount() > 0) {
            if (combobox == vsl.getCbNumeroLinea()) {
                Linea linea = listaLineas.get(vsl.getCbNumeroLinea().getSelectedIndex());
                vsl.getLblDescripcionLinea().setText(linea.getDescripcion());
            } else if (combobox == vsl.getCbDenominacionModelo()) {
                Modelo modelo = listaModelos.get(vsl.getCbDenominacionModelo().getSelectedIndex());
                vsl.getLblSKUModelo().setText(modelo.getSKU());
            } else if (combobox == vsl.getCbDescripcionColor()) {
                Color color = listaColores.get(vsl.getCbDescripcionColor().getSelectedIndex());
                vsl.getLblCodigoColor().setText(color.getCodigo());
            }
        }
    }

    public static void crearOP() {
        int numero = Integer.valueOf(vsl.getLblNumeroOP().getText());
        String estado = "Iniciado";
        String fecha = vsl.getLblFecha().getText();
        Linea linea = new Linea(Integer.valueOf((String) vsl.getCbNumeroLinea().getSelectedItem()), vsl.getLblDescripcionLinea().getText());
        Modelo modelo = new Modelo(vsl.getLblSKUModelo().getText(), (String) vsl.getCbDenominacionModelo().getSelectedItem());
        Color color = new Color(vsl.getLblCodigoColor().getText(), (String) vsl.getCbDescripcionColor().getSelectedItem());
        OP nuevaOp = new OP(numero, estado, fecha, empleado, linea, modelo, color);
        lineaOcupada(nuevaOp.getLinea());
        llenarCombobox();
        op = nuevaOp;
        listaOP.add(nuevaOp);
        cargarTablaOP();
    }

    public static void validarOP() {
        op = null;
        for (OP buscarOP : listaOP) {
            if (buscarOP.getEmpleado() == empleado && buscarOP.getEstado().equals("Iniciado")
                    || buscarOP.getEmpleado() == empleado && buscarOP.getEstado().equals("Pausado")
                    || buscarOP.getEmpleado() == empleado && buscarOP.getEstado().equals("Reanudado")) {
                op = buscarOP;
                vsl.getLblEstadoOP().setText("Estado OP: " + op.getEstado());
                vsl.getBtnIniciar().setEnabled(false);
                vsl.getBtnPausar().setEnabled(true);
                vsl.getBtnFinalizar().setEnabled(true);
                break;
            }
        }
        if (op == null) {
            vsl.getBtnIniciar().setEnabled(true);
            vsl.getBtnPausar().setEnabled(false);
            vsl.getBtnFinalizar().setEnabled(false);
        }
    }

    public static void botonInciarOP() {
        crearOP();
        vsl.getLblEstadoOP().setText("Estado OP: " + op.getEstado());
        vsl.getBtnIniciar().setEnabled(false);
        vsl.getBtnPausar().setEnabled(true);
        vsl.getBtnFinalizar().setEnabled(true);
        if (vsl.getCbNumeroLinea().getSelectedItem() == null) {
            vsl.getLblDescripcionLinea().setText("");
        }
        cargarTablaOP();
    }

    public static void lineaOcupada(Linea linea) {
        for (Linea lineaOcupada : listaLineas) {
            if (lineaOcupada.getNumero() == linea.getNumero()) {
                listaLineas.remove(lineaOcupada);
                break;
            }
        }
    }

    public static void botonPausarOP() {
        if (op.getEstado().equals("Iniciado")) {
            op.setEstado("Pausado");
            vsl.getLblEstadoOP().setText("Estado OP: " + op.getEstado());
            vsl.getBtnPausar().setText("▸ ︎Reanudar");
        } else {
            op.setEstado("Reanudado");
            vsl.getLblEstadoOP().setText("Estado OP: " + op.getEstado());
            vsl.getBtnPausar().setText("⏸️ ︎Pausar");
        }
        cargarTablaOP();
    }

    public static void botonFinalizarOP() {
        if (JOptionPane.showConfirmDialog(null, "¿Desea finaliza OP " + op.getNumero() + "?") == JOptionPane.YES_OPTION) {
            op.setEstado("Finalizado");
            listaLineas.add(op.getLinea());
            llenarCombobox();
            vsl.getLblNumeroOP().setText(obtenerNumeroOP());
            vsl.getLblEstadoOP().setText("");
            vsl.getBtnIniciar().setEnabled(true);
            vsl.getBtnPausar().setEnabled(false);
            vsl.getBtnFinalizar().setEnabled(false);
            cargarTablaOP();
        }
    }

    public static String obtenerNumeroOP() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1001);
        String numero = Integer.toString(numeroAleatorio);
        return numero;
    }

    public static String obtenerFecha() {
        Calendar calendario = Calendar.getInstance();
        Date fechaHoy = calendario.getTime();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formatoFecha.format(fechaHoy);
        return fecha;
    }

    public static void cargarTablaOP() {
        DefaultTableModel tabla = (DefaultTableModel) vsl.getTblOP().getModel();
        tabla.setNumRows(0);
        for (OP itemOP : listaOP) {
            Object[] filaOP = {itemOP.getNumero(),
                itemOP.getFecha(),
                itemOP.getEstado(),
                itemOP.getLinea().getNumero(),
                itemOP.getModelo().getDenominacion(),
                itemOP.getColor().getDescripcion(),
                itemOP.getEmpleado().getNombreYApellido()};
            tabla.addRow(filaOP);
        }
    }
}
