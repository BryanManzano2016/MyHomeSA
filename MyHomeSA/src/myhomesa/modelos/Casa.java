 
package myhomesa.modelos;
 
import java.util.ArrayList;

public class Casa{
    
    private final String id;
    private float metrosCuadrados;
    private int nroPlantas;
    private int esEsquinera;
    private String orientacion;
    private float tamanoPatio;
    private int numeroHabitaciones;
    private float costoBase;
    private float precio;
    private int idRelacion;
    private String nombreCasa;
    ArrayList<ElementoCasa> elementosExtra;

    public Casa(String id, float metrosCuadrados, int nroPlantas, int esEsquinera,
            String orientacion, float tamanoPatio, int numeroHabitaciones, 
            float costoBase, int idRelacion, String nombreCasa) {
        this.id = id;
        this.metrosCuadrados = metrosCuadrados;
        this.nroPlantas = nroPlantas;
        this.esEsquinera = esEsquinera;
        this.orientacion = orientacion;
        this.tamanoPatio = tamanoPatio;
        this.numeroHabitaciones = numeroHabitaciones;
        this.costoBase = costoBase;
        this.idRelacion = idRelacion;
        this.nombreCasa = nombreCasa;
        
        this.elementosExtra = new ArrayList<>();
    }

    public Casa(String id, float costoBase, String nombreCasa) {
        this.id = id;
        this.costoBase = costoBase;
        this.nombreCasa = nombreCasa;
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

    public void setMetrosCuadrados(float metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public void setNroPlantas(int nroPlantas) {
        this.nroPlantas = nroPlantas;
    }

    public void setEsEsquinera(int esEsquinera) {
        this.esEsquinera = esEsquinera;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public void setTamanoPatio(float tamanoPatio) {
        this.tamanoPatio = tamanoPatio;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public void setCostoBase(float costoBase) {
        this.costoBase = costoBase;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setIdRelacion(int idRelacion) {
        this.idRelacion = idRelacion;
    }

    public void setElementosExtra(ArrayList<ElementoCasa> elementosExtra) {
        this.elementosExtra = elementosExtra;
    }

    public String getNombreCasa() {
        return nombreCasa;
    }

    public void setNombreCasa(String nombreCasa) {
        this.nombreCasa = nombreCasa;
    }
    
    public ArrayList<ElementoCasa> getElementosExtra() {
        return elementosExtra;
    }
    
    public void agregarElementoCasa(ElementoCasa elemento){
        this.elementosExtra.add(elemento);
    }
    
    @Override
    public String toString() {
        return "Casa{" + "id=" + id + ", metrosCuadrados=" + metrosCuadrados + ", nroPlantas=" + nroPlantas + ", esEsquinera=" + esEsquinera + ", orientacion=" + orientacion + ", tamanoPatio=" + tamanoPatio + ", numeroHabitaciones=" + numeroHabitaciones + ", costoBase=" + costoBase + ", precio=" + precio + ", idRelacion=" + idRelacion + '}';
    }
}
