package rat_in_a_maze;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int maze[][] = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				maze[i][j] = s.nextInt();
			}
		}
		Solution.ratInAMaze(maze,maze.length);	
        s.close();
	}

}
