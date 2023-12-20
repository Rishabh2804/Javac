package insert_duplicate_node;


public class Solution {

	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
	    if(root==null)
            return;        
        
        insertDuplicateNode(root.left);
    
        BinaryTreeNode<Integer> self=new BinaryTreeNode<>(root.data);
        BinaryTreeNode<Integer> temp=root.left;
        
        root.left=self;
        self.left=temp;
        
        insertDuplicateNode(root.right);
        
	}
	
}