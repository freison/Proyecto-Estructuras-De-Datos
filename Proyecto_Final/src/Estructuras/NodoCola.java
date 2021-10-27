
package Estructuras;

public class NodoCola {
    // ATRIBUTOS DE LA CLASE.
    private Dato elemento;
    private NodoCola siguiente;
    
    // CONSTRUCTOR.
    public NodoCola(){
        this.siguiente = null;
    }
    
    // GETTERS Y SETTERS.
    public Dato getElemento() {
        return elemento;
    }

    public void setElemento(Dato elemento) {
        this.elemento = elemento;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
    
}
