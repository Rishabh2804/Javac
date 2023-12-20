package binary_tree_traversals.level_order;

import queue_usingll.Queue;
import queue_usingll.QueueEmptyException;
import binary_tree_traversals.BinaryTreeNode;

public class Print {

    private Print() {

    }

    public static void printLevel(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode<Integer>> pendingnodes = new Queue<>();
        pendingnodes.enqueue(root);

        int n;

        while (!pendingnodes.isEmpty()) {
            try {
                n = pendingnodes.getSize();
                for (int i = 0; i < n; ++i) {
                    BinaryTreeNode<Integer> front = pendingnodes.dequeue();
                    System.out.print(front.data + " ");

                    if (front.left != null)
                        pendingnodes.enqueue(front.left);

                    if (front.right != null)
                        pendingnodes.enqueue(front.right);

                }

            } catch (QueueEmptyException e) {
                return;
            }
        }

    }

    public static void printLevel2(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode<Integer>> pendingnodes = new Queue<>();
        pendingnodes.enqueue(root);

        while (!pendingnodes.isEmpty()) {
            try {
                BinaryTreeNode<Integer> front = pendingnodes.dequeue();
                String str = "" + front.data;

                int left = -1;
                int right = -1;
                if (front.left != null) {
                    left = front.left.data;
                    pendingnodes.enqueue(front.left);
                }
                if (front.right != null) {
                    right = front.right.data;
                    pendingnodes.enqueue(front.right);
                }

                str += "L:" + left + ",R:" + right;
                System.out.println(str);
            } catch (QueueEmptyException e) {
                return;
            }
        }
    }
}
