package bst_tree_traversals.post_order;
import java.util.Scanner;

import queue_usingll.QueueEmptyException;
import bst_tree_traversals.*;

public class Main {
    
    public static void main(String[] args) throws QueueEmptyException{
    Scanner s=new Scanner(System.in); 

    BinaryTreeNode<Integer> root=Input.takeInput();
    Print.postOrder(root);
    s.close();
 }


    
    
}
