/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controlador.ed.lista.ListaEnlazada;
import controlador.util.Utilidades;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;
import modelo.Sucursal;
import modelo.Ventas;

/**
 *
 * @author alyce
 */
public class ModeloTablaVenta extends AbstractTableModel{
     private ListaEnlazada<Ventas> listV= new ListaEnlazada<>();
     

    public ListaEnlazada<Ventas> getListV() {
        return listV;
    }

    public void setListS(ListaEnlazada<Ventas> listV) {
        this.listV = listV;
    }
   
    
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return listV.size();
    }

    @Override
    public String getColumnName(int i) {
        
        switch(i) {
            case 0: return "Mes";
            case 1: return "Valor";       
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Ventas v = null;
        try {
            v = listV.get(i);
        } catch (Exception e) {
        }
        switch(i1) {
            case 0: return (v != null ? v.getMes().toString(): "NO DEFINIDO");
            case 1: return (v != null) ? v.getValor() : 0.0;    
            default: return null;
        }
    }
}
