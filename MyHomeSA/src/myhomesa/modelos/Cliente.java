 
package myhomesa.modelos;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Cliente extends Usuario{
    boolean estaRegistrado;
    ArrayList<Casa> casas = new ArrayList<>();

    public Cliente(Usuario usuario) {  
        // teniendo usuario puedo usar todos los datos del mismo, asi como enlazar base datos
        casas.add(new Casa());
        this.estaRegistrado = false;
    }


    public Cliente(String nombre, String apellido, String telefono, String direccion, String correo, String cedula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void agregarElementoCasa(ElementoCasa elemento, Casa casa){
        casas.get(0).elementos.add(elemento);
        System.out.println("elemento ingresado");
    }

    public LinkedList<String> consultarCliente(String cedula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
