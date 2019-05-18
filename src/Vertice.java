/*
Sara Zavala 18893
Hoja de Trabajo 9
Estructura de Datos
Grafos y Floyd
* */

import java.util.Objects;

/**
 * @param <E>
 */
public class Vertice<E> {

    private E nombre;
    private boolean visitado;
    int posicion;

    /**
     * @param nombre
     * @param posicion
     */
    public Vertice(E nombre,  int posicion) {
        this.nombre = nombre;
        this.visitado = visitado;
        this.posicion = posicion;
    }

    /**
     * @return visitado
     */
    public boolean isVisited(){
        return visitado;
    }

    /**
     * @param o
     * @return false
     */
    @Override
    public boolean equals(Object o){
        return false;
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, visitado, posicion);
    }

    /**
     * Reinicia el valor visitado
     */
    public void reset(){
        visitado = false;
    }

    /**
     * @return posicion
     */
    public int getPosicion(){
        return this.posicion;
    }

    /**
     * @return toString
     */
    @Override
    public String toString() {
        return "Vertice{" +
                "nombre=" + nombre +
                ", visitado=" + visitado +
                ", posicion=" + posicion +
                '}';
    }
}