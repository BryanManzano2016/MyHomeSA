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

    public CasaOasis(String id, float metrosCuadrados, int nroPlantas, int esEsquinera,
            String orientacion, float tamanoPatio, int numeroHabitaciones, 
            float costoBase, int idRelacion, String nombreCasa) {
        super(id, metrosCuadrados, nroPlantas, esEsquinera, orientacion, tamanoPatio,
                numeroHabitaciones, costoBase, idRelacion, nombreCasa);
    }

    public CasaOasis(String id, float costoBase, String nombreCasa) {
        super(id, costoBase, nombreCasa);
    }
    
}
