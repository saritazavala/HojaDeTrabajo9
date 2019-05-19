import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/*
Sara Zavala 18893
Hoja de Trabajo 9
Estructura de Datos
Grafos y Floyd
* */

//La verdad no me dio tiempo de hacer el main
//Pero segun las test, todos mis metodos sirven :/
//En git ya subi lo que esta completo y terminado
//Gracias
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);


//https://blog.openalfa.com/como-leer-un-fichero-de-texto-linea-a-linea-en-java
/*********************************************************************/
        File file = new File("guategrafo.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> informacion = new ArrayList<>();
        while((line = br.readLine()) != null){
            String[] parts = line.split(" ");
            String origen = parts[0];
            if(!informacion.contains(origen)){
                informacion.add(origen);
            }
            String destino = parts[1];
            if(!informacion.contains(destino)){
                informacion.add(destino);
            }
        }
        int total = informacion.size();
       System.out.println(total);

/*********************************************************************/
        MatrizGrafo<String> grafito = new MatrizGrafo<String>(total);
/*********************************************************************/

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
        grafito.MostrarEnPantalla();
        System.out.println("");


        while (true) {
            System.out.println("Menu de opciones");
            System.out.println("1. Buscar distancia entre ciudades");
            System.out.println("2. Mosrar centro del grafo");
            System.out.println("3. Modificar Grafo");
            System.out.println("4. Salir");

            String opcion = teclado.nextLine();

            if (opcion.equals("1")) {
                System.out.println("Ingrese el nombre de la ciudad origen");
                String origen = teclado.nextLine();
                System.out.println("Ingrese el nombre de la ciudad destino");
                String destino = teclado.nextLine();
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

                }
                else if (modificacion.equals("2")){

                }
                else {
                    System.out.println("Opcion no valida");
                }



            }
            else if (opcion.equals("4")) {
                System.out.println("Thanks, bai");
                break;
            }

            else{
                System.out.println("Opcion no valida");
            }


        }
    }
}
