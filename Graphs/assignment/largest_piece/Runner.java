package assignment.largest_piece;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String[] takeInput() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        

        String[] edge = new String[n];
        for (int i = 0; i < n; i++) {
            edge[i] = br.readLine().replaceAll("\\s", "");
        }
        return edge;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        String[] edge = takeInput();
        int ans = Solution.dfs(edge,edge.length);
        System.out.println(ans);   
    }	
}