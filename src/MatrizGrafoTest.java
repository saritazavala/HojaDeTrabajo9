import org.junit.Test;

import static org.junit.Assert.*;
/*
Sara Zavala 18893
Hoja de Trabajo 9
Estructura de Datos
Grafos y Floyd
* */

public class MatrizGrafoTest {

        @Test
        public void Test0() {
            //Probar Floyd
            MatrizGrafo probar = new MatrizGrafo(3);
            probar.add("uno");
            probar.add("dos");
            probar.add("tres");
            probar.addEdge("uno", "dos", 6);
            probar.addEdge("dos", "tres", 10);
            probar.addEdge("uno", "tres", 8);
            System.out.println(probar);
            probar.floyd();
            System.out.println(probar);
        }

    @Test
    public void Test1() {
        //Para añadir Arcos
        MatrizGrafo probar = new MatrizGrafo(2);
        probar.add("uno");
        probar.add("dos");
        String hola = probar.addEdge("uno", "dos", 7);
        System.out.println(probar);
        assertEquals("Realizado con exito", hola);
    }

    @Test
    public void Test2() {
        //Anadir vertice
        MatrizGrafo probar = new MatrizGrafo(2);
        probar.add("uno");
        boolean rfinal = probar.lista.contains("uno");
        assertEquals(true, rfinal);
    }

    @Test
    public void Test3(){
            //Mostrar en pantalla
        MatrizGrafo probar = new MatrizGrafo(3);
        probar.add("uno");
        probar.add("dos");
        probar.add("tres");
        probar.addEdge("uno", "dos", 6);
        probar.addEdge("dos", "tres", 10);
        probar.addEdge("uno", "tres", 8);
        probar.MostrarEnPantalla();
    }

    @Test
    public void Test4(){
        //Eliminar Edge
        MatrizGrafo probar = new MatrizGrafo(3);
        probar.add("uno");
        probar.add("dos");
        probar.add("tres");
        probar.addEdge("uno", "dos", 6);
        probar.addEdge("dos", "tres", 10);
        probar.addEdge("uno", "tres", 8);
        probar.removeEdge("uno","tres");
        probar.MostrarEnPantalla();
    }

    @Test
    public void Test5() {
        //Dar centro del grafo
        MatrizGrafo probar = new MatrizGrafo(3);
        probar.add("uno");
        probar.add("dos");
        probar.add("tres");
        probar.addEdge("uno", "dos", 6);
        probar.addEdge("dos", "tres", 10);
        probar.addEdge("uno", "tres", 8);
        probar.getCentroGrafo();

    }

}

