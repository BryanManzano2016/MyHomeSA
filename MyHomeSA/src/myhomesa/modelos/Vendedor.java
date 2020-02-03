 package myhomesa.modelos;
 
import java.sql.SQLException;
import java.util.ArrayList;

public class Vendedor extends Usuario {

    // ArrayList<Casa> casas;
    
    public Vendedor(Usuario usuario) {
        super(usuario.getNombres(), usuario.getApellidos(), usuario.getCedula(),
                usuario.getTelefono(), usuario.getCorreoElectronico(), usuario.getDireccionDomicilio(),
                usuario.getEstadoCivil(), usuario.getCargoTrabajo(), usuario.getUsuario(), 
                usuario.getPassword());           
    } 
    public ArrayList<Cliente> cargarDatosClientes(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try{ 
            conexion.iniciar_conexion();
            conexion.setProcedimiento( conexion.getConexion().
                            prepareCall( "call buscarClientes()")
            );
            conexion.setResultado( conexion.getProcedimiento().executeQuery() );
            while ( conexion.getResultado().next() ) {
                Cliente cliente = new Cliente(
                        new Usuario(conexion.getResultado().getString("nombre"), 
                                conexion.getResultado().getString("apellido"),
                                Integer.toString(conexion.getResultado().getInt("cedula")), 
                                Integer.toString(conexion.getResultado().getInt("telefono")),
                                conexion.getResultado().getString("correoElectronico"), 
                                conexion.getResultado().getString("direccionAdomicilio"),
                                conexion.getResultado().getString("estadoCivil"))
                );
                cliente.setNroHijos(conexion.getResultado().getInt("numHijos"));
                cliente.setIdCliente(conexion.getResultado().getString("apellido"));
                clientes.add(cliente);
            } 
            conexion.anular_puentes();
            return clientes;
        } catch( SQLException e ){
            // System.out.println( e.getSQLState() );
        }         
        return null;
    }
 
    public ArrayList<Casa> casasUsuario(int cedulaPar){
        try{ 
            ArrayList<Casa> casas = new ArrayList<>();
            conexion.iniciar_conexion();
            conexion.setProcedimiento( conexion.getConexion().
                            prepareCall( "call buscarCasaUsuario(?)")
            ); 
            conexion.getProcedimiento().setInt(1, cedulaPar);
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
                                        numHabitacion, costoBase, idRelacion,nombreCasa));
                        break;
                    case "Paraiso":
                        casas.add(new CasaParaiso(idCasa, metrosCuadrados, nroPlantas,
                                        esEsquinera, orientacion, tamañoPatio,
                                        numHabitacion, costoBase, idRelacion, nombreCasa));                       
                        break;
                    case "Cielo":
                        casas.add(new CasaCielo(idCasa, metrosCuadrados, nroPlantas,
                                        esEsquinera, orientacion, tamañoPatio,
                                        numHabitacion, costoBase, idRelacion, nombreCasa));                
                        break;
                    default:
                        break;
                } 
            } 
            conexion.anular_puentes();
            return casas;
        } catch( SQLException e ){
            // System.out.println( e.getSQLState() );
        } 
        return null;
    }    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
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
                                        numHabitacion, costoBase, idRelacion,nombreCasa));
                        break;
                    case "Paraiso":
                        casas.add(new CasaParaiso(idCasa, metrosCuadrados, nroPlantas,
                                        esEsquinera, orientacion, tamañoPatio,
                                        numHabitacion, costoBase, idRelacion, nombreCasa));                       
                        break;
                    case "Cielo":
                        casas.add(new CasaCielo(idCasa, metrosCuadrados, nroPlantas,
                                        esEsquinera, orientacion, tamañoPatio,
                                        numHabitacion, costoBase, idRelacion, nombreCasa));                
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
    
    public void cargarElementosCasa(int idRelacion){
        try{ 
            conexion.iniciar_conexion();
            conexion.setProcedimiento( conexion.getConexion().
                            prepareCall( "call buscarCasaElementos(?)")
            );
            // ec.idElemento, ec.precio, ec.nombre
            conexion.getProcedimiento().setInt(1, idRelacion );
            conexion.setResultado( conexion.getProcedimiento().executeQuery() );
            this.casas.stream().filter((casa) -> (casa.getIdRelacion() ==
                    idRelacion)).forEachOrdered((casa) -> {
                casa.elementosExtra.clear();
            });              
            while ( conexion.getResultado().next() ) {
                ElementoCasa elemento = 
                        new ElementoCasa(conexion.getResultado().getString("idElemento"),                                
                conexion.getResultado().getString("nombre"),
                conexion.getResultado().getFloat("precio"));   
                this.casas.stream().filter((casa) -> (casa.getIdRelacion() ==
                        idRelacion)).forEachOrdered((casa) -> {
                    casa.elementosExtra.add(elemento);
                });                 
            } 
            conexion.anular_puentes();
        } catch( SQLException e ){
            System.out.println( e.getSQLState() );
            System.out.println(e.getCause());
        }         
    }    
    
     public ArrayList<ElementoCasa> buscarCasaElementos(){
        try{ 
            ArrayList<ElementoCasa> elementos = new ArrayList<>();
            conexion.iniciar_conexion();
            conexion.setProcedimiento( conexion.getConexion().
                            prepareCall( "call buscarelementoscasa()")
            );
            // ec.idElemento, ec.precio, ec.nombre
            conexion.setResultado( conexion.getProcedimiento().executeQuery() );
            while ( conexion.getResultado().next() ) {
                elementos.add(
                    new ElementoCasa(conexion.getResultado().getString("idElemento"),                                
                    conexion.getResultado().getString("nombre"),
                    conexion.getResultado().getFloat("precio"))
                );
            } 
            conexion.anular_puentes();
            
            return elementos;
        } catch( SQLException e ){
            System.out.println( e.getSQLState() );
            System.out.println(e.getCause());
        }         
        return null;
    }   
    
    public void agregarElementoCasa(String idElemento, int idRelacion){
        try{ 
            conexion.iniciar_conexion();
            conexion.setProcedimiento( conexion.getConexion().
                            prepareCall( "call agregarElementoCasa(?, ?)")
            );
            // ec.idElemento, ec.precio, ec.nombre
            conexion.getProcedimiento().setString(1, idElemento );
            conexion.getProcedimiento().setInt(2, idRelacion );
            
            conexion.getProcedimiento().executeQuery();
            
            conexion.anular_puentes();
        } catch( SQLException e ){
            System.out.println( e.getSQLState() );
            System.out.println(e.getCause());
        }         
    }
 */
    
}
