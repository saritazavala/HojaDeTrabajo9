import java.util.Objects;

/**
 * @param <V>
 */
/*
Sara Zavala 18893
Hoja de Trabajo 9
Estructura de Datos
Grafos y Floyd
* */
public class Arco<V> {

    /**
     * Atributos
     */
    private V vrtx1;
    private V vrtx2;
    private double distancia;
    private boolean bool;
    private boolean visitado;

    /**
     * @param vrtvrtx1
     * @param vrtx2
     * @param distancia
     * @param bool
     */
    public Arco(V vrtvrtx1, V vrtx2, double distancia, boolean bool) {
        this.vrtx1 = vrtx1;
        this.vrtx2 = vrtx2;
        this.distancia = distancia;
        this.bool = bool;
        this.visitado = false;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arco)) return false;
        Arco<?> arco = (Arco<?>) o;
        return Double.compare(arco.distancia, distancia) == 0 &&
                bool == arco.bool &&
                visitado == arco.visitado &&
                Objects.equals(vrtx1, arco.vrtx1) &&
                Objects.equals(vrtx2, arco.vrtx2);
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(vrtx1, vrtx2, distancia, bool, visitado);
    }

    /**
     * @return this.vrtx1
     */
    public V here() {
        return this.vrtx1;
    }
    public void reset(){
        visitado = false;
    }

    /**
     * @return a donde va. (Destino)
     */
    public V there(){
        return this.vrtx2;
    }

    /**
     * @return distancia entre puntos
     */
    public double distancai(){
        return this.distancia;
    }

    /**
     * @return si esta visitado o no
     */
    public boolean isVisited(){
        return visitado;
    }

    /**
     * @return toString
     */
    @Override
    public String toString() {
        return "Arco{" +
                "vrtx1=" + vrtx1 +
                ", vrtx2=" + vrtx2 +
                ", distancia=" + distancia +
                ", bool=" + bool +
                ", visitado=" + visitado +
                '}';
    }
}