/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ed.lista.ListaEnlazada;
import modelo.Ventas;
/**
 *
 * @author alyce
 */
public class Sucursal {
    private Integer id;
    private String nombre;
    private ListaEnlazada<Ventas> listaEnlazada;

    public Sucursal() {
        this.listaEnlazada =  new ListaEnlazada<>();
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaEnlazada<Ventas> getListaEnlazada() {
         if (listaEnlazada == null) {
            listaEnlazada = new ListaEnlazada<>();
        }
        return listaEnlazada;
    }

    public void setListaEnlazada(ListaEnlazada<Ventas> listaEnlazada) {
        this.listaEnlazada = listaEnlazada;
    }

    

    

    

    
    @Override
    public String toString() {
        return nombre + " "+id;
    }
    
    
    
    
    
}
