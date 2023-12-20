package bst_tree_traversals.pre_order;
import java.util.Scanner;

import bst_tree_traversals.Input;
import bst_tree_traversals.*;
import queue_usingll.QueueEmptyException;

public class Main {

    
    public static void main(String[] args) throws QueueEmptyException{
    Scanner s=new Scanner(System.in); 

    BinaryTreeNode<Integer> root=Input.takeInput();
    Print.print2(root);

    s.close();    
 }
   
}
