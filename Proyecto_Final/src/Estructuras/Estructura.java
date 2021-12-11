
package Estructuras;

public abstract class Estructura {
    private int longitud;
    
    public Estructura(){
        this.longitud = 0;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
}
