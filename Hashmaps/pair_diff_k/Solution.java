package pair_diff_k;

import java.util.HashMap;

public class Solution {

    public static int getPairsWithDifferenceK(int arr[], int k) {
        if (arr.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Boolean> seen = new HashMap<>();
        int n = 0;

        for (int i = 0; i < arr.length; ++i) {
            seen.put(arr[i], false);

            if (freq.containsKey(arr[i]))
                freq.put(arr[i], freq.get(arr[i]) + 1);
            else
                freq.put(arr[i], 1);
        }

        if (k == 0) { // special case

            for (int i = 0; i < arr.length; ++i) {
                if (Boolean.TRUE.equals(seen.get(arr[i]))) {
                    continue;
                }

                int f = freq.get(arr[i]);
                n += f * (f - 1) >> 1;

                seen.put(arr[i], true);
            }

            return n;
        }

        for (int i = 0; i < arr.length; ++i) {
            int temp = arr[i] - k;
            if (freq.containsKey(temp)) {
                n += freq.get(temp);
            }

        }

        return n;
    }
}
