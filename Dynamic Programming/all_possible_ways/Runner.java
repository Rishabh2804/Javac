package all_possible_ways;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {

        String[] strNums;
		strNums = br.readLine().split("\\s");
        int x = Integer.parseInt(strNums[0]);
        int n = Integer.parseInt(strNums[1]);
        System.out.println(Solution.allWays(x, n));
    }
}