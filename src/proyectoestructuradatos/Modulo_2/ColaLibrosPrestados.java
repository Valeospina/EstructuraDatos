/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuradatos.Modulo_2;

import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class ColaLibrosPrestados {
    private Nodo inicio;
   private Nodo fin;

    public ColaLibrosPrestados() {
        this.inicio = null;
        this.fin = null;
    }
    
    public boolean vacia() {
        if(inicio==null){
            return true;
        }else{
            return false;
        }
    }
    
    public void agregar() {
        Libro libro = new Libro();
        libro.setTituloLibro(
                JOptionPane.showInputDialog("Digite el titulo del libro: "));
        libro.setAutorLibro(
                JOptionPane.showInputDialog("Nombre del autor del libro: "));
        libro.setNumLibro(
                JOptionPane.showInputDialog("Digite el numero del libro(ISBN): "));
        
        Nodo nuevo = new Nodo();
        nuevo.setDato(libro);
        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
        }else{
            fin.setSiguiente(nuevo);
            fin = nuevo;
            fin.setSiguiente(inicio);
        }
    }
    
    public Libro prestarLibro() {
        if (!vacia()) {
            Libro libPrestado = inicio.getDato();
            inicio = inicio.getSiguiente();
            if (inicio == null) {
                fin = null;
            }
            return libPrestado;
        }else {
            return null;
        }
    } 
    public void mostrarLibAgregados() {
        if (!vacia()) {
            Nodo n = inicio;
            String listaLibros = "";
            do {
                Libro libro = n.getDato();
                listaLibros += "Título: " + libro.getTituloLibro()+ "\n";
                listaLibros += "Autor: " + libro.getAutorLibro() + "\n";
                listaLibros += "ISBN: " + libro.getNumLibro()+ "\n\n";
                n = n.getSiguiente();
            } while (n != inicio);
            JOptionPane.showMessageDialog(null, listaLibros, "Libros Agregados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay libros agregados.", "Sin libros", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void mostrarLibPrestados() {
    if (!vacia()) {
        Nodo n = inicio;
        String libPrestados = "";
        do {
            Libro libro = n.getDato();
            libPrestados += "Título: " + libro.getTituloLibro()+ "\n";
            libPrestados += "Autor: " + libro.getAutorLibro()+ "\n";
            libPrestados += "ISBN: " + libro.getNumLibro() + "\n\n";
            n = n.getSiguiente();
        } while (n != inicio);
        JOptionPane.showMessageDialog(null, libPrestados, "Libros Prestados", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "No hay libros prestados.", "Sin libros prestados", JOptionPane.WARNING_MESSAGE);
    }
    }
    
    public void devolverLibro() {
        if(!vacia()) {
            inicio = inicio.getSiguiente();
            JOptionPane.showMessageDialog(null, "El libro se ha devuelto con éxito! ", 
                    "Devolución exitosa", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "No hay libros para devolver", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
