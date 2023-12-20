package kth_largest_element;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    public static int kthLargest(int n, int[] arr, int k) {
        PriorityQueue<Integer> large = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; ++i) {
            large.add(arr[i]);
        }

        int x = -1;
        for (int i = 0; i < k; ++i) {
            x = large.remove();
            if (i == k - 1)
                break;

        }

        return x;
    }

}
