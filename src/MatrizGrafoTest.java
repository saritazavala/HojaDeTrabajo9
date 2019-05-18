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
        String comp = probar.addEdge("uno", "dos", 7);
        System.out.println(probar);
        assertEquals("Realizado con exito", comp);
    }

    @Test
    public void Test2() {
        //Anadir vertice
        MatrizGrafo probar = new MatrizGrafo(2);
        probar.add("Rosa");
        boolean resul = probar.lista.contains("Rosa");
        assertEquals(true, resul);
    }


}

