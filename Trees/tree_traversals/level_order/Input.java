package tree_traversals.level_order;

import java.util.Scanner;

import queue_usingll.Queue;
import queue_usingll.QueueEmptyException;
import tree_traversals.TreeNode;

public class Input {

    public static TreeNode<Integer> takeInput_level(Scanner s, int n) throws QueueEmptyException {
        System.out.print("Enter data for node no." + n + ": ");
        int data = s.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(data);

        Queue<TreeNode<Integer>> pendingnode = new Queue<>();
        pendingnode.enqueue(root);
        while (!pendingnode.isEmpty()) {
            try {
                TreeNode<Integer> frontnode = pendingnode.dequeue();
                System.out.print("Enter no of children of " + frontnode.data + " : ");
                int childcount = s.nextInt();
                System.out.println();

                for (int i = 0; i < childcount; ++i) {
                    System.out.print("Enter data for child no." + (i + 1) + " of " + frontnode.data + " : ");
                    int childdata = s.nextInt();
                    TreeNode<Integer> child = new TreeNode<Integer>(childdata);
                    frontnode.children.add(child);
                    pendingnode.enqueue(child);
                }

            } catch (QueueEmptyException e) {
                return null; // will never happen
            }

            System.out.println();
        }

        return root;
    }

}
