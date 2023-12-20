package assignment.connected_islands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[][] takeInput() throws IOException {
		String[] strNums;
        strNums = br.readLine().split("\\s");
        int n = Integer.parseInt(strNums[0]);
        int e = Integer.parseInt(strNums[1]);

        int[][] edges = new int[n][n];
        int firstvertex, secondvertex;

        for (int i = 0; i < e; i++) {
            String[] strNums1;
            strNums1 = br.readLine().split("\\s");
            firstvertex = Integer.parseInt(strNums1[0]);
            secondvertex = Integer.parseInt(strNums1[1]);
            edges[firstvertex][secondvertex] = 1;
            edges[secondvertex][firstvertex] = 1;
        }
        return edges;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        int [][]edges = takeInput();
        
        int ans = Solution.numConnected(edges, edges.length);
        System.out.println(ans);
		
	}
}