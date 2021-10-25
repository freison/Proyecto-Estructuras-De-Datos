/**
 * Lista Enlazada Simple
 */

package Estructuras;

import javax.swing.JOptionPane;

public class ListaES {
    private NodoLES inicio;
    
    public ListaES(){
        this.inicio = null;
    }
    
    public boolean isEmptyLES(){
        if(inicio == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void Agregar(String cadena, int indice){
        DatoString dato = new DatoString();
        dato.setCadena(cadena);
        dato.setIndice(indice);
        NodoLES nuevo = new NodoLES();
        
        if(isEmptyLES()){
            inicio = nuevo;
        }
        else if(dato.getCadena().compareTo(inicio.getDato().getCadena())<0){
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        else if(inicio.getSiguiente()==null){
            inicio.setSiguiente(nuevo);
        }
        else{
            NodoLES aux = inicio;
            while((aux.getSiguiente()!=null) && 
                    (aux.getSiguiente().getDato().getCadena().compareTo(dato.getCadena())<0)){
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
            if(inicio.getDato().getCadena().equalsIgnoreCase(cadena)){
                inicio = inicio.getSiguiente();
            }
            else{
                NodoLES anterior;
                NodoLES auxiliar;
                anterior = inicio;
                auxiliar = inicio.getSiguiente();
                while((auxiliar!=null) &&
                        (!auxiliar.getDato().getCadena().equals(cadena))){
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
