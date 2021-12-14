
package Estructuras;

import javax.swing.tree.DefaultMutableTreeNode;

public class Arbol extends Estructura {
    // ATRIBUTOS.
    private NodoArbol raiz;
    private int longitud;
    private static DefaultMutableTreeNode dato = new DefaultMutableTreeNode("Tareas Asignadas");
    
    // CONSTRUCTOR.
    public Arbol(){
        this.raiz = null;
    }
    
    // METODOS.
    public boolean isArbolEmpty(){
        if(raiz == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void crearRaiz(String cadena, int indice){
        DatoString dato = new DatoString();
        dato.setCadena(cadena);
        NodoArbol nuevo = new NodoArbol();
        nuevo.setElemento(dato);
        nuevo.setIndice(indice);
        
        if(isArbolEmpty()){
            raiz = nuevo;
        }
        else{
            crearNodo(raiz, nuevo);
        }
    }
    
    public void crearNodo(NodoArbol raiz, NodoArbol nuevo){
        if(nuevo.getElemento().toDatoString().getCadena()
                .compareToIgnoreCase(raiz.getElemento().toDatoString().getCadena()) <=0){
            if(raiz.getEnlaceIzq() == null){
                raiz.setEnlaceIzq(nuevo);
            }
            else{
                crearNodo(raiz.getEnlaceIzq(), nuevo);
            }
        }
        else{
            if(raiz.getEnlaceDer() == null){
                raiz.setEnlaceDer(nuevo);
            }
            else{
                crearNodo(raiz.getEnlaceDer(), nuevo);
            }
        }
    }
    
    public Dato obtenerEspecifico(int indice, NodoArbol n){
        Dato dato = null;
        if(n!=null){
            obtenerEspecifico(indice, n.getEnlaceIzq());
            if(n.getIndice() == indice){
                dato = n.getElemento();
            }
            obtenerEspecifico(indice, n.getEnlaceDer());
        }
        
        return dato;
    }
    
    public Dato obtenerEspecifico(int indice){
        return obtenerEspecifico(indice, raiz);
    }
    
    public DefaultMutableTreeNode obtenerEspecifico(NodoArbol n){
        if(n!=null){
            obtenerEspecifico(n.getEnlaceIzq());
            DefaultMutableTreeNode aux = new DefaultMutableTreeNode(n.getElemento().toDatoString().getCadena());
            dato.add(aux);
            obtenerEspecifico(n.getEnlaceDer());
        }
        return dato;
    }
    
    public DefaultMutableTreeNode obtenerEspecifico(){
        return this.obtenerEspecifico(raiz);
    }
}
