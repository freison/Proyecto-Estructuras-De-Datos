
package Estructuras;

public abstract class Dato {
    
    public DatoString toDatoString(){
        return (DatoString)this;
    }
    
    public DatoInt toDatoInt(){
        return (DatoInt)this;
    }
}
