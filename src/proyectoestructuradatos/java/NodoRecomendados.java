/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuradatos.java;

/**
 *
 * @author user
 */
public class NodoRecomendados {

    private LibroR dato;
    private NodoRecomendados siguiente;

    public NodoRecomendados() {
        this.dato = null;
        this.siguiente = null;
    }

    public LibroR getDato() {
        return dato;
    }

    public void setDato(LibroR dato) {
        this.dato = dato;
    }

    public NodoRecomendados getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoRecomendados siguiente) {
        this.siguiente = siguiente;
    }

}
