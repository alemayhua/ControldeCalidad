package Modelo;

/**
 *
 * @author alemayhua
 */
public class SupervisorLinea extends Empleado{
    
    public SupervisorLinea(int dni, String nombreYApellido, String correo, String Usuario, String contrasenia) {
        super(dni, nombreYApellido, correo, Usuario, contrasenia);
    }
    
    public SupervisorLinea(int dni, String nombreYApellido, String correo) {
        super(dni, nombreYApellido, correo);
    }
}   
