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
public class MenuBb {
     private ColaLibrosPrestados cola;
    
    public MenuBb() {
        this.cola = new ColaLibrosPrestados();
    }
    
    public void menu() {
        int op;
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Menú Principal \n\n\n" + 
                            "1. Agregar libro\n" +
                            "2. Prestar libro\n" +
                            "3. Mostrar los libros agregados\n" +
                            "4. Mostrar los libros prestados\n" +
                            "5. Devolver libro\n" +
                            "6. Salir\n\n" +
                            "Digite la iopcion que desea: ",
                    "MENÚ", JOptionPane.QUESTION_MESSAGE));
            switch (op) {
                case 1:
                    /*String tituloLibro = JOptionPane.showInputDialog("Ingrese el título del libro:");
                    String nomAutor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
                    String numLib = JOptionPane.showInputDialog("Ingrese el ISBN del libro:");
                    Libro nuevo = new Libro();*/
                    cola.agregar();
                    break;
                case 2:
                    Libro libPrestado = cola.prestarLibro();
                    if(libPrestado != null) {
                        JOptionPane.showMessageDialog(null, "Se ha prestado el libro:\n\n" +
                                "Titutlo del libro: " + libPrestado.getTituloLibro() + "\n" +
                                "Autor del libro: " + libPrestado.getAutorLibro() + "\n" +
                                "Numero Libro (ISBN): " + libPrestado.getNumLibro(), "Libro prestado", JOptionPane.INFORMATION_MESSAGE);
                    }else {
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
                    cola.devolverLibro();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Salida del sistema exitosa! ", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida! Porfavor eliga una opcion valida", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while (op != 6);
    }
}
