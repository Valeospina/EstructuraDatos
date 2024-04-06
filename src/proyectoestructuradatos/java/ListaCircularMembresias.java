package proyectoestructuradatos.java;

//modulo 7 Gabriel Arr
import javax.swing.JOptionPane;

public class ListaCircularMembresias {

    private NodoMembresia inicio;
    private NodoMembresia fin;

    public ListaCircularMembresias() {
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

    public void agregarUsuario() {
        // Se crer un nuevo objeto Usuario y asignamos el nombre ingresado por el usuario
        Usuario u = new Usuario();
        u.setNombre(JOptionPane.showInputDialog("Pon tu nombre para que te añadas a lista de miembros"));

        // Se crea un nuevo nodo para la membresía y asignarle el Usuario creado
        NodoMembresia nuevo = new NodoMembresia();
        nuevo.setDato(u);

        // Si la lista está vacía, el nuevo nodo se convierte tanto en el inicio como en el fin de la lista
        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio); // Haciendo que la lista sea circular
        } else {
            // Si la lista no está vacía, llamar al método auxiliar para agregar el nodo en el lugar correcto
            agregarRecursivo(nuevo, inicio);
        }
    }

// Método auxiliar recursivo para agregar un usuario a la lista de membresías
    private void agregarRecursivo(NodoMembresia nuevo, NodoMembresia actual) {
        // Si el ID del usuario en el nuevo nodo es menor que el ID del primer usuario en la lista,
        // Inserte el nuevo nodo antes del inicio de la lista
        if (nuevo.getDato().getId() < inicio.getDato().getId()) {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            fin.setSiguiente(inicio); // Actualizar el enlace del último nodo al primero
        } else if (nuevo.getDato().getId() >= fin.getDato().getId()) {
            // Si el ID del usuario en el nuevo nodo es mayor o igual que el ID del último usuario en la lista,
            // insertar el nuevo nodo al final de la lista
            fin.setSiguiente(nuevo);
            fin = nuevo;
            fin.setSiguiente(inicio); // Actualizar el enlace del último nodo al primero
        } else if (actual.getSiguiente().getDato().getId() < nuevo.getDato().getId()) {
            // Si el ID del usuario en el nuevo nodo está entre los ID de dos nodos consecutivos,
            // llamar recursivamente al método para encontrar la posición correcta de inserción
            agregarRecursivo(nuevo, actual.getSiguiente());
        } else {
            // Si el ID del usuario en el nuevo nodo debe ser insertado entre dos nodos consecutivos,
            // ajustar los enlaces para insertar el nuevo nodo en la posición correcta
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }
    }

// Método para mostrar el contenido de la lista de membresías
    public void mostrar() {
        if (!vacia()) {
            String s = "";
            NodoMembresia aux = inicio;
            // Recorrer la lista circular y construir una cadena con la información de cada usuario
            do {
                s += "id:"+aux.getDato().getId() + " - " +aux.getDato().getNombre() + " | ";
                aux = aux.getSiguiente();
            } while (aux != inicio); // El bucle se detiene al llegar de nuevo al inicio
            // Mostrar la lista de usuarios en un cuadro de diálogo
            JOptionPane.showMessageDialog(null, "La lista de miembros contiene: \n" + s, "Contenido de la lista", JOptionPane.PLAIN_MESSAGE);
        } else {
            // Si la lista está vacía, mostrar un mensaje indicando que no hay datos registrados
            JOptionPane.showMessageDialog(null, "No hay datos registrados aun","Miembros", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
