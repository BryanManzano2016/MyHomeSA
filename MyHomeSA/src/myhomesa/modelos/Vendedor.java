 
package myhomesa.modelos;
 
import java.sql.SQLException;
import java.util.ArrayList;

public class Vendedor extends Usuario {

    ArrayList<Casa> casas;

    public Vendedor(Usuario usuario) {
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

    public ArrayList<Casa> getCasas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCasas(ArrayList<Casa> casas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
