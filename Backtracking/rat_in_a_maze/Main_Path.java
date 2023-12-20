package rat_in_a_maze;
import java.io.*;
import java.util.*;

public class Main_Path {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] maze = new int[20][20];
        for (int i = 0; i < n; i++)
        {
            StringTokenizer tk = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++)
            {
                maze[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        Solution.ratInAMaze(maze, n);
        
    }
}
