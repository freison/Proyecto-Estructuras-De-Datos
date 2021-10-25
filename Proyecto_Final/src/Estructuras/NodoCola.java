
package Estructuras;

public class NodoCola {
    // ATRIBUTOS DE LA CLASE.
    private DatoString elemento;
    private NodoCola siguiente;
    
    // CONSTRUCTOR.
    public NodoCola(){
        this.siguiente = null;
    }
    
    // GETTERS Y SETTERS.
    public DatoString getElemento() {
        return elemento;
    }

    public void setElemento(DatoString elemento) {
        this.elemento = elemento;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
    
}
