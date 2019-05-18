import com.sun.javafx.geom.Edge;

import java.util.ArrayList;
import java.util.List;

public class Vertice<E> {

    //https://devs4j.com/2017/11/24/implementa-un-grafo-de-ciudades-en-java/
    private String city;
    private List<Arco> edges;

    public Vertice(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Arco> getEdges() {
        return edges;
    }

    public void addEdge(Arco edge) {
        if (edges == null) {
            edges = new ArrayList<>();
        }
        edges.add(edge);
    }

    @Override
    public String toString() {
        return "\n \tNode [city=" + city + ", edges=" + edges + "]";
    }




}
