package largest_bst;

public class Solution {

    private  Solution() {
        
    }
    public static boolean isBST(BinaryTreeNode<Integer> root, int min, int max) {
        if (root == null)
            return true;

        if (root.data < min || root.data > max)
            return false;

        boolean left = isBST(root.left, min, root.data - 1);
        boolean right = isBST(root.right, root.data, max);

        return left && right;
    }

    public static int largestBSTSubtree2(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int left = largestBSTSubtree2(root.left);
        int right = largestBSTSubtree2(root.right);

        int height = Math.max(left, right);

        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return 1 + height;
        } else {
            return height;
        }

    }

    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {

        return largestBSTSubtree2(root);
    }

}
