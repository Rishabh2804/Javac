package balanced;

public class Solution {

    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;

        if (root.right == null && root.left == null) {
            return 1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static boolean checkBalanced(BinaryTreeNode<Integer> root) {
        if (root == null)
            return true;

        if (height(root.left) - height(root.right) > 1 || height(root.left) - height(root.right) < -1)
            return false;

        return checkBalanced(root.left) && checkBalanced(root.right);
    }

}
