 
package myhomesa.modelos;
 
import java.sql.SQLException;
import java.util.ArrayList;

public final class Cliente extends Usuario{
    
    private String idCliente;
    private int telefonoTrabajo;
    private int nroHijos;

    private boolean estaRegistrado;
    
    ArrayList<Casa> casas;

    public Cliente(Usuario usuario) {
        super(usuario.getNombres(), usuario.getApellidos(), usuario.getCedula(),
                usuario.getTelefono(), usuario.getCorreoElectronico(), usuario.getDireccionDomicilio(),
                usuario.getEstadoCivil(), usuario.getCargoTrabajo(), usuario.getUsuario(), 
                usuario.getPassword());        
        casas = new ArrayList<>();
        
        cargarDatosCliente();
        buscarCasaUsuario();        
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(int telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public int getNroHijos() {
        return nroHijos;
    }

    public void setNroHijos(int nroHijos) {
        this.nroHijos = nroHijos;
    }

    public boolean isEstaRegistrado() {
        return estaRegistrado;
    }

    public void setEstaRegistrado(boolean estaRegistrado) {
        this.estaRegistrado = estaRegistrado;
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public void setCasas(ArrayList<Casa> casas) {
        this.casas = casas;
    }
    
    public void cargarDatosCliente(){
        try{ 
            conexion.iniciar_conexion();
            conexion.setProcedimiento( conexion.getConexion().
                            prepareCall( "call buscarCliente(?)")
            );
            conexion.getProcedimiento().setInt(1, Integer.parseInt(this.cedula) );
            conexion.setResultado( conexion.getProcedimiento().executeQuery() );
            while ( conexion.getResultado().next() ) {
                if( conexion.getResultado().getInt("cedula") == Integer.parseInt(this.cedula)  ){
                    this.idCliente = conexion.getResultado().getString("idCliente");
                    this.telefonoTrabajo = conexion.getResultado().getInt("telefono");
                    this.nroHijos = conexion.getResultado().getInt("numHijos");
                }
            } 
            conexion.anular_puentes();
        } catch( SQLException e ){
            System.out.println( e.getSQLState() );
            System.out.println(e.getCause());
        } 
    }      
    
    public void buscarCasaUsuario(){
        try{ 
            conexion.iniciar_conexion();
            conexion.setProcedimiento( conexion.getConexion().
                            prepareCall( "call buscarCasaUsuario(?)")
            ); 
            conexion.getProcedimiento().setString(1, cedula);
            conexion.setResultado( conexion.getProcedimiento().executeQuery() );
            while ( conexion.getResultado().next() ) {                                                
                String idCasa = conexion.getResultado().getString("idCasa");
                Float metrosCuadrados = conexion.getResultado().getFloat("metrosCuadrados");
                int nroPlantas = conexion.getResultado().getInt("nroPlantas");
                int esEsquinera = conexion.getResultado().getInt("esEsquinera");
                String orientacion = conexion.getResultado().getString("orientacion");
                float tamañoPatio = conexion.getResultado().getFloat("tamañoPatio");
                float costoBase = conexion.getResultado().getFloat("costoBase");
                int numHabitacion = conexion.getResultado().getInt("numHabitacion");
                int idRelacion = conexion.getResultado().getInt("idRelacion"); 
                String nombreCasa = conexion.getResultado().getString("nombreCasa");
                switch (nombreCasa) {
                    case "Oasis":
                        casas.add(
                                new CasaOasis(idCasa, metrosCuadrados, nroPlantas,
                                        esEsquinera, orientacion, tamañoPatio,
                                        numHabitacion, costoBase, idRelacion));
                        break;
                    case "Paraiso":
                        casas.add(new CasaParaiso(idCasa, metrosCuadrados, nroPlantas,
                                        esEsquinera, orientacion, tamañoPatio,
                                        numHabitacion, costoBase, idRelacion));                       
                        break;
                    case "Cielo":
                        casas.add(new CasaCielo(idCasa, metrosCuadrados, nroPlantas,
                                        esEsquinera, orientacion, tamañoPatio,
                                        numHabitacion, costoBase, idRelacion));                
                        break;
                    default:
                        break;
                } 
            } 
            conexion.anular_puentes();
        } catch( SQLException e ){
            System.out.println( e.getSQLState() );
        } 
    }       
    
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", telefonoTrabajo=" + telefonoTrabajo + ", nroHijos=" + nroHijos + '}';
    }
}
