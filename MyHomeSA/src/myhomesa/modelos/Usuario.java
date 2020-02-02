 
package myhomesa.modelos;
 
import Auxiliar.Conexion;

public class Usuario {
    Conexion con = new Conexion();
    public Usuario() {
    }
    public int validarCredenciales(){
        // carga informacion de usuario
        
        this.con.ejecutarSentencia();        
        return 1;
    }
    
}
