

public class Vertice<E> {

    private E nombre;
    private boolean visitado;
    int posicion;

    public Vertice(E nombre,  int posicion) {
        this.nombre = nombre;
        this.visitado = visitado;
        this.posicion = posicion;
    }


    public boolean isVisited(){
        return visitado;
    }

    public boolean equals(Object o){
        return false;
    }

    public void reset(){
        visitado = false;
    }

    public int getPosicion(){
        return this.posicion;
    }


}