package Modelo;

/**
 *
 * @author alemayhua
 */
public class Linea {
    int numero;
    String descripcion;

    public int getNumero() {
        return numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Linea(int numero, String descripcion) {
        this.numero = numero;
        this.descripcion = descripcion;
    }     
}
