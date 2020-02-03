 
package myhomesa.modelos;
 
import java.util.ArrayList;

public interface CreadorCasa {
    
    public ArrayList<Casa> getCasas();

    public void setCasas(ArrayList<Casa> casas);
    
    public void buscarCasaUsuario();    
    
    public void cargarElementosCasa(int idRelacion);    
    
     public ArrayList<ElementoCasa> buscarCasaElementos();
    
    public void agregarElementoCasa(String idElemento, int idRelacion);
    
}
