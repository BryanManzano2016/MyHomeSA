 
package controladores;
 
import myhomesa.modelos.Usuario;
import vistas.VistasAdministrador;
import vistas.VistaCliente;
import vistas.VistaNuevoCliente;
import vistas.VistaVendedor;

 
public class CtrlMaster {
    
    CtrlAdministrador ctrlAdministrador;
    CtrlVendedor ctrlVendedor;
    CtrlCliente ctrlCliente;
    
    private CtrlNuevoCliente ctrlNuevoCliente;
    
    public CtrlMaster(){
    }
    
    public void validarCredenciales(String opcion){
        Usuario usuario = new Usuario();
        usuario.validarCredenciales();
        // 1 por defecto 
        switch (opcion) {
            case "1":
                llamarCtrlCliente(usuario);                
                break;
            case "2":
                llamarCtrlVendedor(usuario);
                break;
            case "3":
                llamarCtrlAdministrador(usuario);
                break;       
            default:
                break;
        }
    } 
    public void llamarCtrlAdministrador(Usuario usuario){
        this.ctrlAdministrador = new CtrlAdministrador(usuario);        
        VistasAdministrador vistaAdministrador = new VistasAdministrador();        
        vistaAdministrador.setCtrlVendedor(ctrlAdministrador);
        
        vistaAdministrador.setVisible(true);
    }    
    
    public void llamarCtrlVendedor(Usuario usuario){
        this.ctrlVendedor = new CtrlVendedor(usuario);        
        VistaVendedor vistaVendedor = new VistaVendedor();
        vistaVendedor.setCtrlVendedor(this.ctrlVendedor);
        
        vistaVendedor.setVisible(true);
    }
    public void llamarCtrlCliente(Usuario usuario){
        this.ctrlCliente = new CtrlCliente(usuario);        
        VistaCliente vistaCliente = new VistaCliente();           
        vistaCliente.setCtrlVendedor(this.ctrlCliente);

        vistaCliente.setVisible(true);
    }
    public void llamarClienteInvitado(){
        this.ctrlNuevoCliente = new CtrlNuevoCliente(new Usuario());        
        VistaNuevoCliente vistaNuevoCliente = new VistaNuevoCliente();           
        vistaNuevoCliente.setCtrlVendedor(this.ctrlCliente);

        vistaNuevoCliente.setVisible(true);
    }    
}
