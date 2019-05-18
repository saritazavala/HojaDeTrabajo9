import java.io.*;
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
        MatrizGrafo<String> nuevoGrafo = new MatrizGrafo<String>(1);
        File file = new File("guategrafo.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            String[] parts = line.split(" ");
            String ciudadOrigen = parts[0];
            if(!nuevoGrafo.lista.contains(ciudadOrigen)){
                nuevoGrafo.add(ciudadOrigen);
            }
            String ciudadDestino = parts[1];
            if(!nuevoGrafo.lista.contains(ciudadDestino)){
                nuevoGrafo.add(ciudadDestino);
            }
            else{
                System.out.println("Archivo no leido");
            }
            int x = Integer.parseInt(parts[2]);
            nuevoGrafo.addEdge(ciudadOrigen,ciudadDestino,x);


        }

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
            }

            else if (opcion.equals("2")) {
                System.out.println("El centro del grafo es: ");
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
