
package Estructuras;

public class NodoLES {
    private Dato dato;
    private NodoLES siguiente;
    private int indice;
    
    public NodoLES(){
        this.siguiente = null;
    }
    
    // GETTERS Y SETTERS DE LA CLASE.
    public Dato getDato() {
        return dato;
    }

    public void setDato(Dato dato) {
        this.dato = dato;
    }

    public NodoLES getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLES siguiente) {
        this.siguiente = siguiente;
    }
    
    public void setIndice(int indice){
        this.indice = indice;
    }
    
    public int getIndice(){
        return this.indice;
    }
}
