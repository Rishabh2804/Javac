package shortest_uncommon_subsequence;

public class Solution {

    static final int Max = 1000;
    
    public int solve(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] ans = new int[m + 1][n + 1];

        for (int i = 0; i <= n; ++i) {
            ans[0][i] = Max;
        }

        for (int i = 0; i <= m; ++i) {
            ans[i][0] = 1;
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                char c = s.charAt(i - 1);
                int k;
                for (k = j - 1; k >= 0; --k) {
                    if (t.charAt(k) == c) { // find first occurance of 'c' in string t
                        break;
                    }
                }

                if (k == -1) // 'c' not found in string t
                    ans[i][j] = 1;
                else {
                    ans[i][j] = Math.min(ans[i - 1][j], ans[i - 1][k] + 1);
                }

            }
        }

        if(ans[m][n] >= Max){
            ans[m][n] = -1;
        }

        return ans[m][n];
    }

}
