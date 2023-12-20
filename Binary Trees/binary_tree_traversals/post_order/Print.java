package binary_tree_traversals.post_order;

import java.util.EmptyStackException;
import java.util.Stack;

import binary_tree_traversals.BinaryTreeNode;

public class Print {

    public static void postOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            // System.out.print(-1 + " ");
            return;
        }
        postOrder(root.left);
        postOrder(root.right);

        System.out.print(root.data + " ");
    }

    public static void postOrder2(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode<Integer>> nodes = new Stack<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            try {
                BinaryTreeNode<Integer> curr = nodes.pop();
                if (curr.left == null && curr.right == null) {
                    System.out.print(curr.data + " ");
                    continue;
                }

                nodes.push(new BinaryTreeNode<Integer>(curr.data));

                if (curr.right != null) {
                    nodes.push(curr.right);
                }

                if (curr.left != null) {
                    nodes.push(curr.left);
                }

            } catch (EmptyStackException e) {
                return;
            }

        }
    }
}
