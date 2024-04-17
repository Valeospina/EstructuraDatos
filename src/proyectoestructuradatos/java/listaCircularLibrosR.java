/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuradatos.java;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class listaCircularLibrosR {

    private NodoRecomendados inicio;
    private NodoRecomendados fin;

    public listaCircularLibrosR() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarLibroR() { // crear un nuevo libro para recomendar
        LibroR libro = new LibroR();
        libro.setTituloLibro(JOptionPane.showInputDialog("Ingrese el título del libro a recomendar: "));
        libro.setAutorLibro(JOptionPane.showInputDialog("Ingrese el autor del libro a recomendar: "));
        libro.setNumLibro(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del libro a recomendar: ")));

        // luego hice el nuevo nodo de recomendados para ir metiendo a la lista.
        NodoRecomendados nuevo = new NodoRecomendados();
        nuevo.setDato(libro);

        if (vacia()) {// Si la lista está vacía el nodo es el inico de la lista
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
        } else { // Si he ingresado otros nodos entonces se agrega el nuevo al final de la lists
            fin.setSiguiente(nuevo);
            fin = nuevo;
            fin.setSiguiente(inicio);
        }
         JOptionPane.showMessageDialog(null, "Libro añadido exitosamente", "Añadido exitosamente", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarLibroR() {
        if (!vacia()) {
            String s = "";
            NodoRecomendados aux = inicio;
            do {
                LibroR libro = aux.getDato();
                s += "Título: " + libro.getTituloLibro() + ", Autor: " + libro.getAutorLibro() + ", ID: " + libro.getNumLibro() + "\n";
                aux = aux.getSiguiente();
            } while (aux != inicio);
            JOptionPane.showMessageDialog(null, "Lista de libros recomendados:\n" + s, "Contenido de la lista", JOptionPane.PLAIN_MESSAGE);
        } else {
            // Si la lista está vacía entonces da un mensaje de error.
            JOptionPane.showMessageDialog(null, "Lo sentimos, no hay libros recomendados en este momento, ingrese uno por favor. ", "Lista de Recomendaciones", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void eliminarLibroR(String titulo) {
        if (!vacia()) {
            if (inicio.getDato().getTituloLibro().equals(titulo)) {
                if (inicio == fin) {
                    inicio = null;
                    fin = null;
                } else {
                    inicio = inicio.getSiguiente();
                    fin.setSiguiente(inicio);
                }
              
            }
            NodoRecomendados actual = inicio;
            while (actual.getSiguiente() != inicio && !actual.getSiguiente().getDato().getTituloLibro().equals(titulo)) {
                actual = actual.getSiguiente();
            }
            if (actual.getSiguiente() != inicio) {
                NodoRecomendados siguiente = actual.getSiguiente().getSiguiente();
                actual.setSiguiente(siguiente);
                if (actual.getSiguiente() == inicio) {
                    fin = actual;
                }
                JOptionPane.showMessageDialog(null, "Libro eliminado exitosamente: " + titulo, "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el libro a eliminar: " + titulo, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La lista de libros recomendados está vacía", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
