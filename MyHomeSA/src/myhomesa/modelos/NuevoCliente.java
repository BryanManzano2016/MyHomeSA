/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhomesa.modelos;

import java.util.ArrayList;

/**
 *
 * @author MIPC
 */
public class NuevoCliente extends Usuario{
    ArrayList<Casa> casas = new ArrayList<>();
    private boolean estaRegistrado;

    public NuevoCliente(Usuario usuario) {
        casas.add(new Casa());
        this.estaRegistrado = false;
    }
    
    
    
}
