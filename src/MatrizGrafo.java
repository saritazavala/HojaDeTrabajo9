import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Sara Zavala 18893
Hoja de Trabajo 9
Estructura de Datos
Grafos y Floyd
* */

public class MatrizGrafo<V> {

    //Referencias tomadas
    //https://www.baeldung.com/java-graphs
    //Todos los metodos que se encuentran en esta clase fueron tomados de intenet y modificados para el uso de esat hoja
    //http://www.ciberaula.com/articulo/grafos
    //https://www.geeksforgeeks.org/graph-and-its-representations/
    //http://www.cs.williams.edu/~jeannie/cs136/javadoc/structure5/structure5/GraphMatrixDirected.html#GraphMatrixDirected
    //http://www.java2s.com/Code/Java/Collections-Data-Structure/Adirectedgraphdatastructure.htm
    //https://www.dreamincode.net/forums/topic/166043-help-me-implement-addedge-method/
    // http://dept.cs.williams.edu/~bailey/JavaStructures/Book_files/JavaStructures.pdf
    //https://algorithms.tutorialhorizon.com/graph-implementation-adjacency-matrix-set-3/

    protected Arco<V> matriz[][]; //Matriz
    protected Map<V,Vertice<V>> dict;
    protected List<Integer> freeList;
    protected List<String> lista;
    protected  Double[][] datos; //Distancias
    protected int size;


    /**
     * @param size
     * Constructor
     */
    public MatrizGrafo(int size) {
        this.lista = new ArrayList<>();
        this.size = size;
        this.matriz = new Arco[size][size];
        this.datos = new Double[size][size];
        this.dict = new HashMap<>(size);
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

    /**
     * Printear el grafo
     */
    public void MostrarEnPantalla() {
        System.out.println("Matriz: ");
        System.out.print("\t\t\t");
        for(int k = lista.size()-1; k >=0; k--){
            System.out.print(lista.get(k)+"\t\t");
        }
        System.out.println("");
        int no = lista.size()-1;
        for (int i = 0; i < datos.length; i++) {
            if(no>=0){
                System.out.print(lista.get(no).toString()+"\t\t");
                no--;
            }
            for (int j = 0; j <datos.length; j++) {
                System.out.print(datos[i][j]+ "\t\t");
            }
            System.out.println();
        }
    }

    /**
     * @param nombre
     * Añadir Vertices
     */
    public void add(V nombre) {
        if (dict.containsKey(nombre)) return;
        int pos = freeList.remove(0);
        dict.put(nombre, new Vertice<>(nombre,pos));
        lista.add(nombre.toString());
    }


    /**
     * @param vtx1
     * @param vtx2
     * @param label
     * @return
     *
     * Añadir Arcos
     */
    public String addEdge(V vtx1, V vtx2, double label) {
        Vertice<V> vertice1 = dict.get(vtx1);
        Vertice<V> vertice2 = dict.get(vtx2);
        // Verifica que los vertices esten en el mapa
        if(vertice1 == null || vertice2 == null) {
            return "No se encuntra";
        }else {
            matriz[vertice1.getPosicion()][vertice2.getPosicion()] = new Arco<V>(vtx1, vtx2, label, true);
            datos[vertice1.getPosicion()][vertice2.getPosicion()] = label;
            return "Realizado con exito";
        }
    }

    /**
     * @param vrt1
     * @param vrt2
     * @return
     *
     * Eliminar Arcos
     */
    public String removeEdge(V vrt1, V vrt2){
        String cadena1 = "No se realizo la accion";
        String cadena2 = "Se realizo la accion";
        Vertice<V> vertice1 = dict.get(vrt1);
        Vertice<V> vertice2 = dict.get(vrt2);
        if(vertice1 == null || vertice2 == null) {
            return cadena1;
        }else {
            matriz[vertice1.getPosicion()][vertice2.getPosicion()] = null;
            datos[vertice1.getPosicion()][vertice2.getPosicion()] = Double.POSITIVE_INFINITY;
            return cadena2;
        }
    }

    /**
     * @param label1
     * @param label2
     * @return
     *
     * Ruta mas corta entre orgien y destino
     */
    public String getRutaMasCorta(V label1, V label2) {
        Vertice<V> vtx1 = dict.get(label1);
        Vertice<V> vtx2 = dict.get(label2);
        if (vtx1 == null || vtx2 == null) return "Conexion no existente ";
        return "La ruta mas corta es de: " + this.datos[vtx1.posicion][vtx2.posicion] + ".";
    }


    /**
     *
     * @return String
     * Encontrar el centro del grafo
     */
    public String getCentroGrafo() {

        int[] columnaMax = new int[datos.length];
        for (int i = 0; i < datos.length; i++) {
            Double MAX = datos[i][0];
            int post = 0;
            for (int j = 0; j < datos.length; j++) {
                if (i != j) {
                    Double temp = datos[i][j];
                    if (temp > MAX) {
                        MAX = temp;
                        post = j;
                    }
                }
            }
            columnaMax[i] = post;
        }

        int minPos = 0;
        Number min = columnaMax[0];
        for (int x = 0; x < columnaMax.length; x++) {
            Number temp = columnaMax[x];
            if (temp.doubleValue() < min.doubleValue()) {
                min = temp;
                minPos = x;
            }
        }
        return lista.get(lista.size() - 1 - minPos);

        }


    /**
     * @param nom1
     * @param nom2
     * @return
     *
     * Distancia Minima
     */
    public Double getDistanciaMinima(V nom1, V nom2) {
        Vertice<V> vtx1 = dict.get(nom1);
        Vertice<V> vtx2 = dict.get(nom2);
        if (vtx1 == null || vtx2 == null){
            return null;
        }
        return this.datos[vtx1.getPosicion()][vtx2.getPosicion()];
    }
    //Referencia en que me base para realizar lo de Floyd
    //https://es.wikibooks.org/wiki/Programaci%C3%B3n_en_Java/Ap%C3%A9ndices/Implementaci%C3%B3n_del_algoritmo_de_Floyd_en_Java

    /**
     * Algoritmo de Floyd implementado
     */
    public void floyd()
    {
        int n=datos.length;
        Double D[][]=datos;

        String enlaces[][]=new String [n][n];
        String[][] aux_enlaces=new String[datos.length][datos.length];

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
                    Double aux=D[i][j];
                    Double aux2=D[i][k];
                    Double aux3=D[k][j];
                    Double aux4=aux2+aux3;
                    Double res=Math.min(aux,aux4);
                    if(aux!=aux4)
                    {
                        if(res==aux4)
                        {
                            enl_rec="";
                            aux_enlaces[i][j]=k+"";
                            enlaces[i][j]=enlaces(i,k,aux_enlaces,enl_rec)+(k+1);
                        }
                    }
                    D[i][j]=(Double) res;
                }
            }
        }
        datos=D;
    }

    /**
     * Metodo de ayuda para el algoritmo de floyd, extriado de:
     * https://es.wikibooks.org/wiki/Programaci%C3%B3n_en_Java/Ap%C3%A9ndices/Implementaci%C3%B3n_del_algoritmo_de_Floyd_en_Java
     */
    public String enlaces(int i,int k,String[][] aux_enlaces,String enl_rec)
    {
        if(aux_enlaces[i][k].equals(""))
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




