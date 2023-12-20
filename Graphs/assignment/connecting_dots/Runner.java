package assignment.connecting_dots;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String[] takeInput() throws IOException {
		String[] strNums;
        strNums = br.readLine().split("\\s");

        int N = Integer.parseInt(strNums[0]);
        //int M = Integer.parseInt(strNums[1]);

		String[] Graph = new String[N];
		
        for (int i = 0; i < N; ++i) {
            Graph[i] = br.readLine();
        }

        return Graph;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String[] Graph = takeInput();
        if (new Solution().solve(Graph,Graph.length,Graph[0].length())==1){
            System.out.print("true");
        }
        else{
            System.out.print("false");
        }


    }
}