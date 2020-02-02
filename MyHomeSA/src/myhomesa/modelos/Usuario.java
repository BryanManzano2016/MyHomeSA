 
package myhomesa.modelos;
 
import Auxiliar.Conexion;
import java.sql.SQLException;

public class Usuario {
    
    private String nombres;
    private String apellidos;
    private String cedula;
    private String telefono;
    private String correoElectronico;
    private String direccionDomicilio;
    private String estadoCivil;
    private String cargoTrabajo;
    
    private String usuario;
    private String password;
    
    private final Conexion conexion;

    public Usuario(String nombres, String apellidos, String cedula, String telefono, String correoElectronico, String direccionDomicilio, String estadoCivil, String cargoTrabajo, String usuario, String password) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccionDomicilio = direccionDomicilio;
        this.estadoCivil = estadoCivil;
        this.cargoTrabajo = cargoTrabajo;
        this.usuario = usuario;
        this.password = password;
        
        conexion = new Conexion();
    }
    
    public Usuario() {
        conexion = new Conexion();
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCargoTrabajo() {
        return cargoTrabajo;
    }

    public void setCargoTrabajo(String cargoTrabajo) {
        this.cargoTrabajo = cargoTrabajo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    // -------------
    public Usuario validarCredenciales(String usuario, String contrasena){
        try{ 
            conexion.iniciar_conexion();
            conexion.setProcedimiento( conexion.getConexion().
                            prepareCall( "call buscarlogin(?, ?)")
            );
            // Para retornar un resultSet
            conexion.getProcedimiento().setString(1, usuario);
            conexion.getProcedimiento().setString(2, contrasena);
            conexion.setResultado( conexion.getProcedimiento().executeQuery() );
            while ( conexion.getResultado().next() ) {
                if( !conexion.getResultado().getString("cedula").equals("") ){
                    Usuario usuarioBD = new Usuario(
                            conexion.getResultado().getString("nombre"),
                            conexion.getResultado().getString("apellido"),
                            conexion.getResultado().getString("cedula"),
                            conexion.getResultado().getString("telefono"),
                            conexion.getResultado().getString("correoElectronico"),
                            conexion.getResultado().getString("direccionAdomicilio"),
                            conexion.getResultado().getString("estadoCivil"),
                            conexion.getResultado().getString("rol"),
                            usuario,
                            contrasena
                    ); 
                    return usuarioBD;
                }
            } 
            conexion.anular_puentes();
        } catch( SQLException e ){
            System.out.println( e.getMessage() );
            System.out.println( e.getLocalizedMessage() );
        } 
        return null;
    }  

    @Override
    public String toString() {
        return "Usuario{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", cedula=" + cedula + ", telefono=" + telefono + ", correoElectronico=" + correoElectronico + ", direccionDomicilio=" + direccionDomicilio + ", estadoCivil=" + estadoCivil + ", cargoTrabajo=" + cargoTrabajo + ", usuario=" + usuario + ", password=" + password + ", conexion=" + conexion + '}';
    }
}
