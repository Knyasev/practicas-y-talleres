/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.lista;

import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioExceptio;
import java.lang.reflect.Array;

/**
 *
 * @author wilson7578
 */
public class ListaEnlazada <E> {
    private NodoLista<E> cabecera ;
    private Integer size = 0 ;

    
    public NodoLista getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista cabecera) {
        this.cabecera = cabecera;
    }
    
    public boolean isEmpty(){
        return cabecera == null; 
    }
    
    public boolean InsertarNodo(E info){
         NodoLista<E> nuevo = new NodoLista<>(info,null);
        
        if (isEmpty()) {
            this.cabecera = nuevo ;
            this.size++;
        }else {
        NodoLista<E> aux = cabecera;
            /*for (int i = 0; i < size()-1; i++) {
                aux = aux.getSig();
            }*/ 
     while (aux.getSig() != null) {                
                aux = aux.getSig();
            }
    
            aux.setSig(nuevo);
            this.size++;
        }
    return true ;
    }
     
    public Integer size(){
        return size;
    }
    
    public void imprimir()throws VacioExceptio{
    
        
        
        if (isEmpty()) {
            throw new VacioExceptio();
        }else{
            NodoLista<E> aux = cabecera;
        System.out.println("------Lista-----");    
        for (int i = 0; i < size(); i++) {
            System.out.println(aux.getInfo());
                aux = aux.getSig();
            }
        System.out.println("-----Lista Fin------");
    }}
    public void insertarInicio(E info){
    
        if (isEmpty()) {
            InsertarNodo(info);
    }else {
        NodoLista<E> nuevo = new NodoLista<>(info,null);
        nuevo.setSig(cabecera);
        cabecera = nuevo ;
        size++;
        }
    }
    public void insertarPos(E info ,Integer pos)throws PosicionException{
        if (isEmpty()) {
            InsertarNodo(info);
            
        }else if(pos >= 0 &&pos < size &&pos ==0){
            insertarInicio(info);
        } 
        else if (pos >= 0 &&pos < size ) {
            NodoLista<E> nuevo = new NodoLista<>(info,null);
             NodoLista<E> aux = cabecera ;
             for (int i = 0; i < (pos-1); i++) {
                aux =aux.getSig();
                
            }
              NodoLista<E> sig = aux.getSig();
              aux.setSig(nuevo);
              nuevo.setSig(sig);
              size++;
        }else{
        throw new PosicionException();
        }
{
        
        }
    
    }
    public E get(Integer pos)throws VacioExceptio,PosicionException{
        if (isEmpty()) {
            throw  new VacioExceptio();
        }else {
        E dato = null;
        if (pos >= 0 &&pos < size ){
            if (pos == 0) {
                dato = cabecera.getInfo();
            }else{
            NodoLista<E> aux = cabecera ;
             for (int i = 0; i < pos; i++) {
               aux = aux.getSig();
                
            }
             dato = aux.getInfo();
            }
        }else{
        throw new PosicionException();
        }
        return dato;
        }
    }
    public E delete(Integer pos)throws VacioExceptio,PosicionException{
        if (isEmpty()) {
            throw  new VacioExceptio();
        }else {
        E dato = null;
        if (pos >= 0 &&pos < size ){
            if (pos == 0) {
                dato = cabecera.getInfo();
                cabecera = cabecera.getSig();
                size--;
            }else{
            NodoLista<E> aux = cabecera ;
             for (int i = 0; i < (pos-1); i++) {
               aux = aux.getSig();
                
            }
             dato = aux.getInfo();
               // if ((pos +1)==size) {
                  NodoLista<E> aux1 = aux.getSig();
                    dato = aux1.getInfo();
//                }else{
//                    dato = aux.getInfo();
//                }
                  NodoLista<E> proximo = aux.getSig();
             aux.setSig(proximo.getSig());
             size--;
            }
        }else{
        throw new PosicionException();
        }
        return dato;
        }
    }
    public E[] toArray() {
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) Array.newInstance(cabecera.getInfo().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getInfo();
                aux = aux.getSig();
            }
        }
        return matriz;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
    
    public void deleteAll(){
    this.cabecera = null;
    }
}
