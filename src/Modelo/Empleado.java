package Modelo;

/**
 *
 * @author alemayhua
 */
public class Empleado {
    int dni;
    String nombreYApellido;
    String correo;
    String Usuario;
    String contrasenia;

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Empleado(int dni, String nombreYApellido, String correo, String Usuario, String contrasenia) {
        this.dni = dni;
        this.nombreYApellido = nombreYApellido;
        this.correo = correo;
        this.Usuario = Usuario;
        this.contrasenia = contrasenia;
        
    }

    public Empleado(int dni, String nombreYApellido, String correo) {
        this.dni = dni;
        this.nombreYApellido = nombreYApellido;
        this.correo = correo;
    }
    
    
}
