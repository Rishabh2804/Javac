package histogram_problem;

import java.util.*;
import java.io.*;

public class Main {

    public static long getMaxArea(long hist[], long n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return hist[0];
        }

        long max = 0;
        Stack<Integer> bars = new Stack<>();

        int i = 0;
        while(i < n) {

            if (bars.isEmpty() || hist[bars.peek()] <= hist[i]) {
                bars.push(i++);
            } else {
                int top = bars.pop();

                long area = hist[top] * (bars.isEmpty() ? i : (i - bars.peek() - 1));
                max = Math.max(max, area);
            }
        }

        while (!bars.isEmpty()) {
            int top = bars.pop();
            long area = hist[top] * (bars.isEmpty() ? i : (i - bars.peek() - 1));
            max = Math.max(max, area);
        }

        return max;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[(int) n];
            for (int i = 0; i < n; i++)
                arr[i] = Long.parseLong(inputLine[i]);
                
            System.out.println(getMaxArea(arr, n));
        }
    }

}