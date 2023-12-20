package edit_distance;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
	
		String str1 = br.readLine().trim();
		String str2 = br.readLine().trim();
        System.out.println(Solution.editDistance(str1, str2));
        
	}
}