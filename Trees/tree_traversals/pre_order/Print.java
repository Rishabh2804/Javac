package tree_traversals.pre_order;

import tree_traversals.TreeNode;

public class Print {

    public static void print(TreeNode<Integer> root){
        String s=root.data +":";
        if(root.children.size()==0){
            s+=" (leaf)";
        }
        for(int i=0;i<root.children.size();++i){
            s+=" " + root.children.get(i).data;
            if(i==root.children.size()-1)
               continue;

            s+=',';   
        }

        System.out.println(s);
        for(int i=0;i<root.children.size();++i){
            print(root.children.get(i));
        }
    }

    
    
}
