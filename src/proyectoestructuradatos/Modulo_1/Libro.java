/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuradatos.Modulo_1;

/**
 *
 * @author migue
 */
public class Libro {
    private String tituloLibro;
    private String autorLibro;
    private String numLibro;
    

    public Libro() {
        this.tituloLibro = "";
        this.autorLibro = "";
        this.numLibro = "";
        
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public String getNumLibro() {
        return numLibro;
    }

    public void setNumLibro(String numLibro) {
        this.numLibro = numLibro;
    }
    
  
}
