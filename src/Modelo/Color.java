package Modelo;

/**
 *
 * @author alemayhua
 */
public class Color {
    String codigo;
    String descripcion;

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Color(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    } 
}
