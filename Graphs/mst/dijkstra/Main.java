package mst.dijkstra;

import java.util.Scanner;

public class Main {

    private static int[] dijkstra(int[][] adjacencyMatrix, int source) {
        int v = adjacencyMatrix.length;
        boolean[] visited = new boolean[v];
        int[] distance = new int[v];
        distance[0] = 0;
        for (int i = 1; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < v - 1; i++) {
            // Find Vertex with Min distance
            int minVertex = findMinVertex(distance, visited, source);
            visited[minVertex] = true;
            // Explore neighbors
            for (int k = 0; k < v; k++) {
                int j = (source + k) % v;
                if (adjacencyMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE) {
                    int newDist = distance[minVertex] + adjacencyMatrix[minVertex][j];
                    if (newDist < distance[j]) {
                        distance[j] = newDist;
                    }
                }
            }
        }

        // Print
        int[] res = new int[v];
        for (int i = 0; i < v; i++) {
            res[i] = distance[i];
            System.out.println(i + " " + distance[i]);
        }

        return res;
    }

    private static int findMinVertex(int[] distance, boolean[] visited, int source) {

        int minVertex = -1;
        for (int k = 0; k < distance.length; k++) {
            int i = (source + k) % distance.length;
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int e = s.nextInt();
        int[][] adjacencyMatrix = new int[v][v];
        for (int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();
            adjacencyMatrix[v1][v2] = weight;
            adjacencyMatrix[v2][v1] = weight;
        }
        int source = s.nextInt();
        dijkstra(adjacencyMatrix, source);
        s.close();
    }

}