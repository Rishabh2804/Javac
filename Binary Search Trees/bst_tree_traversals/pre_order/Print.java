package bst_tree_traversals.pre_order;

import bst_tree_traversals.BinaryTreeNode;

public class Print {

    public static void print(BinaryTreeNode<Integer> root){
        if(root==null)
          return;

        String str=root.data + " ";
        if(root.left !=null){
             str+= "L:" + root.left.data + ',';         
        }

        if(root.right!=null){
            str+="R:" + root.right.data;
        }

        System.out.println(str);
        print(root.left);
        print(root.right);
    }   

    public static void print2(bst_tree_traversals.BinaryTreeNode<Integer> root){
        if(root==null)
           return;

        System.out.print(root.data +" ");
        print2(root.left);
        print2(root.right);
          
    }
}
