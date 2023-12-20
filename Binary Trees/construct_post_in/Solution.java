package construct_post_in;

public class Solution {

    private Solution() {

    }
    public static BinaryTreeNode<Integer> buildTree(int[] postorder, int[] inorder) {
        if (postorder.length == 0)
            return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(postorder[postorder.length - 1]);

        int n = 0;
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == root.data) {
                n = i;
                break;
            }
        }

        int[] leftin = new int[n];
        int[] rightin = new int[inorder.length - n - 1];

        for (int i = 0; i < inorder.length; ++i) {
            if (i == n)
                continue;

            if (i < n)
                leftin[i] = inorder[i];
            else
                rightin[i - n - 1] = inorder[i];

        }

        int[] leftpost = new int[n];
        int[] rightpost = new int[postorder.length - 1 - n];

        for (int i = 0; i < postorder.length - 1; ++i) {
            if (i < n)
                leftpost[i] = postorder[i];
            else
                rightpost[i - n] = postorder[i];
        }

        root.left = buildTree(leftpost, leftin);
        root.right = buildTree(rightpost, rightin);
        return root;
    }
}
