package remove_leaf_nodes;
public class Solution {


	public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
        if(root==null)
            return null;
        
        if(root.children.size()==0)
         return null;
        
     	for (int i = 0; i < root.children.size(); i++) {
         TreeNode<Integer> child= root.children.get(i);
         if(child.children.size() == 0) {
             
            for (int j = i; j < root.children.size() - 1; j++)
                 root.children.set(j, root.children.get(j + 1));

             root.children.remove(root.children.size()-1);
             i--;
          }
        }

     for (int i = 0;i < root.children.size();i++) {
         root.children.set(i,removeLeafNodes(root.children.get(i)));
     }
        
     return root;
    
	}
}
