package count_node;

public class Solution {

    public static int count(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;

        return count(root.left) + count(root.right) + 1;
    }

}
