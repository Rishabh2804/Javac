package coin_tower;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            String[] strNums = br.readLine().trim().split("\\s");
            int n = Integer.parseInt(strNums[0]);
            int x = Integer.parseInt(strNums[1]);
            int y = Integer.parseInt(strNums[2]);

            System.out.println(Solution.findWinner(n, x, y));
    }
}