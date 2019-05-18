import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrizGrafo<V,E> {

    //http://www.ciberaula.com/articulo/grafos
    //http://www.cs.williams.edu/~jeannie/cs136/javadoc/structure5/structure5/GraphMatrixDirected.html#GraphMatrixDirected
    //http://www.java2s.com/Code/Java/Collections-Data-Structure/Adirectedgraphdatastructure.htm
    //https://www.dreamincode.net/forums/topic/166043-help-me-implement-addedge-method/

    public int size;
    public Arco<V> info[][]; //Matriz
    public Map<V,Vertice<V>> vert;
    public List<Integer> freeList;
    public List<String> lista;
    Double[][] datos; //Distancias


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


    public boolean addEdge(V vtx1, V vtx2, double label) {
        Vertice<V> vertice1 = vert.get(vtx1);
        Vertice<V> vertice2 = vert.get(vtx2);
        // Verifica que los vertices esten en el mapa
        if(vertice1 == null || vertice2 == null) {
            return false;
        }else {
            info[vertice1.getPosicion()][vertice2.getPosicion()] = new Arco<V>(vtx1, vtx2, label, true);
            datos[vertice1.getPosicion()][vertice2.getPosicion()] = label;
            return true;
        }
    }

    public String removeEdge(V vrt1, V vrt2){
        String cadena1 = "No se realizo la accion";
        String cadena2 = "Se realizo la accion";
        Vertice<V> vertice1 = vert.get(vrt1);
        Vertice<V> vertice2 = vert.get(vrt2);
        if(vertice1 == null || vertice2 == null) {
            return cadena1;
        }else {
            info[vertice1.getPosicion()][vertice2.getPosicion()] = null;
            datos[vertice1.getPosicion()][vertice2.getPosicion()] = Double.POSITIVE_INFINITY;
            return cadena2;
        }
    }

    public String getRutaMasCorta(V label1, V label2) {
        Vertice<V> vtx1 = vert.get(label1);
        Vertice<V> vtx2 = vert.get(label2);
        if (vtx1 == null || vtx2 == null) return "No hay conexion!";
        return "La ruta mas corta es de: " + this.datos[vtx1.posicion][vtx2.posicion] + ".";
    }


    public String getCentroGrafo(V label) {

        int[] columna = new int[datos.length];
        for (int i = 0; i < datos.length; i++) {
            Double max = datos[i][0];
            int pos = 0;
            for (int j = 0; j < datos.length; j++) {
                if (i != j) {
                    Double temp = datos[i][j];
                    if (temp > max) {
                        max = temp;
                        pos = j;
                    }
                }
            }
            columna[i] = pos;
        }

        int minPos = 0;
        Number min = columna[0];
        for (int x = 0; x < columna.length; x++) {
            Number temp = columna[x];
            if (temp.doubleValue() < min.doubleValue()) {
                min = temp;
                minPos = x;
            }
        }
        return lista.get(lista.size() - 1 - minPos);

        }
    }