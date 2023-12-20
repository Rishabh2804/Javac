package coin_change;

public class Solution {

    private Solution() {

    }

    public static int countWaysToMakeChange(int[] denominations, int value, int i) {
        if (i == denominations.length)
            return 0;

        if (value == 0)
            return 1;

        if (denominations[i] > value)
            return countWaysToMakeChange(denominations, value, i + 1);

        int ans1 = countWaysToMakeChange(denominations, value, i + 1);
        int ans2 = countWaysToMakeChange(denominations, value - denominations[i], i);

        return ans1 + ans2;
    }

    public static int countWaysToMakeChange(int[] denominations, int value) {
        return countWaysToMakeChange(denominations, value, 0);
    }

    public static int countWaysToMakeChange2(int[] denominations, int value) {

        int[] ans = new int[value + 1];

        ans[0] = 1;
        for (int i = 1; i <= value; ++i) {
            ans[i] = 0;
        }

        for (int i = 0; i < denominations.length; ++i) {
            for (int j = denominations[i]; j <= value; ++j) {
                ans[j] += ans[j - denominations[i]];
            }
        }

        return ans[value];
    }
}
