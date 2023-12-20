package bst_tree_traversals.post_order;

import bst_tree_traversals.BinaryTreeNode;

public class Print {

    public static void postOrder(BinaryTreeNode<Integer> root){
        if(root==null){
            //System.out.print(-1 + " ");
            return;
        }
        postOrder(root.left);
        postOrder(root.right);

        System.out.print(root.data + " ");
    } 

    
}
