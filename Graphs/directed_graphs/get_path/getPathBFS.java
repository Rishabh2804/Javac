package directed_graphs.get_path;

import java.util.*;

public class getPathBFS {

    public static Scanner s = new Scanner(System.in);

    public static HashMap<Integer, Integer> getPath(int[][] graph, int v1, int v2, boolean[] visited) {

        HashMap<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> vertices = new LinkedList<>();
        vertices.add(v1);

        visited[v1] = true;

        int n = graph.length;
        while (!vertices.isEmpty()) {
            int vertex = vertices.poll();

            for (int i = 0; i < n; ++i) {
                if (graph[vertex][i] == 1 && !visited[i]) {
                    parent.put(i, vertex);

                    if (i == v2) {
                        return parent;
                    }

                    vertices.add(i);
                    visited[i] = true;

                }
            }

        }

        return null;

    }

    public static void getPath(int[][] graph, int v1, int v2) {
        if (v1 == v2) {
            System.out.print(v2 + " " + v1);
            return;
        }

        int n = graph.length;
        boolean[] visited = new boolean[n];
        visited[v1] = true;

        HashMap<Integer,Integer> path = getPath(graph, v1, v2, visited);
        if(path == null){
            return;
        }

        while(true){
            System.out.print(v2 + " ");
            if(v2 == v1)
                break;

            v2 = path.get(v2);
        }

    }

    public static int[][] takeInput(int v, int e) {
        int[][] graph = new int[v][v];

        for (int i = 0; i < e; ++i) {
            int a = s.nextInt();
            int b = s.nextInt();

            graph[a][b] = 1;
            //graph[b][a] = 1;
        }

        return graph;
    }

    public static void main(String[] args) {
        int v = s.nextInt();
        int e = s.nextInt();

        int[][] graph = takeInput(v, e);

        getPath(graph, s.nextInt(), s.nextInt());
    }

}
