package node_at_dist_k;

public class Solution {

    private Solution() {
        // private constructor
    }

    public static void printDepth(BinaryTreeNode<Integer> root, int k) {
        if (root == null || k < 0) {
            return;
        }

        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }

        printDepth(root.left, k - 1);
        printDepth(root.right, k - 1);
    }

    public static int nodesAtDistanceK2(BinaryTreeNode<Integer> root, int node, int k) {
        if (root == null) // target unreachable
            return -1;

        if (root.data == node) {
            printDepth(root, k);
            return 0;
        }

        int left = nodesAtDistanceK2(root.left, node, k);
        if (left != -1) {
            if (left + 1 == k) {
                System.out.print(root.data + " ");
            } else
                printDepth(root.right, k - left - 2);

            return left + 1;
        }

        int right = nodesAtDistanceK2(root.right, node, k);
        if (right != -1) {
            if (right + 1 == k) {
                System.out.print(root.data + " ");
            } else
                printDepth(root.left, k - right - 2);

            return right + 1;
        }

        return -1; // node not found in tree
    }

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        nodesAtDistanceK2(root, node, k);
    }
}
