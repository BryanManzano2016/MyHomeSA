 
package controladores;
 
import myhomesa.modelos.Casa;
import myhomesa.modelos.Cliente;
import myhomesa.modelos.ElementoCasa;
import myhomesa.modelos.Usuario;

public class CtrlCliente {
    Cliente cliente;
    
    public CtrlCliente(Usuario usuario) {
        this.cliente = new Cliente(usuario);
    }      
    public void solicitarInsertarElemento(ElementoCasa elemento, Casa casa){
        cliente.agregarElementoCasa(elemento, casa);
    }
}
