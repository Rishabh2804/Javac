package assignment.three_cycle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int findParent(int[] parent, int v) {
        if (parent[v] == v)
            return v;

        return findParent(parent, parent[v]);
    }

    public static int solve(boolean[][] graph, int n) {
        int count = 0;
        int[] parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            visited[i] = true;

            for (int j = 0; j < n; ++j) {
                if (graph[i][j] && !visited[j]) {

                    for(int k = 0;k < n;++k){
                        if(k == i)
                            continue;

                        if(graph[j][k] && graph[k][i] && !visited[k]){
                                count ++;
                        }
                    }
                }
            }
        }

        return count/2;
    }

    public static boolean[][] takeInput() throws IOException {
        String[] strNums;
        strNums = br.readLine().split("\\s");
        int n = Integer.parseInt(strNums[0]);
        int m = Integer.parseInt(strNums[1]);

        boolean[][] graphs = new boolean[n][n];
        int firstvertex, secondvertex;

        for (int i = 0; i < m; i++) {
            String[] strNums1;
            strNums1 = br.readLine().split("\\s");
            firstvertex = Integer.parseInt(strNums1[0]);
            secondvertex = Integer.parseInt(strNums1[1]);
            graphs[firstvertex][secondvertex] = true;
            graphs[secondvertex][firstvertex] = true;
        }
        return graphs;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        boolean[][] graphs = takeInput();

        int ans = solve(graphs, graphs.length);
        System.out.println(ans);

    }
}