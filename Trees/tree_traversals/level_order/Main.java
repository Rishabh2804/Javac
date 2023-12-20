package tree_traversals.level_order;
import java.util.Scanner;

import tree_traversals.TreeNode;
import queue_usingll.QueueEmptyException;

public class Main {
    

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

    public static void main(String[] args) throws QueueEmptyException{
    Scanner s=new Scanner(System.in); 
    
    TreeNode<Integer> root=Input.takeInput_level(s,1);
    Print.print_level2(root);
 }
    
}
