package fenwick_tree;

//Fenwick tree
public class FenwickTree {
    private int[] tree;
    private int n;

    public FenwickTree(int n) {
        this.n = n;
        tree = new int[n + 1];
    }

    public void update(int i, int delta) {
        while (i <= n) {
            tree[i] += delta;
            i += i & -i;
        }
    }

    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }

    public int query(int i, int j) {
        return query(j) - query(i - 1);
    }
}