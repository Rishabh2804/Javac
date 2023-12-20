package coin_change;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Runner {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {

		int numDenominations = Integer.parseInt(br.readLine().trim());

		int denominations[] = new int[numDenominations];
		String[] strNums;
		strNums = br.readLine().split("\\s");
		
        for (int i = 0; i < numDenominations; ++i) {
            denominations[i] = Integer.parseInt(strNums[i]);
        }
		int value = Integer.parseInt(br.readLine().trim());

		
		System.out.println(Solution.countWaysToMakeChange2(denominations, value));
		
	}

}