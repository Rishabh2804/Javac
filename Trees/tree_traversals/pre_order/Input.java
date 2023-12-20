package tree_traversals.pre_order;

import java.util.Scanner;
import tree_traversals.TreeNode;

public class Input {
    public static TreeNode<Integer> takeInput(Scanner s,int n){        
        int data;
        System.out.print("Enter data for node no." + n + ": ");
        data=s.nextInt();
        TreeNode<Integer> root=new TreeNode<Integer>(data);
        System.out.print("Enter no of children for " + data + " : ");
        int childcount=s.nextInt();
        System.out.println();

        for(int i=0;i<childcount;++i){
            TreeNode<Integer> child=takeInput(s,i+1);
            root.children.add(child);
        }

        return root;

    }

    
}
