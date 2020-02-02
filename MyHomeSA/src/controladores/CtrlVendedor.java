 
package controladores;
 
import myhomesa.modelos.Usuario;
import myhomesa.modelos.Vendedor;

public class CtrlVendedor {
    Vendedor vendedor;
    
    public CtrlVendedor(Usuario usuario) {
        this.vendedor = new Vendedor(usuario);
    }    
}
