package remove_duplicates;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public static ArrayList<Integer> removeDuplicates(int[] a) {
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> occur = new HashMap<>();

        for (int i = 0; i < a.length; ++i) {
            if (occur.containsKey(a[i])) {
                continue;
            }

            output.add(a[i]);
            occur.put(a[i], true);
        }

        return output;
    }
}
