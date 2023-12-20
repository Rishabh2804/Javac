import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrieUse {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		Trie t = new Trie();
		String[] string = br.readLine().split("\\s");
		int choice = Integer.parseInt(string[0]);
		String word = "Null";
		if (string.length != 1) {
			word = string[1];
		}

		while (choice != -1) {
			switch (choice) {
				case 1: // insert
					t.add(word);
					break;
				case 2: // search
					System.out.println(t.search(word));
					break;
				default:
					return;
			}
			string = br.readLine().split("\\s");
			choice = Integer.parseInt(string[0]);
			if (string.length != 1) {
				word = string[1];
			}
		}
	}

}