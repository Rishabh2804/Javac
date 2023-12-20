package binary_tree_traversals.pre_order;

import java.util.Scanner;

import binary_tree_traversals.BinaryTreeNode;
import queue_usingll.QueueEmptyException;

public class Main {

    public static void main(String[] args) throws QueueEmptyException {
        Scanner s = new Scanner(System.in);

        BinaryTreeNode<Integer> root = binary_tree_traversals.level_order.Input.takeInput_level(s);
        Print.print2(root);

    }

}
