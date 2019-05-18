public class Arco<V> {

    public V vrt1;
    public V vrt2;
    public double distancia;
    public boolean bool;
    public boolean visitado;

    public Arco(V vrt1, V vrt2, double distancia, boolean bool) {
        this.vrt1 = vrt1;
        this.vrt2 = vrt2;
        this.distancia = distancia;
        this.bool = bool;
        this.visitado = false;
    }
    public V here() {
        return this.vrt1;
    }
    public void reset(){
        visitado = false;
    }
    public V there(){
        return this.vrt2;
    }
    public double label(){
        return this.distancia;
    }
    public boolean isVisited(){
        return visitado;
    }


}