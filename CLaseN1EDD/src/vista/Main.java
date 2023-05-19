/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.SucursalControlLista;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioExceptio;
import controlador.util.Utilidades;
import modelo.EnumMes;
import modelo.Sucursal;

/**
 *
 * @author alyce
 */
public class Main {

    public static void main(String[] args) {
        // System.out.println("Hola");
        SucursalControlLista sc = new SucursalControlLista();
        
        try {
            
            
            sc.getSucursal().setId(0);
            sc.getSucursal().setNombre("adasd");
            sc.registrar();
            sc.setSucursal(null);
            
            
            sc.getSucursal().setId(1);
            sc.getSucursal().setNombre("112");
            sc.registrar();
            sc.setSucursal(null);
          
     
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
}
