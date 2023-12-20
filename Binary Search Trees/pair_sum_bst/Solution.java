package pair_sum_bst;

public class Solution {
    
    private Solution() {
        
    }
    public static void sort(int[] n) {
        if (n.length == 0 || n.length == 1)
            return;

        if (n.length == 2) {
            if (n[0] > n[1]) {
                int temp = n[0];
                n[0] = n[1];
                n[1] = temp;
            }
            return;
        }

        int size1 = n.length / 2;
        int size2 = n.length - size1;

        int[] a = new int[size1];
        int[] b = new int[size2];

        for (int i = 0; i < n.length; ++i) {
            if (i < size1)
                a[i] = n[i];
            else
                b[i - size1] = n[i];
        }

        sort(a);
        sort(b);

        int i = 0, j = 0, k = 0;
        while (i < size1 && j < size2) {
            if (a[i] <= b[j]) {
                n[k] = a[i];
                i++;
            } else {
                n[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            n[k] = a[i];
            i++;
            k++;
        }
        while (j < size2) {
            n[k] = b[j];
            j++;
            k++;
        }
    }

    public static int[] treeToArray(BinaryTreeNode<Integer> root) {
        if (root == null)
            return new int[0];

        int[] left = treeToArray(root.left);
        int[] right = treeToArray(root.right);

        if (left == null && right == null) {
            int[] out = new int[1];
            out[0] = root.data;
            return out;
        }

        int lsize = 0;
        int rsize = 0;
        int i = 0;
        if (left != null)
            lsize = left.length;
        if (right != null)
            rsize = right.length;

        int[] out = new int[1 + lsize + rsize];
        for (; i < lsize; ++i) {
            out[i] = left[i];
        }
        out[i] = root.data;
        i++;
        for (; i < out.length; ++i) {
            out[i] = right[i - lsize - 1];
        }
        return out;
    }

    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        int[] arr = treeToArray(root);
        sort(arr);

        int high = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= s)
                break;
            for (int j = high; j > i; --j) {
                if (arr[j] == Integer.MIN_VALUE)
                    continue;

                if (arr[j] == s - arr[i]) {
                    System.out.println(arr[i] + " " + arr[j]);
                    arr[j] = Integer.MIN_VALUE;
                    high--;
                    break;
                } else if (arr[j] > s - arr[i]) {
                    high--;
                    continue;
                } else
                    break;
            }
        }
    }

    public static BinaryTreeNode<Integer> search(BinaryTreeNode<Integer> root, int n) {
        if (root == null)
            return null;

        if (root.data == n)
            return root;

        if (root.data > n) {
            BinaryTreeNode<Integer> left = search(root.left, n);
            if (left != null)
                return left;
        }

        if (root.data < n) {
            BinaryTreeNode<Integer> right = search(root.right, n);
            if (right != null)
                return right;
        }

        return null;
    }

    public static void printNodesSumToS(BinaryTreeNode<Integer> current, int sum, BinaryTreeNode<Integer> root) {
        if (current == null)
            return;

        if (current.data < sum) {
            int temp = current.data;
            current.data = Integer.MIN_VALUE;
            BinaryTreeNode<Integer> node = search(root, sum - temp);
            current.data = temp;
            if (node != null) {
                System.out.println(Math.min(node.data, current.data) + " " + Math.max(node.data, current.data));
                node.data = Integer.MIN_VALUE;
            }
        }

        printNodesSumToS(current.left, sum, root);
        printNodesSumToS(current.right, sum, root);

    }

}
