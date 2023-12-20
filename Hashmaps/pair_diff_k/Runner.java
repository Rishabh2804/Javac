package pair_diff_k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Runner {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		System.out.println(Solution.getPairsWithDifferenceK(arr, k));
	}

}