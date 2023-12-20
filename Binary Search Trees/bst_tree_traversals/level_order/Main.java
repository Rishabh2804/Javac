package bst_tree_traversals.level_order;
import java.util.Scanner;

import queue_usingll.QueueEmptyException;
import bst_tree_traversals.BinaryTreeNode;
import bst_tree_traversals.Input;

public class Main {
    
    public static void main(String[] args) throws QueueEmptyException{
    Scanner s=new Scanner(System.in); 

    BinaryTreeNode<Integer> root=Input.takeInput();
    Print.print_level2(root);
    
    s.close();
 }
}
