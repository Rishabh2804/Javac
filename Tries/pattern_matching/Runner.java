package pattern_matching;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Runner {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	
	public static void main(String[] args) throws IOException{
		Trie t = new Trie();
		int n = Integer.parseInt(br.readLine().trim());
        ArrayList<String> input = new ArrayList<String>();
        String[] words = br.readLine().split("\\s");
		for(int i = 0; i < n; i++) {
			
			input.add(words[i]);
		}
		String pattern = br.readLine();
		System.out.println(Solution.patternMatching(t,input, pattern));
	}
}