package Modelo;

import java.util.Date;

/**
 *
 * @author alemayhua
 */
public class OP {
    int numero;
    String estado;
    String fecha;
    Empleado empleado;
    Linea linea;
    Modelo modelo;
    Color color;

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
    

    public int getNumero() {
        return numero;
    }

    public String getEstado() {
        return estado;
    }

    public String getFecha() {
        return fecha;
    }

    public Linea getLinea() {
        return linea;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Color getColor() {
        return color;
    }
    
    
    
    public OP(int numero, String estado, String fecha, Empleado empleado, Linea linea, Modelo modelo, Color color) {
        this.numero = numero;
        this.estado = estado;
        this.fecha = fecha;
        this.empleado = empleado;
        this.linea = linea;
        this.modelo = modelo;
        this.color = color;
    }    
}
