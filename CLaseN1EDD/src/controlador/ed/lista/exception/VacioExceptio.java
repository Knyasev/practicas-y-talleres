/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.lista.exception;

/**
 *
 * @author wilson7578
 */
public class VacioExceptio extends Exception{

    public VacioExceptio(String message) {
        super(message);
    }
    
    public VacioExceptio() {
        super("la lista esta vacia");
    }
}
