package knapsack;

public class Solution {

    private Solution() {
        
    }

    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
        if (n == 0 || maxWeight == 0) { // reached end or empty array
            return 0;
        }

        if (weights[n - 1] > maxWeight) {
            return knapsack(weights, values, n - 1, maxWeight);
        }

        int include = values[n - 1] + knapsack(weights, values, n - 1, maxWeight - weights[n - 1]);
        int exclude = knapsack(weights, values, n - 1, maxWeight);

        return Math.max(include, exclude);

    }

    public static int knapsack2(int[] weights, int[] values, int n, int maxWeight) {
        if (n == 0 || maxWeight == 0) {
            return 0;
        }

        int[][] ans = new int[n + 1][maxWeight + 1];
        for (int i = 0; i <= n; ++i) {
            ans[i][0] = 0;
        }

        for (int i = 0; i <= maxWeight; ++i) {
            ans[0][i] = 0;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= maxWeight; ++j) {
                if (weights[i - 1] <= j) {
                    ans[i][j] = Math.max(ans[i - 1][j], values[i - 1] + ans[i - 1][j - weights[i - 1]]);
                } else {
                    ans[i][j] = ans[i - 1][j];
                }
            }
        }

        return ans[n][maxWeight];
    }

}