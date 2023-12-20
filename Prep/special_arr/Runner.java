package special_arr;

import java.util.*;

public class Runner {

    static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        Solution sol = new Solution();

        int t = s.nextInt();

        while (t-- > 0) {
            int n = s.nextInt();
            int m = s.nextInt();

            int[][] a = new int[n][m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j)
                    a[i][j] = s.nextInt();
            }

            int[] z = new int[m];
            for (int i = 0; i < m; ++i)
                z[i] = s.nextInt();

            long ans = sol.getSpecialArrayCount(a, z);
            System.out.println(ans);
        }

    }
}