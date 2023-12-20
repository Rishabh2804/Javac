package loot_houses;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int[] takeInput() throws IOException {
		int n = Integer.parseInt(br.readLine().trim());

		if (n == 0) {
			return new int[0];
		}

		String[] strNums = br.readLine().trim().split("\\s");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(strNums[i]);
        }

        return arr;
	}

    public static void main(String[] args) throws NumberFormatException, IOException {
            int[] arr = takeInput();
            System.out.println(Solution.maxMoneyLooted(arr));
    }
}