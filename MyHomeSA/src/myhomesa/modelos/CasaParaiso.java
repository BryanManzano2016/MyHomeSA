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
public class CasaParaiso extends Casa {

    protected final String nombreCasa;

    public CasaParaiso(String id, float metrosCuadrados, int nroPlantas, int esEsquinera,
            String orientacion, float tamanoPatio, int numeroHabitaciones, 
            float costoBase, int idRelacion) {
        super(id, metrosCuadrados, nroPlantas, esEsquinera, orientacion, tamanoPatio,
                numeroHabitaciones, costoBase, idRelacion);
        this.nombreCasa = "Cielo";
    }
    
}
