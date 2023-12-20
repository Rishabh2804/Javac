package tree_traversals.post_order;

import tree_traversals.TreeNode;

public class Print {

    public static void printPostOrder(TreeNode<Integer> root){
        
        if(root.children.size()>0){
            for(int i=0;i<root.children.size();++i){
                printPostOrder(root.children.get(i));
            }
        }    
        
        System.out.print(root.data + " ");

    }
    
    
}
