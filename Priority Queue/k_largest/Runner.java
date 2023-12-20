package k_largest;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int j = 0; j < n; j++) {
			input[j] = s.nextInt();
		}
		int k = s.nextInt();
		ArrayList<Integer> output = Solution.kLargest(input, k);
		for(int i : output) {
			System.out.println(i);
		}
		
	}
}