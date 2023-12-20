package heap_sort;
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
		st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Solution.inplaceHeapSort(input);
		for (int i : input) {
			System.out.print(i + " ");
		}
	}

}