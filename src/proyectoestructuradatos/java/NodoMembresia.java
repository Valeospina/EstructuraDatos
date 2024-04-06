package proyectoestructuradatos.java;

//modulo 7 Gabriel Arr
public class NodoMembresia {

    private Usuario dato;
    private NodoMembresia siguiente;

    public NodoMembresia() {

        this.siguiente = null;
    }

    public Usuario getDato() {
        return dato;
    }

    public void setDato(Usuario dato) {
        this.dato = dato;
    }

    public NodoMembresia getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMembresia siguiente) {
        this.siguiente = siguiente;
    }

}
