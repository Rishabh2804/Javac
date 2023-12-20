package fenwick_tree;

import java.math.BigInteger;
import java.util.*;

public class FenwickTree2 {

    int[] tree;

    public FenwickTree2(int[] arr, int size) {
        tree = new int[size + 1];
        for (int i = 0; i < arr.length; i++) {
            update(i + 1, arr[i]);
        }
    }

    private void update(int i, int x) {
        while (i < tree.length) {
            tree[i] += x;

        }
    }

    public static long findAllPathLength(long[] arrayx, long[] arrayy, long n) {

        BigInteger tot = BigInteger.ZERO;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                tot = tot.add(BigInteger.valueOf(Math.abs(arrayx[i] - arrayx[j]) + Math.abs(arrayy[i] - arrayy[j])));
            }
        }
        return tot.longValue();
    }

}

class Solution {
    private int countBits(int n){
        int count = 0;
        while(n != 0){
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    
    public int[] sortByBits(int[] arr) {
        int[] bits = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            bits[i] = countBits(arr[i]) * 100000 + arr[i];
        
        Arrays.sort(bits);
        for(int i = 0; i < arr.length; i++)
            bits[i] = bits[i] % 100000;
        
        return bits;
    }
}