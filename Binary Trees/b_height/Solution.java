package b_height;

import queue_usingll.Queue;
import queue_usingll.QueueEmptyException;

public class Solution {

    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;

        if (root.right == null && root.left == null) {
            return 1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static int height2(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;

        Queue<BinaryTreeNode<Integer>> pendingnodes = new Queue<>();
        pendingnodes.enqueue(root);

        int height = 1;
        while (!pendingnodes.isEmpty()) {
            try {
                BinaryTreeNode<Integer> front = pendingnodes.dequeue();

                if (front.right == null && front.left == null)
                    break;

                height++;

                if (front.left != null) {
                    if (!(front.left.left == null || front.left.right == null))
                        pendingnodes.enqueue(front.left);
                }

                if (front.right != null)
                    pendingnodes.enqueue(front.right);

            } catch (QueueEmptyException e) {
                return 0;
            }
        }

        return height;
    }
}
