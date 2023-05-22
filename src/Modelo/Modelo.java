package Modelo;

/**
 *
 * @author alemayhua
 */
public class Modelo {
    String SKU;
    String denominacion;

    public String getSKU() {
        return SKU;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public Modelo(String SKU, String denominacion) {
        this.SKU = SKU;
        this.denominacion = denominacion;
    }
    
    
}
