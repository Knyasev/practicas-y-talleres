/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioExceptio;
import controlador.exception.EspacioException;
import modelo.EnumMes;
import modelo.Sucursal;
import modelo.Ventas;

/**
 *
 * @author alyce
 */
public class SucursalControlLista<E> {

    ListaEnlazada<Sucursal> SucursalList;
    ListaEnlazada<Ventas> ventasList;

    private Sucursal sucursal;
    private Ventas venta;

    public SucursalControlLista() {
        SucursalList = new ListaEnlazada<>();
        ventasList = new ListaEnlazada<>();

    }

    public Sucursal getSucursal() {
        if (sucursal == null) {
            sucursal = new Sucursal();
        }
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public ListaEnlazada<Ventas> getVentasList() {

        return ventasList;
    }

    public void setVentasList(ListaEnlazada<Ventas> ventasList) {
        if (ventasList == null) {
            ventasList = new ListaEnlazada<>();
        }
        this.ventasList = ventasList;
    }

    public Ventas getVenta() {
        if (venta == null) {
            venta = new Ventas();
        }
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public ListaEnlazada<Sucursal> getSucursalList() {
        return SucursalList;
    }

    public void setSucursalList(ListaEnlazada<Sucursal> SucursalList) {
        this.SucursalList = SucursalList;
    }

    public boolean registrar() throws EspacioException, VacioExceptio, PosicionException {

        if (sucursal.getId() == null) {
            sucursal.setId(0);
            for (int i = 0; i < SucursalList.size(); i++) {
                sucursal.setId(i + 1);
            }
        }
        sucursal.setListaEnlazada(ventasList);
        for (int i = 0; i < EnumMes.values().length; i++) {
            Ventas venta = new Ventas();
            venta.setId(i + 1);
            venta.setMes(EnumMes.values()[i]);
            venta.setValor(0.0);
           ventasList.InsertarNodo(venta);

        
       
        }
        SucursalList.insertarInicio(sucursal);
        SucursalList.imprimir();
        ventasList.imprimir();
        return true;
    }

    public boolean guardarVentas(Integer posVenta, Double valor) throws EspacioException, PosicionException, VacioExceptio {

        if (this.sucursal != null) {
            if (posVenta <= this.ventasList.getSize()) {
                ventasList.get(posVenta).setValor(valor);

            } else {
                throw new EspacioException();
            }
        } else {
            throw new NullPointerException("Se debe elegir una sucursal");
        }
        return true;

    }

    public boolean calcularPromedio(Double totalVentas, Enum enumMes) {
        Double valor = 0.0;
        if (totalVentas == null) {
            System.out.println("El total de ventas es cero");

        }

        return true;
    }
}
