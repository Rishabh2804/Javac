package graphs.fill_the_matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//{ Driver Code Starts.
public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] input = read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            input = read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }

    }
}
// } Driver Code Ends