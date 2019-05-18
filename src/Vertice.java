

public class Vertice<E> {

    public E nombre;
    public boolean visitado;
    int posicion;

    public Vertice(E name, int posi) {
        this.nombre = name;
        this.visitado = false;
        this.posicion = posi;
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