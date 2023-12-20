package undirected_graphs.is_connected;

import java.util.*;

public class Main {

    public static Scanner s = new Scanner(System.in);

    public static boolean isConnected(int[][] graph) {
        int n = graph.length;

        if (n == 0) {
            return false;
        }

        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = 0; j < n; ++j) {
                if (graph[i][j] == 1) {
                    count++;
                }
            }

            if (count == 0) {
                return false;
            }
        }

        return true;
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

        System.out.print(isConnected(graph));

    }

}
