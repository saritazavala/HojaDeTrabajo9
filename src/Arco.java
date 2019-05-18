public class Arco<V> {

    private V vrtx1;
    private V vrtx2;
    private double distancia;
    private boolean bool;
    private boolean visitado;

    public Arco(V vrtvrtx11, V vrtx2, double distancia, boolean bool) {
        this.vrtx1 = vrtx1;
        this.vrtx2 = vrtx2;
        this.distancia = distancia;
        this.bool = bool;
        this.visitado = false;
    }
    public V here() {
        return this.vrtx1;
    }
    public void reset(){
        visitado = false;
    }
    public V there(){
        return this.vrtx2;
    }
    public double label(){
        return this.distancia;
    }
    public boolean isVisited(){
        return visitado;
    }


}