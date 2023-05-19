/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioExceptio;
import controlador.util.Utilidades;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelo.Sucursal;
import modelo.Ventas;

/**
 *
 * @author alyce
 */
public class ModeloTablaSucursal extends AbstractTableModel{
    private ListaEnlazada<Sucursal> listS= new ListaEnlazada<>();
  private ListaEnlazada<Ventas> listV= new ListaEnlazada<>();


    public ListaEnlazada<Sucursal> getListS() {
        return listS;
    }

    public void setListS(ListaEnlazada<Sucursal> listS) {
        this.listS = listS;
    }

    

    
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return listS.size();
    }

    @Override
    public String getColumnName(int i) {
        
        switch(i) {
            case 0: return "Nombre";
            case 1: return "Venta Anual";    
            case 2: return "Promedio de ventas";    
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Sucursal s = null;
        
         try {
            s = listS.get(i);
          
        } catch (Exception e) {
        }
        switch(i1) {
            case 0: return (s != null ? s.getNombre(): "NO DEFINIDO");
            case 1: {
                try {
                    return (s != null) ? Utilidades.sumarVentas(s) : 0.0;
                } catch (VacioExceptio ex) {
                    Logger.getLogger(ModeloTablaSucursal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PosicionException ex) {
                    Logger.getLogger(ModeloTablaSucursal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    
            case 2: {
                try {
                    return (s != null) ? Utilidades.mediaVentas(s) : 0.0;
                } catch (VacioExceptio ex) {
                    Logger.getLogger(ModeloTablaSucursal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PosicionException ex) {
                    Logger.getLogger(ModeloTablaSucursal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
   
            default: return null;
        }
    }
}
