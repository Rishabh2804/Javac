package shortest_uncommon_subsequence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Runner {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String[] args) throws IOException{
		
		String S,V;
		

		S = br.readLine();
		V = br.readLine();
		System.out.println(new Solution().solve(S,V));
	}

}