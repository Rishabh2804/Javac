package segment_tree.array;

import segment_tree.evaluator.SegmentEvaluatorAdapter;

public class SegmentTreeArray extends SegmentEvaluatorAdapter {

    int[] tree;

    static final int NOT_FOUND = Integer.MAX_VALUE;

    public SegmentTreeArray(int[] arr) {
        super(NOT_FOUND);
        tree = new int[4 * arr.length];
        build(0, 0, arr.length - 1, arr);
    }

    @Override
    public int evaluate(int left, int right) {
        return Math.min(left, right);
    }

    private void build(int index, int low, int high, int[] arr) {
        if (low == high) {
            tree[index] = arr[low];
            return;
        }

        int mid = (low + high) / 2;
        build(2 * index + 1, low, mid, arr);
        build(2 * index + 2, mid + 1, high, arr);

        tree[index] = evaluate(tree[2 * index + 1], tree[2 * index + 2]);
    }

    public int range(int left, int right, int n) {
        return range(0, 0, n - 1, left, right);
    }

    private int range(int index, int low, int high, int left, int right) {
        if (right < low || left > high) // no overlap
            return Integer.MAX_VALUE;

        if (low == left && high == right) // complete overlap
            return tree[index];

        int mid = (low + high) / 2;
        int leftAns = range(2 * index + 1, low, mid, Math.max(low, left), Math.min(mid, right));
        int rightAns = range(2 * index + 2, mid + 1, high, Math.max(mid + 1, left), Math.min(high, right));

        return evaluate(leftAns, rightAns);
    }
}
