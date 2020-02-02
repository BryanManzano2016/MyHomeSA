/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhomesa.modelos;

/**
 *
 * @author Dark
 */
public class CasaOasis extends Casa{

    protected final String nombreCasa;

    public CasaOasis(String id, float metrosCuadrados, int nroPlantas, int esEsquinera,
            String orientacion, float tamanoPatio, int numeroHabitaciones, 
            float costoBase, int idRelacion) {
        super(id, metrosCuadrados, nroPlantas, esEsquinera, orientacion, tamanoPatio,
                numeroHabitaciones, costoBase, idRelacion);
        this.nombreCasa = "Cielo";
    }

    public String getNombreCasa() {
        return nombreCasa;
    }
    
}
