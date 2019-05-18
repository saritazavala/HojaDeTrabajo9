import java.util.ArrayList;
import java.util.List;

public class Grafo<E> {
    private List<Vertice> nodes;

    public void addNode(Vertice node) {
        if (nodes == null) {
            nodes = new ArrayList<>();
        }
        nodes.add(node);
    }

    public List<Vertice> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return "Graph [nodes=" + nodes + "]";
    }
}
