/**
 * Lista Enlazada Simple
 */

package Estructuras;

import javax.swing.JOptionPane;

public class ListaES {
    private NodoLES inicio;
    private int longitud;
    
    public ListaES(){
        this.inicio = null;
        this.longitud = 0;
    }
    
    // GETTERS Y SETTERS
    public int getLongitud(){
        return this.longitud;
    }
    
    public void setLongitud(int longitud){
        this.longitud = longitud;
    }
    
    // MÉTODOS
    public boolean isEmptyLES(){
        if(inicio == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void Agregar(String cadena, int indice){
        Dato dato = new DatoString();
        dato.toDatoString().setCadena(cadena);
        // dato.toDatoString().setIndice(indice);
        NodoLES nuevo = new NodoLES();
        nuevo.setDato(dato);
        nuevo.setIndice(indice);
        
        if(isEmptyLES()){
            inicio = nuevo;
        }
        else if(dato.toDatoString().getCadena().compareTo(inicio.getDato().toDatoString().getCadena())<0){
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        else if(inicio.getSiguiente()==null){
            inicio.setSiguiente(nuevo);
        }
        else{
            NodoLES aux = inicio;
            while((aux.getSiguiente()!=null) && 
                    (aux.getSiguiente().getDato().toDatoString().getCadena().compareTo(dato.toDatoString().getCadena())<0)){
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }
    
    public void extraer(){
        if(!isEmptyLES()){
            inicio = inicio.getSiguiente();
            JOptionPane.showMessageDialog(null, "Elmeneto extraído");
        }
        else{
            JOptionPane.showMessageDialog(null, "No se puede extraer, lista vacía");
        }
    }
    
    public void extraerEspecifico(String cadena){
        if(!isEmptyLES()){
            if(inicio.getDato().toDatoString().getCadena().equalsIgnoreCase(cadena)){
                inicio = inicio.getSiguiente();
            }
            else{
                NodoLES anterior;
                NodoLES auxiliar;
                anterior = inicio;
                auxiliar = inicio.getSiguiente();
                while((auxiliar!=null) &&
                        (!auxiliar.getDato().toDatoString().getCadena().equals(cadena))){
                    anterior = anterior.getSiguiente();
                    auxiliar = auxiliar.getSiguiente();
                }
                if(auxiliar!=null){
                    anterior.setSiguiente(auxiliar.getSiguiente());
                }
            }
        }
    }
}
