package binary_tree_traversals.level_order;

import java.util.Scanner;

import queue_usingll.QueueEmptyException;
import binary_tree_traversals.BinaryTreeNode;

public class Main {

    public static void main(String[] args) throws QueueEmptyException {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = Input.takeInput_level(s);
        Print.printLevel2(root);
    }
}
