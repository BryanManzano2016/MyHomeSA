 
package myhomesa.modelos;
 
public class ElementoCasa {   
    private String id;
    private String nombre;
    private float precio;

    public ElementoCasa(String id, String nombre, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ElementoCasa{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
}
