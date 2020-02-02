 
package controladores;
 
import myhomesa.modelos.Administrador;
import myhomesa.modelos.Usuario;

public class CtrlAdministrador {
    Administrador administrador;
    
    public CtrlAdministrador(Usuario usuario) {
        this.administrador = new Administrador(usuario);
    }
    public Administrador getAdministrador() {
        return administrador;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    
}
