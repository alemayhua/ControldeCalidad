package Controlador;

import Modelo.*;
import Vista.*;
import java.util.ArrayList;

/**
 *
 * @author alemayhua
 */
public class ObjetosIniciales {

    static VistaInicio vi = new VistaInicio();
    static VistaSupervisorLinea vsl = new VistaSupervisorLinea();
    static Empleado empleado = null;
    static OP op = null;
    static ArrayList<OP> listaOP = new ArrayList<>();
    static ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    static ArrayList<Modelo> listaModelos = new ArrayList<>();
    static ArrayList<Color> listaColores = new ArrayList<>();
    static ArrayList<Linea> listaLineas = new ArrayList<>();

    public static void cargarListas() {
        Empleado supervisorLinea1 = new SupervisorLinea(123, "Ale Mayhua", "ale@gmail.com", "sl1", "123");
        Empleado supervisorLinea2 = new SupervisorLinea(456, "Carlos Aguilar", "carlos@gmail.com", "sl2", "123");
        Empleado supervisorLinea3 = new SupervisorLinea(789, "Martin Madrid", "martin@gmail.com", "sl3", "123");
        Empleado supervisorCalidad1 = new SupervisorCalidad(321, "Flor Espeche", "flor@gmail.com", "calidad", "123");
        Modelo modelo1 = new Modelo("ABC123", "Classic");
        Modelo modelo2 = new Modelo("XYZ789", "Superstar");
        Color color1 = new Color("A1", "Blanco");
        Color color2 = new Color("B3", "Negro");
        Linea linea1 = new Linea(1, "Línea 1");
        Linea linea2 = new Linea(2, "Línea 2");
        Linea linea3 = new Linea(3, "Línea 3");
        listaEmpleados.add(supervisorLinea1);
        listaEmpleados.add(supervisorLinea2);
        listaEmpleados.add(supervisorLinea3);
        listaEmpleados.add(supervisorCalidad1);
        listaModelos.add(modelo1);
        listaModelos.add(modelo2);
        listaColores.add(color1);
        listaColores.add(color2);
        listaLineas.add(linea1);
        listaLineas.add(linea2);
        listaLineas.add(linea3);
    }
}
