package assignment.connected_islands;

import java.util.*;

public class Solution {
    
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
    

	public static int numConnected(int[][] graph, int n) {
        
		if (n == 0) {
            return 0;
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                count ++;
                for (int j = i; j < n; ++j) {
                    if(!visited[j] && hasPath(graph, i, j)){
                        visited[j] = true;
                    }
                }
                visited[i] = true;
            }
        }
        
        return count;

	}


}