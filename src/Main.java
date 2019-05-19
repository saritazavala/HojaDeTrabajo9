import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/*
Sara Zavala 18893
Hoja de Trabajo 9
Estructura de Datos
Grafos y Floyd
* */

public class Main {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

/*********************************************************************/
//Metodos para leer los documentos tomado de aqui
//https://blog.openalfa.com/como-leer-un-fichero-de-texto-linea-a-linea-en-java
/*********************************************************************/
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


//Primero se crea una lista con los datos del txt para poder saber la cantidad de elementos
//Existentes y asi saber de cuanto va a ser el grafo
        File file = new File("guategrafo.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> informacion = new ArrayList<>(); //Lista para menter cada una de las lineas
        while((line = br.readLine()) != null){ //Mientras hayan lineas
            String[] parts = line.split(" "); //Se van a splitear las lineas cada vez que haya un espacio
            String origen = parts[0]; //Origen va a ser el indice 0
            if(!informacion.contains(origen)){ //Contiene
                informacion.add(origen); //Se añade a la lista
            }
            String destino = parts[1]; //Destino va a ser el indice 1
            if(!informacion.contains(destino)){
                informacion.add(destino);
            }
        }
        int total = informacion.size(); //Total de elementos en la lista
      // System.out.println(total);

//Se crea una matrizGrafo de Strings del mismmo tamaño que la cantidad de elemtnos de la lista previamente creada
/*********************************************************************/
        MatrizGrafo<String> grafito = new MatrizGrafo<String>(total);
/*********************************************************************/

//Aqui se vuelve a leer el documento, pero esta vez ya para crear nuestros arcos y vertices
        File filex2 = new File("guategrafo.txt");
        FileReader frx2 = new FileReader(filex2);
        BufferedReader brx2 = new BufferedReader(frx2);

        String linex2;

        while((linex2 = brx2.readLine()) != null){
            String[] parts = linex2.split(" ");
            String origen = parts[0];
            if(!grafito.lista.contains(origen)){
                grafito.add(origen); }
            String desitino = parts[1];
            if(!grafito.lista.contains(desitino)){
                grafito.add(desitino); }
            int distancia = Integer.parseInt(parts[2]);
            grafito.addEdge(origen,desitino,distancia);
            //grafito.MostrarEnPantalla();
        }
       grafito.floyd();
        //grafito.MostrarEnPantalla();
        //System.out.println("");

//Menu de opciones
        while (true) {
            System.out.println("Menu de opciones");
            System.out.println("1. Buscar distancia entre ciudades");
            System.out.println("2. Mosrar centro del grafo");
            System.out.println("3. Modificar Grafo");
            System.out.println("4. Imprimir matriz");
            System.out.println("5. Salir");

            String opcion = teclado.nextLine();


            if (opcion.equals("1")) {
                System.out.println("Ingrese el nombre de la ciudad origen");
                String origen = teclado.nextLine().toLowerCase();
                System.out.println("Ingrese el nombre de la ciudad destino");
                String destino = teclado.nextLine().toLowerCase();
                if (grafito.lista.contains(origen) && grafito.lista.contains(destino)) {
                    Double distanciaTotal = grafito.getDistanciaMinima(origen, destino);
                    if (distanciaTotal != Double.POSITIVE_INFINITY) {
                        System.out.println("La distancia minima entre" + origen + "y" + destino + "es de:" + distanciaTotal + "km");
                    }
                    else {
                        System.out.println("Ciudades no encontradas");
                    }
                }
            }

            else if (opcion.equals("2")) {
                System.out.println("El centro del grafo es:"+ grafito.getCentroGrafo());
            }

            else if (opcion.equals("3")) {
                System.out.println("Ingrese opcion deseada");
                System.out.println("1. Agregar conexion");
                System.out.println("2. Eliminar conexion");
                String modificacion = teclado.nextLine();

                if (modificacion.equals("1")) {
                    System.out.println("Ingrese el nombre de la ciudad origen");
                    String origen = teclado.nextLine().toLowerCase();
                    System.out.println("Ingrese el nombre de la ciudad destino");
                    String destino = teclado.nextLine().toLowerCase();
                    System.out.println("Ingrese la distancia entre ellas");
                    double distancia = teclado.nextDouble();
                    teclado.nextLine();
                    try {
                        grafito.addEdge(origen,destino,distancia);
                        System.out.println("Conexion creada");
                    }
                    catch (Exception e){
                        System.out.println("Opciones ingresadas invalidas");
                    }
                    grafito.floyd();
                }
                else if (modificacion.equals("2")){
                    System.out.println("Ingrese el nombre de la ciudad origen");
                    String origen = teclado.nextLine().toLowerCase();
                    System.out.println("Ingrese el nombre de la ciudad destino");
                    String destino = teclado.nextLine().toLowerCase();
                    try {
                        grafito.removeEdge(origen,destino);
                        System.out.println("Eliminacion completada");
                    }
                    catch (Exception e){
                        System.out.println("Opciones ingresadas invalidas");
                    }
                    grafito.floyd();
                }
                else {
                    System.out.println("Opcion no valida");
                }
            }
            else if (opcion.equals("4")) {
                grafito.MostrarEnPantalla();
            }
            else if (opcion.equals("5")) {
                System.out.println("Thanks, bai");
                break;
            }
            else{
                System.out.println("Opcion no valida");
            }
        }
    }
}
