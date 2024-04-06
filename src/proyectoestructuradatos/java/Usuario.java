package proyectoestructuradatos.java;

//modulo 7 Gabriel Arr
public class Usuario {

    private String nombre;
    private int id;

    public Usuario() {
        this.nombre = "";
        this.id = (int) (Math.random() * 100);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
