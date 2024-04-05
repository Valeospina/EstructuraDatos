/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuradatos.java;

import javax.swing.JOptionPane;

public class ColaLibrosPrestados {
    private Nodo inicio;
    private Nodo fin;
    private Nodo inicioPrestados;
    private Nodo finPrestados;

    public ColaLibrosPrestados() {
        this.inicio = null;
        this.fin = null;
        this.inicioPrestados = null;
        this.finPrestados = null;
    }

    public boolean vacia() {
        return inicio == null;
    }

    public void agregar() {
        Libro libro = new Libro();
        libro.setTituloLibro(JOptionPane.showInputDialog("Digite el titulo del libro: "));
        libro.setAutorLibro(JOptionPane.showInputDialog("Nombre del autor del libro: "));
        libro.setNumLibro(JOptionPane.showInputDialog("Digite el numero del libro(ISBN): "));

        Nodo nuevo = new Nodo();
        nuevo.setDato(libro);
        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
        } else {
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
           
            agregarPrestado(libPrestado);
            return libPrestado;
        } else {
            JOptionPane.showMessageDialog(null, "No hay libros disponibles para prestar", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void agregarPrestado(Libro libro) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(libro);

        
        if (inicioPrestados == null) {
            inicioPrestados = nuevo;
            finPrestados = nuevo;
            finPrestados.setSiguiente(inicioPrestados);
        } else {
            finPrestados.setSiguiente(nuevo); 
            finPrestados = nuevo; 
            finPrestados.setSiguiente(inicioPrestados); 
        }
    }

    public void mostrarLibAgregados() {
        if (!vacia()) {
            Nodo n = inicio;
            String listaLibros = "";
            do {
                Libro libro = n.getDato();
                listaLibros += "Título: " + libro.getTituloLibro() + "\n";
                listaLibros += "Autor: " + libro.getAutorLibro() + "\n";
                listaLibros += "ISBN: " + libro.getNumLibro() + "\n\n";
                n = n.getSiguiente();
            } while (n != inicio);
            JOptionPane.showMessageDialog(null, listaLibros, "Libros Agregados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay libros agregados.", "Sin libros", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void mostrarLibPrestados() {
        if (inicioPrestados != null) {
            Nodo n = inicioPrestados;
            String libPrestados = "";
            do {
                Libro libro = n.getDato();
                libPrestados += "Título: " + libro.getTituloLibro() + "\n";
                libPrestados += "Autor: " + libro.getAutorLibro() + "\n";
                libPrestados += "ISBN: " + libro.getNumLibro() + "\n\n";
                n = n.getSiguiente();
            } while (n != inicioPrestados);
            JOptionPane.showMessageDialog(null, libPrestados, "Libros Prestados", JOptionPane.INFORMATION_MESSAGE);
        } else if (vaciaPrestados()) {
            JOptionPane.showMessageDialog(null, "No hay libros prestados.", "Sin libros prestados", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay libros agregados.", "Sin libros", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void agregarDisponible(Libro libro) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(libro);

        
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
            fin.setSiguiente(inicio);
        }
    }

    public void devolverLibro() {
   if (!vaciaPrestados()) {
        Libro libroDevuelto = inicioPrestados.getDato(); 
        
        
        if (inicioPrestados.getSiguiente() == inicioPrestados) { 
            inicioPrestados = null;
        } else {
            Nodo actual = inicioPrestados;
            while (actual.getSiguiente() != inicioPrestados) { 
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(inicioPrestados.getSiguiente()); 
            inicioPrestados = inicioPrestados.getSiguiente();
        }

        
        if (inicioPrestados == null) {
            finPrestados = null; 
        }


   JOptionPane.showMessageDialog(null, "El libro \"" + libroDevuelto.getTituloLibro() + "\" se ha devuelto con éxito!", 
     "Devolución exitosa", JOptionPane.INFORMATION_MESSAGE);
        
        
        if (!vaciaPrestados()) {
            Libro siguienteLibro = inicioPrestados.getDato();
            JOptionPane.showMessageDialog(null, "El siguiente libro prestado es: \n" +
                    "Título: " + siguienteLibro.getTituloLibro() + "\n" +
                    "Autor: " + siguienteLibro.getAutorLibro() + "\n" +
                    "ISBN: " + siguienteLibro.getNumLibro(), 
                    "Siguiente libro prestado", JOptionPane.INFORMATION_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "No hay libros prestados para devolver", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean vaciaPrestados() {
        return inicioPrestados == null;
    }

    public Libro buscarPorTitulo(String titulo) {
    
    Libro libroEncontrado = buscarPorTituloRecursivo(inicio, titulo);
    if (libroEncontrado != null) {
        return libroEncontrado; 
    }

   
    libroEncontrado = buscarPorTituloRecursivo(inicioPrestados, titulo);
    if (libroEncontrado != null) {
        JOptionPane.showMessageDialog(null, "El libro \"" + titulo + "\" está prestado.", "Libro prestado", JOptionPane.INFORMATION_MESSAGE);
        return libroEncontrado; 
    }

   
    JOptionPane.showMessageDialog(null, "El libro \"" + titulo + "\" no se encuentra en el inventario.", "Libro no encontrado", JOptionPane.WARNING_MESSAGE);
    return null;
}

    private Libro buscarPorTituloRecursivo(Nodo nodo, String titulo) {
    if (nodo == null) {
        return null; 
    }

    Libro libro = nodo.getDato();
    if (libro.getTituloLibro().equalsIgnoreCase(titulo)) {
        return libro; 
    }

    
    if (nodo.getSiguiente() == inicio) {
        return null; 
    }

    
    return buscarPorTituloRecursivo(nodo.getSiguiente(), titulo);
    }

    public void agregarNuevoLibro() {
        Libro libro = new Libro();
        libro.setTituloLibro(JOptionPane.showInputDialog("Digite el título del libro: "));
        libro.setAutorLibro(JOptionPane.showInputDialog("Nombre del autor del libro: "));
        libro.setNumLibro(JOptionPane.showInputDialog("Digite el número del libro (ISBN): "));

        Nodo nuevo = new Nodo();
        nuevo.setDato(libro);

        if (vacia()) { 
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
        } else {
            fin.setSiguiente(nuevo); 
            fin = nuevo;
            fin.setSiguiente(inicio);
        }

        JOptionPane.showMessageDialog(null, "El libro \"" + libro.getTituloLibro() + "\" se ha agregado al inventario.", 
                "Libro agregado", JOptionPane.INFORMATION_MESSAGE);
    }
}
