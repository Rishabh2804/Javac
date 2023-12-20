package no_sibling;

import queue_usingll.Queue;
import queue_usingll.QueueEmptyException;

public class Solution {

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode<Integer>> pendingnodes = new Queue<>();
        pendingnodes.enqueue(root);

        System.out.print(root.data + " ");
        int n;
        while (!pendingnodes.isEmpty()) {
            try {
                n = pendingnodes.getSize();

                for (int i = 0; i < n; ++i) {
                    BinaryTreeNode<Integer> front = pendingnodes.dequeue();

                    if (front.left != null) {
                        pendingnodes.enqueue(front.left);
                        if (front.right == null)
                            System.out.print(front.left.data + " ");
                    }

                    if (front.right != null) {
                        pendingnodes.enqueue(front.right);
                        if (front.left == null)
                            System.out.print(front.right.data + " ");
                    }
                }

                System.out.println();

            } catch (QueueEmptyException e) {
                return;
            }
        }
    }

}
