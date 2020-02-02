 
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
    
    private final String host = "localhost";
    private final String puerto = "3306";
    private final String usuarioDB = "root";
    private final String passDB = "mysql";

    public Conexion() {
        conexion = null; 
        procedimiento = null; 
        resultado = null;
    }
    
     // Activa los enlaces para la conexion de base de datos
    public void iniciar_conexion(){
        try { 
            String url = String.format("jdbc:mysql://%s:%s/%s?useSSL=false"
                    + "&serverTimezone=UTC", 
                    host, puerto, "myhomemaripo");
            this.conexion = DriverManager.getConnection(url, usuarioDB, passDB);
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }               
    }        
    // Anula las variables globales
    public void anular_puentes(){
        this.conexion = null; this.procedimiento = null; this.resultado = null;
    }             
    
    public Connection getConexion() {
        return conexion;
    }

    public CallableStatement getProcedimiento() {
        return procedimiento;
    }

    public ResultSet getResultado() {
        return resultado;
    }
    
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void setProcedimiento(CallableStatement procedimiento) {
        this.procedimiento = procedimiento;
    }

    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }    
}
