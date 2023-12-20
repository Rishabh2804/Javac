package undirected_graphs.all_connected_components;

import java.util.*;

public class Main {

    static final Scanner s = new Scanner(System.in);

    public static boolean hasPath(int[][] graph, int v1, int v2, boolean[] visited) {
        int n = graph.length;

        Queue<Integer> vertices = new LinkedList<>();
        vertices.add(v1);
        visited[v1] = true;

        while (!vertices.isEmpty()) {
            int vertex = vertices.poll();

            for (int i = 0; i < n; ++i) {
                if (graph[vertex][i] == 1 && !visited[i]) {
                    if (i == v2) {
                        return true;
                    }

                    vertices.add(i);
                    visited[i] = true;
                }
            }

        }

        return false;
    }

    public static boolean hasPath(int[][] graph, int v1, int v2) {
        if (v1 == v2) {
            return true;
        }

        int n = graph.length;
        boolean[] visited = new boolean[n];

        return hasPath(graph, v1, v2, visited);
    }

    public static void printComponents(int[][] graph) {
        int n = graph.length;
        if (n == 0) {
            return;
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {

                for (int j = i; j < n; ++j) {
                    if (!visited[j] && hasPath(graph, i, j)) {
                        System.out.print(j + " ");
                        visited[j] = true;
                    }
                }
                visited[i] = true;
                System.out.println();
            }
        }

    }

    public static int[][] takeInput(int v, int e) {
        int[][] graph = new int[v][v];

        for (int i = 0; i < e; ++i) {
            int a = s.nextInt();
            int b = s.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        return graph;
    }

    public static void main(String[] args) {
        int v = s.nextInt();
        int e = s.nextInt();

        int[][] graph = takeInput(v, e);
        printComponents(graph);

    }

}
