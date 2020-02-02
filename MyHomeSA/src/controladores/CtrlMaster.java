 
package controladores;
 
import myhomesa.modelos.Usuario;
import vistas.VistasAdministrador;
import vistas.VistaCliente;
import vistas.VistaVendedor;

 
public class CtrlMaster {
    
    CtrlAdministrador ctrlAdministrador;
    CtrlVendedor ctrlVendedor;
    CtrlCliente ctrlCliente;
    
    private CtrlNuevoCliente ctrlNuevoCliente;
    
    public CtrlMaster(){
    }
    
    public void validarCredenciales(String usuarioM, String contrasenaM){
        
        Usuario usuario = new Usuario().validarCredenciales(usuarioM, contrasenaM);
        
        if (usuario != null) {
            System.out.println(usuario.toString());
            switch (usuario.getCargoTrabajo()) {
                case "cliente":
                    llamarCtrlCliente(usuario);                
                    break;
                case "vendedor":
                    llamarCtrlVendedor(usuario);
                    break;
                case "administrador":
                    llamarCtrlAdministrador(usuario);
                    break;       
                default:
                    break;
            }            
        }
    } 
    public void llamarCtrlAdministrador(Usuario usuario){
        this.ctrlAdministrador = new CtrlAdministrador(usuario);        
        VistasAdministrador vistaAdministrador = new VistasAdministrador();        
        vistaAdministrador.setCtrlAdministrador(ctrlAdministrador);
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
        vistaCliente.setCtrlCliente(this.ctrlCliente);
        
        vistaCliente.setVisible(true);
    }
    /*
    public void llamarClienteInvitado(){
        this.ctrlNuevoCliente = new CtrlNuevoCliente(new Usuario());        
        VistaNuevoCliente vistaNuevoCliente = new VistaNuevoCliente();           
        vistaNuevoCliente.setCtrlVendedor(this.ctrlCliente);

        vistaNuevoCliente.setVisible(true);
    } 
    */   
}
