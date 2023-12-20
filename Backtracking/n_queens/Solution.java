package n_queens;

import java.util.*;

public class Solution {

    protected static int[][] board;
    protected static Map<Integer, Boolean> cols = new HashMap<>();
    protected static List<String> list = new LinkedList<>();

    public static boolean safeDiag(int i, int j, int n) {
        if (i < 0 || j < 0 || j >= n) {
            return true;
        }

        int tempi = i;
        int tempj = j;

        while (true) {
            if (tempi < 0 || tempj < 0) {
                break;
            }

            if (board[tempi][tempj] == 1) {
                return false;
            }

            tempi -= 1;
            tempj -= 1;
        }

        tempi = i;
        tempj = j;

        while (true) {
            if (tempi < 0 || tempj >= n) {
                break;
            }

            if (board[tempi][tempj] == 1) {
                return false;
            }

            tempi -= 1;
            tempj += 1;
        }

        return true;
    }

    public static void print(int n) {

        for (int a = 0; a < n; ++a) {
            for (int b = 0; b < n; ++b) {
                System.out.print(board[a][b] + " ");
            }

        }
        System.out.println();

    }

    public static void solve(int i, int j, int n) {

        if (i >= n) {
            print(n);
            return;
        }
        list.add("R");

        if (j == n) {
            return;
        }

        if (Boolean.TRUE.equals(cols.get(j)) || !safeDiag(i, j, n)) {
            solve(i, j + 1, n);
            return;
        }

        board[i][j] = 1;
        cols.put(j, true);

        solve(i + 1, 0, n);

        board[i][j] = 0;
        cols.put(j, false);

        solve(i, j + 1, n);
    }

    public static void placeNQueens(int n) {

        board = new int[n][n];
        for (int i = 0; i < n; ++i) {
            cols.put(i, false);
        }

        solve(0, 0, n);
    }

    public int majorityElement(int[] nums) {

        int mid = nums.length / 2;
        int[] arr1 = Arrays.copyOfRange(nums, 0, mid - 1);
        int[] arr2 = Arrays.copyOfRange(nums, mid + 1, nums.length - 1);

        int ans1 = majorityElement(arr1);
        int ans2 = majorityElement(arr2);

        if (ans1 == ans2)
            return ans1;
        else
            return nums[mid];
    }

}


