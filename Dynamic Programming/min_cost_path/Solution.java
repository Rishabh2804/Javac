package min_cost_path;

public class Solution {

    public static int minCostPath(int[][] input) {
        int[][] cost = new int[input.length][input[0].length];

        int m = input.length;
        int n = input[0].length;

        cost[m -1 ][n-1] = input[m-1][n-1];

        for (int i = m - 2; i >= 0; --i) {
            cost[i][n-1] = cost[i + 1][n-1] + input[i][n-1];
        }

        for (int i = n - 2; i >= 0; --i) {
            cost[m-1][i] = cost[m-1][i + 1] + input[m-1][i];
        }

        for(int i=m-2;i>=0;--i){
            for(int j=n-2;j>=0;--j){
                int a=cost[i][j+1];
                int b=cost[i+1][j];
                int c=cost[i+1][j+1];

                cost[i][j]=input[i][j] + Math.min(a, Math.min(b, c));
            }
        }

        return cost[0][0];

    }
}