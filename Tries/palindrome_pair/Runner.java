package palindrome_pair;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static ArrayList<String> takeInput() throws IOException {
        ArrayList<String> words = new ArrayList<>();

        int n = Integer.parseInt(br.readLine().trim());

        if (n == 0) {
            return words;
        }
        
        String[] listOfWords; 
        listOfWords = br.readLine().split("\\s");
        

        for (int i = 0; i < n; ++i) {
            words.add(listOfWords[i]);
        }

        return words;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Trie root = new Trie();

        ArrayList<String> words = takeInput();
        System.out.println(Solution.isPalindromePair(root,words));
    } 

}