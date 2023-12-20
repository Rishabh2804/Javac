package binary_tree_traversals.pre_order;

import java.util.EmptyStackException;
import java.util.Stack;

import binary_tree_traversals.BinaryTreeNode;

public class Print {

    public static void print(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        String str = root.data + " ";
        if (root.left != null) {
            str += "L:" + root.left.data + ',';
        }

        if (root.right != null) {
            str += "R:" + root.right.data;
        }

        System.out.println(str);
        print(root.left);
        print(root.right);
    }

    public static void print2(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        print2(root.left);
        print2(root.right);

    }

    public static void print3(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode<Integer>> nodes = new Stack<>();
        nodes.push(root);

        while (!nodes.isEmpty()) {
            try {
                BinaryTreeNode<Integer> curr = nodes.pop();

                if (curr.right != null) {
                    nodes.push(curr.right);
                }

                if (curr.left == null) {
                    System.out.print(curr.data + " ");
                } else {
                    nodes.push(new BinaryTreeNode<Integer>(curr.data));
                    nodes.push(curr.left);
                }

            } catch (EmptyStackException e) {

            }
        }

    }
}
