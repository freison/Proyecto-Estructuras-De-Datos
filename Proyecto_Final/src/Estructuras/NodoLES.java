
package Estructuras;

public class NodoLES {
    private DatoString dato;
    private NodoLES siguiente;
    
    public NodoLES(){
        this.siguiente = null;
    }
    
    // GETTERS Y SETTERS DE LA CLASE.
    public DatoString getDato() {
        return dato;
    }

    public void setDato(DatoString dato) {
        this.dato = dato;
    }

    public NodoLES getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLES siguiente) {
        this.siguiente = siguiente;
    }
    
}
