/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuradatos.java;

import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class MenuBb {
     private ColaLibrosPrestados cola;

    public MenuBb() {
        this.cola = new ColaLibrosPrestados();
    }

    public void menu() {
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Menú Principal \n\n\n" +
                            "1. Agregar libro\n" +
                            "2. Prestar libro\n" +
                            "3. Mostrar los libros agregados\n" +
                            "4. Mostrar los libros prestados\n" +
                            "5. Devolver libro\n" +
                            "6. Buscar libro por título\n" +
                            "7. Agregar nuevo libro\n" +
                            "8. Salir\n\n" +
                            "Digite la opción que desea: ",
                    "MENÚ", JOptionPane.QUESTION_MESSAGE));
            switch (op) {
                case 1:
                    cola.agregar();
                    break;
                case 2:
                    Libro libPrestado = cola.prestarLibro();
                    if (libPrestado != null) {
                        JOptionPane.showMessageDialog(null, "Se ha prestado el libro:\n\n" +
                                "Título del libro: " + libPrestado.getTituloLibro() + "\n" +
                                "Autor del libro: " + libPrestado.getAutorLibro() + "\n" +
                                "Número Libro (ISBN): " + libPrestado.getNumLibro(), "Libro prestado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay libro disponibles para prestar ",
                                "No hay libros", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 3:
                    cola.mostrarLibAgregados();
                    break;
                case 4:
                    cola.mostrarLibPrestados();
                    break;
                case 5:
                    // Lógica para devolver un libro
                    if (cola.vaciaPrestados()) {
                        JOptionPane.showMessageDialog(null, "No hay libros prestados para devolver", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        cola.devolverLibro();
                    }
                    break;
                case 6:
                    String titulo = JOptionPane.showInputDialog("Ingrese el título del libro a buscar:");
                    Libro libroEncontrado = cola.buscarPorTitulo(titulo);
                    if (libroEncontrado != null) {
                        JOptionPane.showMessageDialog(null, "Libro encontrado:\n\n" +
                                "Título del libro: " + libroEncontrado.getTituloLibro() + "\n" +
                                "Autor del libro: " + libroEncontrado.getAutorLibro() + "\n" +
                                "Número Libro (ISBN): " + libroEncontrado.getNumLibro(), "Libro encontrado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ningún libro con ese título.",
                                "Libro no encontrado", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case 7:
                    cola.agregarNuevoLibro();
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Saliendo del Sistema... ", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida! Por favor elija una opción válida",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (op != 8);
    }
}