 
package controladores;
 
import myhomesa.modelos.Usuario;
import vistas.VistasAdministrador;
import vistas.VistaCliente;
import vistas.VistaVendedor;
// import vistas.VistaVendedor;
 
public class CtrlMaster {
    
    private CtrlAdministrador ctrlAdministrador;
    private CtrlVendedor ctrlVendedor;
    private CtrlCliente ctrlCliente;
    
    public CtrlMaster(){}
    
    public void validarCredenciales(String usuarioM, String contrasenaM){
        Usuario usuario = new Usuario().validarCredenciales(usuarioM, contrasenaM);
        if (usuario != null) {
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
        vistaVendedor.cargarDatosCliente();
        
        vistaVendedor.setVisible(true);
    }
    public void llamarCtrlCliente(Usuario usuario){
        this.ctrlCliente = new CtrlCliente(usuario);
        VistaCliente vistaCliente = new VistaCliente();           
        vistaCliente.setCtrlCliente(this.ctrlCliente);
        vistaCliente.cargarDatos();
        vistaCliente.setVisible(true);
    } 
}
