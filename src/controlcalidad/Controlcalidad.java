package controlcalidad;

import Controlador.ControladorInicio;
import Controlador.ObjetosIniciales;

/**
 *
 * @author alemayhua
 */
public class Controlcalidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObjetosIniciales.cargarListas();
        ControladorInicio.mostrarInicio();
    }

}
