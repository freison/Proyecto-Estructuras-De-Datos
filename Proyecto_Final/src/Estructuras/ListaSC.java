
package Estructuras;

public class ListaSC {
    // ATRIBUTOS DE LA CLASE.
    private NodoLSC inicio;
    private NodoLSC fin;
    private int longitud;
    
    // Constructor sin parametros.
    public ListaSC(){
        this.inicio = null;
        this.fin = null;
    }
    
    // GETTERS Y SETTERS.
    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public NodoLSC getFin() {
        return fin;
    }
    
    // METODOS DE LA CLASE.
    public boolean isLSCEmpty() {
        if (inicio == null){
            return true;
        } 
        else{
            return false;
        }
    }
    
    public void agregar(String cadena, int indice){
        DatoString dato = new DatoString();
        dato.setCadena(cadena);
        NodoLSC nuevo = new NodoLSC();
        nuevo.setElemento(dato);
        
        nuevo.setIndice(indice);
        
        if(isLSCEmpty()){
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
        }
        else if(dato.toDatoString().getCadena()
                .compareToIgnoreCase(inicio.getElemento().toDatoString().getCadena()) < 0){
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            fin.setSiguiente(inicio);
        }
        else if(dato.toDatoString().getCadena()
                .compareToIgnoreCase(fin.getElemento().toDatoString().getCadena()) >= 0){
            fin.setSiguiente(nuevo);
            fin = nuevo;
            fin.setSiguiente(inicio);
        }
        else{
            NodoLSC aux = inicio;
            while(aux.getSiguiente().getElemento().toDatoString().getCadena()
                    .compareToIgnoreCase(dato.toDatoString().getCadena()) < 0){
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }
    
    public Dato obtenerEspecifico(int indice){
        Dato datoAuxiliar = null;
        boolean flag = false;
        if(!isLSCEmpty()){
            NodoLSC aux = inicio;
            if(aux.getIndice() == indice){
                datoAuxiliar = aux.getElemento();
                flag = true;
            }
            aux = aux.getSiguiente();
            while(aux!=inicio && !flag){
                if (aux.getIndice() == indice) {
                    datoAuxiliar = aux.getElemento();
                    flag = true;
                }
                aux = aux.getSiguiente();
            }
        }
        
        return datoAuxiliar;
    }
} // FIN DE CLASE LISTASC
