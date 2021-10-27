
package Estructuras;

public abstract class Dato {
    
    private int indice;
    
    // GETTERS Y SETTERS.

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    } 
    
    public DatoString toDatoString(){
        return (DatoString)this;
    }
    
    public DatoInt toDatoInt(){
        return (DatoInt)this;
    }
}
