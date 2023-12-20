package lca;

public class Solution {
    private Solution() {
    }

    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        if (root == null)
            return false;

        if (root.data == k)
            return true;
        else if (root.data < k)
            return searchInBST(root.right, k);
        else
            return searchInBST(root.left, k);
    }

    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        if (root == null)
            return -1;

        if (root.data == a || root.data == b)
            return root.data;

        boolean aInLeft = searchInBST(root.left, a);
        boolean aInRight = searchInBST(root.right, a);
        boolean bInLeft = searchInBST(root.left, b);
        boolean bInRight = searchInBST(root.right, b);

        if (aInLeft && bInLeft) {
            return getLCA(root.left, a, b);
        }

        if (aInRight && bInRight) {
            return getLCA(root.right, a, b);
        }

        if ((aInLeft && bInRight) || (aInRight && bInLeft)) {
            return root.data;
        } else if (aInLeft || aInRight) {
            return a;
        } else if (bInLeft || bInRight) {
            return b;
        } else
            return -1;

    }
}
