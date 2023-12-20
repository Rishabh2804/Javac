package segment_tree.array;

import java.util.*;

public class SegmentTreeArrayUse {

    static final Scanner s = new Scanner(System.in);

    public static int[] nextArr(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = s.nextInt();

        return arr;
    }

    public static void main(String[] args) {

        int n = s.nextInt();
        int[] arr = nextArr(n);

        SegmentTreeArray tree = new SegmentTreeArray(arr);

        int q = s.nextInt();
        for (int i = 0; i < q; ++i) {
            int l = s.nextInt();
            int r = s.nextInt();

            System.out.println(tree.range(l, r, arr.length));
        }

    }
}
