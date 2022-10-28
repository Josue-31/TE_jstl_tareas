package com.emergentes.modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author CJ
 */
public class GestorTareas {
    private ArrayList<Tarea> lista;

    public GestorTareas() {
        this.lista = new ArrayList<Tarea>();
    }

    public ArrayList<Tarea> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Tarea> lista) {
        this.lista = lista;
    }

    public void insertarTarea(Tarea tarea){
        this.lista.add(tarea);
    }
    
    public void modificarTarea(int pos, Tarea tarea){
        this.lista.set(pos, tarea);
    }
    
    public void eliminarTarea(int pos){
        this.lista.remove(pos);
    }
    
    public int obtieneId(){
        int idaux = 0;
        for (Tarea tarea : lista) {
            idaux = tarea.getId();
        }
        return idaux + 1;
    }
    
    public int ubicarTarea(int id){
        int pos = -1;
        Iterator<Tarea> it = lista.iterator();
        
        while (it.hasNext()) {            
            ++pos;
            Tarea aux = it.next();
            
            if(aux.getId() == id){
                break;
            }
        }
        return pos;
    }
}
