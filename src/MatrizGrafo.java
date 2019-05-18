import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrizGrafo<V,E> {

    public int size;
    public Arco<V> info[][];
    public Map<V,Vertice<V>> vert;
    public List<Integer> freeList;
    public List<String> lista;
    Double[][] datos;

    public MatrizGrafo(int size) {
        this.lista = new ArrayList<>();
        this.size = size;
        this.info = new Arco[size][size];
        this.datos = new Double[size][size];
        this.vert = new HashMap<>(size);
        this.freeList = new ArrayList<>();
        for (int row = size-1; row >= 0; row--) { freeList.add(row); }
        for(int i = 0; i < datos.length; i++) {
            for(int j = 0; j < datos.length; j++) {
                datos[i][j] = Double.POSITIVE_INFINITY;
                if(i==j){
                    datos[i][j] = 0.0;
                }
            }
        }
    }
    public void add(V nombre) {
        if (vert.containsKey(nombre)) return;
        int pos = freeList.remove(0);
        vert.put(nombre, new Vertice<>(nombre,pos));
        lista.add(nombre.toString());
    }
}
