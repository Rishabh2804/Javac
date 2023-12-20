package construct_pre_in;

public class Solution {

    public static BinaryTreeNode<Integer> buildTree(int[] pre, int[] in) {
        if (pre.length == 0)
            return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(pre[0]);

        int n = 0;
        for (int i = 0; i < in.length; ++i) {
            if (in[i] == root.data) {
                n = i;
                break;
            }
        }

        int[] leftpre = new int[n];
        int[] rightpre = new int[pre.length - n - 1];

        for (int i = 1; i < pre.length; ++i) {
            if (i <= n)
                leftpre[i - 1] = pre[i];
            else
                rightpre[i - n - 1] = pre[i];
        }

        int[] leftin = new int[n];
        int[] rightin = new int[in.length - n - 1];

        for (int i = 0; i < in.length; ++i) {
            if (i == n)
                continue;

            if (i < n)
                leftin[i] = in[i];
            else
                rightin[i - n - 1] = in[i];

        }

        root.left = buildTree(leftpre, leftin);
        root.right = buildTree(rightpre, rightin);

        return root;
    }
}
