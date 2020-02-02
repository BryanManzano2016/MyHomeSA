 
package Auxiliar;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

 
public class Conexion {
    public boolean ejecutarSentencia(){
        return true;
    }
    
    private Connection conexion;
    private CallableStatement procedimiento;
    private ResultSet resultado;
    
    public Conexion(){
        conexion = null; procedimiento = null; resultado = null;
    }
    // Activa los enlaces para la conexion de base de datos
    private void iniciar_conexion(){
        try {
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/votaciones_cne?serverTimezone=UTC",
                    "root", "root"); 
        } catch (SQLException ex) {
            anular_puentes();
        }               
    }        
    // Anula las variables globales
    private void anular_puentes(){
        this.conexion = null; this.procedimiento = null; this.resultado = null;
    }         
    
    public boolean loginUsuario(){
        this.iniciar_conexion();
        try{ 
            this.procedimiento = conexion.prepareCall( "{call consultar_datos_votante(?, ?, ?)}" );
            // Para retornar un resultSet
            this.procedimiento.setString(1, "");
            this.resultado = this.procedimiento.executeQuery();
            while ( this.resultado.next() ) {
                
                if( this.resultado.getString("cedula").equals("") ){
                    // 
                }
            }          
        } catch( SQLException e ){
            System.out.println(e.getMessage());
        }     
        this.anular_puentes();
        return true;
    }
   
}
