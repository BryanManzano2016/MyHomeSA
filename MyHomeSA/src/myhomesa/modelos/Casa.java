 
package myhomesa.modelos;
 
import java.util.ArrayList;

public abstract class Casa {
    
    private String id;
    private float metrosCuadrados;
    private int nroPlantas;
    private int esEsquinera;
    private String orientacion;
    private float tamanoPatio;
    private int numeroHabitaciones;
    private float costoBase;
    private float precio;
    private int idRelacion;
    ArrayList<ElementoCasa> elementosExtra;

    public Casa(String id, float metrosCuadrados, int nroPlantas, int esEsquinera,
            String orientacion, float tamanoPatio, int numeroHabitaciones, 
            float costoBase, int idRelacion) {
        this.id = id;
        this.metrosCuadrados = metrosCuadrados;
        this.nroPlantas = nroPlantas;
        this.esEsquinera = esEsquinera;
        this.orientacion = orientacion;
        this.tamanoPatio = tamanoPatio;
        this.numeroHabitaciones = numeroHabitaciones;
        this.costoBase = costoBase;
        this.idRelacion = idRelacion;
        
        this.elementosExtra = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public float getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public int getNroPlantas() {
        return nroPlantas;
    }

    public int getEsEsquinera() {
        return esEsquinera;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public float getTamanoPatio() {
        return tamanoPatio;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public float getCostoBase() {
        return costoBase;
    }

    public float getPrecio() {
        return precio;
    }

    public int getIdRelacion() {
        return idRelacion;
    }

    public ArrayList<ElementoCasa> getElementosExtra() {
        return elementosExtra;
    }
    @Override
    public String toString() {
        return "Casa{" + "id=" + id + ", metrosCuadrados=" + metrosCuadrados + ", nroPlantas=" + nroPlantas + ", esEsquinera=" + esEsquinera + ", orientacion=" + orientacion + ", tamanoPatio=" + tamanoPatio + ", numeroHabitaciones=" + numeroHabitaciones + ", costoBase=" + costoBase + ", precio=" + precio + ", idRelacion=" + idRelacion + '}';
    }
}
