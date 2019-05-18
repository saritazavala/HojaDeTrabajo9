import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrizGrafo<V,E> {

    //http://www.ciberaula.com/articulo/grafos
    //http://www.cs.williams.edu/~jeannie/cs136/javadoc/structure5/structure5/GraphMatrixDirected.html#GraphMatrixDirected
    //http://www.java2s.com/Code/Java/Collections-Data-Structure/Adirectedgraphdatastructure.htm
    //https://www.dreamincode.net/forums/topic/166043-help-me-implement-addedge-method/
    // http://dept.cs.williams.edu/~bailey/JavaStructures/Book_files/JavaStructures.pdf
    //https://algorithms.tutorialhorizon.com/graph-implementation-adjacency-matrix-set-3/

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


    public Double getDistanciaMinima(V nom1, V nom2) {
        Vertice<V> vtx1 = vert.get(nom1);
        Vertice<V> vtx2 = vert.get(nom2);
        if (vtx1 == null || vtx2 == null){
            return null;
        }
        return this.datos[vtx1.getPosicion()][vtx2.getPosicion()];
    }
    //Referencia en que me base para realizar lo de Floyd
    //https://es.wikibooks.org/wiki/Programaci%C3%B3n_en_Java/Ap%C3%A9ndices/Implementaci%C3%B3n_del_algoritmo_de_Floyd_en_Java
    public String floyd(long[][] adyacencia)
    {
        int n=adyacencia.length;
        long D[][]=adyacencia;

        String enlaces[][]=new String [n][n];
        String[][] aux_enlaces=new String[adyacencia.length][adyacencia.length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                enlaces[i][j]="";
                aux_enlaces[i][j]="";
            }
        }
        String enl_rec="";
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    float aux=D[i][j];
                    float aux2=D[i][k];
                    float aux3=D[k][j];
                    float aux4=aux2+aux3;
                    float res=Math.min(aux,aux4);
                    if(aux!=aux4)
                    {
                        if(res==aux4)
                        {
                            enl_rec="";
                            aux_enlaces[i][j]=k+"";
                            enlaces[i][j]=enlaces(i,k,aux_enlaces,enl_rec)+(k+1);
                        }
                    }
                    D[i][j]=(long) res;
                }
            }
        }

        String cadena="";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cadena+=D[i][j]+" ";
            }
            cadena+="\n";
        }

        String enlacesres="";
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if(i!=j)
                {
                    if(enlaces[i][j].equals("")==true)
                    {
                        enlacesres+=" De ( "+(i+1)+" a "+(j+1)+" ) = "+"( "+(i+1)+" , "+(j+1)+" )"+"\n";
                    }
                    else
                        enlacesres+=" De ( "+(i+1)+" a "+(j+1)+" ) = ( "+(i+1)+" , "+enlaces[i][j]+" , "+(j+1)+")\n";
                }
            }
        }

        return "las distancias minimas entre nodos son: \n"+cadena+"\nlos caminos minimos entre nodosson:\n"+enlacesres;
    }

    public String enlaces(int i,int k,String[][] aux_enlaces,String enl_rec)
    {
        if(aux_enlaces[i][k].equals("")==true)
        {
            return "";
        }
        else
        {
            enl_rec+=enlaces(i,Integer.parseInt(aux_enlaces[i][k].toString()),aux_enlaces,enl_rec)+(Integer.parseInt(aux_enlaces[i][k].toString())+1)+" , ";
            return enl_rec;
        }
    }

    


    }