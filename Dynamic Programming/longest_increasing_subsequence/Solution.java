package longest_increasing_subsequence;

public class Solution {

    private Solution() {

    }

    public static int lis(int[] arr) {
        if (arr.length == 0)
            return 0;

        int n = arr.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i)
            ans[i] = 1;

        int max = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[i] > arr[j] && ans[i] < ans[j] + 1)
                    ans[i] = ans[j] + 1;
            }
        }

        for (int i = 0; i < n; ++i)
            max = Math.max(max, ans[i]);

        return max;
    }
}
