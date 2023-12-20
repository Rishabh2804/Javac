package diameter;

public class Solution {

    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;

        if (root.right == null && root.left == null) {
            return 1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static int diameter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int ans1 = height(root.left) + height(root.right);
        int ans2 = diameter(root.left);
        int ans3 = diameter(root.right);

        return Math.max(ans1, Math.max(ans2, ans3));

    }

    public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root) {
        if (root == null)
            return new Pair<>(0, 0);

        Pair<Integer, Integer> left = heightDiameter(root.left);
        Pair<Integer, Integer> right = heightDiameter(root.right);

        int ans1 = left.height + right.height;
        int ans2 = left.diameter;
        int ans3 = right.diameter;

        int height = 1 + Math.max(left.height, right.height);
        int diameter = Math.max(ans1, Math.max(ans2, ans3));

        return new Pair<>(height, diameter);
    }

}
