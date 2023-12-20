package unique_chars;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String takeInput() throws IOException {
        String str = br.readLine(); 
        return str;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String str = takeInput();
        System.out.print(Solution.uniqueChar(str));


    }
}