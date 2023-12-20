package special_arr;

import java.util.*;

public class Solution {

    static class Trie {
        public static class TrieNode {
            TrieNode zero;
            TrieNode one;

            int count = 0;
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        private int getCount(int i, int[] mask, TrieNode root) {
            if (root == null)
                return 0;
            if (root.zero == null && root.one == null)
                return root.count;

            int one = getCount(i + 1, mask, root.one);

            int zero = 0;
            if (mask[i] == 1)
                zero = getCount(i + 1, mask, root.zero);

            return one + zero;
        }

        public int getCount(int[] mask) {
            return getCount(0, mask, root);
        }

        private void insert(int i, int[] mask, TrieNode root) {
            if (i >= mask.length)
                return;

            if (mask[i] == 0) {
                if (root.zero == null)
                    root.zero = new TrieNode();

                root.zero.count++;
                insert(i + 1, mask, root.zero);
            } else {
                if (root.one == null)
                    root.one = new TrieNode();

                root.one.count++;
                insert(i + 1, mask, root.one);
            }
        }

        public void insert(int[] mask) {
            insert(0, mask, root);
        }
    }

    private int[] getMask(int[] a, int[] z) {
        int[] mask = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            if (a[i] >= z[i])
                mask[i] = 1;
        }

        return mask;
    }

    public long getSpecialArrayCount(int[][] a, int[] z) {

        List<int[]> masks = new ArrayList<>();
        Trie trie = new Trie();
        for (int[] row : a) {
            int[] mask = getMask(row, z);
            masks.add(mask);
            trie.insert(mask);
        }

        long count = 0;
        for (int[] mask : masks) {
            count += trie.getCount(mask);
        }

        return count;
    }
}
