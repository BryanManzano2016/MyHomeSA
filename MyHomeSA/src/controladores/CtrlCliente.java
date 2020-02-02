 
package controladores;
 
import myhomesa.modelos.Cliente;
import myhomesa.modelos.Usuario;

public class CtrlCliente {
    Cliente cliente;
    
    public CtrlCliente(Usuario usuario) {
        this.cliente = new Cliente(usuario);    
    }       
        
    public Cliente getCliente() {
        return cliente;
    }
    
}
