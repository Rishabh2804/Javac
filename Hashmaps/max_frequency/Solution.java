package max_frequency;

import java.util.HashMap;

public class Solution {

    public static int maxFrequencyNumber(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < arr.length; ++i) {
            if (freq.containsKey(arr[i]))
                freq.put(arr[i], freq.get(arr[i]) + 1);
            else
                freq.put(arr[i], 1);
        }

        int max = 0, value = 0;

        for (int i = 0; i < arr.length; ++i) {
            int f = freq.get(arr[i]);
            if (max < f) {
                max = f;
                value = arr[i];
            }

        }

        return value;
    }
}
