package directed_graphs.get_path;

import java.util.*;

public class getPathDFS {

    public static Scanner s = new Scanner(System.in);

    public static void print(ArrayList<Integer> path){
        if(path == null){
            return;
        }

        for(int i=0;i<path.size();++i){
            System.out.print(path.get(i) + " ");
        }

    }

    public static ArrayList<Integer> getPath(int[][] graph, int v1, int v2, boolean[] visited) {
        if (v1 == v2) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(v1);
            return path;
        }

        visited[v1] = true;

        int n = graph.length;
        for (int i = 0; i < n; ++i) {
            if (graph[v1][i] == 1 && !visited[i]) {

                ArrayList<Integer> path = getPath(graph, i, v2, visited);
                if (path != null) {
                    path.add(v1);
                    return path;
                }

                visited[i] = true;

            }
        }

        return null;
    }

    public static void getPath(int[][] graph, int v1, int v2) {
        int n = graph.length;
        boolean[] visited = new boolean[n];

        ArrayList<Integer> path = getPath(graph, v1, v2, visited);
        if (path != null) {
            print(path);
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
