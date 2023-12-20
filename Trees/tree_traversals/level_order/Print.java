package tree_traversals.level_order;

import queue_usingll.Queue;
import queue_usingll.QueueEmptyException;
import tree_traversals.TreeNode;

public class Print {
    public static void print_level(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> pendingnodes = new Queue<>();
        pendingnodes.enqueue(root);

        while (!pendingnodes.isEmpty()) {
            try {
                TreeNode<Integer> frontnode = pendingnodes.dequeue();
                System.out.print(frontnode.data + ": ");
                for (int i = 0; i < frontnode.children.size(); ++i) {
                    System.out.print(frontnode.children.get(i).data);
                    pendingnodes.enqueue(frontnode.children.get(i));
                    if (i == frontnode.children.size() - 1) {
                        System.out.println();
                        continue;
                    }
                    System.out.print(", ");
                }
                System.out.println();
            } catch (QueueEmptyException e) {
                return;
            }
        }
    }

    public static void print_level2(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> pendingnodes = new Queue<>();
        pendingnodes.enqueue(root);

        int l1 = 1, l2 = 0, level = 0;

        while (!pendingnodes.isEmpty()) {
            try {
                TreeNode<Integer> frontnode = pendingnodes.dequeue();
                System.out.print(frontnode.data + " ");
                for (int i = 0; i < frontnode.children.size(); ++i) {
                    pendingnodes.enqueue(frontnode.children.get(i));
                }
                l2 += frontnode.children.size();
                l1--;
                if (l1 == 0) {
                    System.out.println();
                    level++;
                    l1 = l2;
                    l2 = 0;
                }

            } catch (QueueEmptyException e) {
                return;
            }

        }

        System.out.println("\nHeight of given tree: " + level);
    }

}
