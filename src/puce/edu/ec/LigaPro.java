package puce.edu.ec;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LigaPro {
    public static void main(String[] args) {
        String[] equipos = {"LDU", "BSC", "DQuito"};
        int totalEquipos = equipos.length;

        // Matriz de adyacencia (1 si hay conexión/partido, 0 si no)
        int[][] matrizAdyacencia = new int[totalEquipos][totalEquipos];

        /* Definimos las conexiones (quién jugó contra quién) */
        // LDU (0) <-> BSC (1)
        matrizAdyacencia[0][1] = 1;
        matrizAdyacencia[1][0] = 1;

        // LDU (0) <-> DQuito (2)
        matrizAdyacencia[0][2] = 1;
        matrizAdyacencia[2][0] = 1;

        // BSC (1) <-> DQuito (2) -> Agregamos esta conexión para formar un grafo completo
        matrizAdyacencia[1][2] = 1;
        matrizAdyacencia[2][1] = 1;

        System.out.println("=========================================");
        System.out.println("       RECORRIDOS EN EL GRAFO (LIGA)     ");
        System.out.println("=========================================");

        // Ejecutar DFS desde LDU (Nodo 0)
        System.out.print("Recorrido DFS (Profundidad) desde LDU: ");
        dfs(matrizAdyacencia, equipos, 0);
        System.out.println();

        // Ejecutar BFS desde LDU (Nodo 0)
        System.out.print("Recorrido BFS (Anchura) desde LDU:     ");
        bfs(matrizAdyacencia, equipos, 0);
        System.out.println();
        System.out.println("=========================================");
    }

    // Algoritmo DFS (Depth-First Search) usando una Pila (Stack)
    public static void dfs(int[][] grafo, String[] equipos, int inicio) {
        int n = grafo.length;
        boolean[] visitados = new boolean[n];
        Stack<Integer> pila = new Stack<>();

        pila.push(inicio);

        while (!pila.isEmpty()) {
            int actual = pila.pop();

            if (!visitados[actual]) {
                visitados[actual] = true;
                System.out.print(equipos[actual] + " ");

                // Recorremos en orden inverso para que la pila procese lógicamente de izquierda a derecha
                for (int i = n - 1; i >= 0; i--) {
                    if (grafo[actual][i] == 1 && !visitados[i]) {
                        pila.push(i);
                    }
                }
            }
        }
    }

    // Algoritmo BFS (Breadth-First Search) usando una Cola (Queue)
    public static void bfs(int[][] grafo, String[] equipos, int inicio) {
        int n = grafo.length;
        boolean[] visitados = new boolean[n];
        Queue<Integer> cola = new LinkedList<>();

        visitados[inicio] = true;
        cola.add(inicio);

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            System.out.print(equipos[actual] + " ");

            // Buscamos todos los vecinos no visitados
            for (int i = 0; i < n; i++) {
                if (grafo[actual][i] == 1 && !visitados[i]) {
                    visitados[i] = true;
                    cola.add(i);
                }
            }
        }
    }
}