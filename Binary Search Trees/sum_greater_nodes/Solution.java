package sum_greater_nodes;

public class Solution {
    
    private static int sum=0;
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        if(root==null)
           return;

        replaceWithLargerNodesSum(root.right);
        
        sum+=root.data;
        root.data=sum;

        
        replaceWithLargerNodesSum(root.left);
	}

    
}
