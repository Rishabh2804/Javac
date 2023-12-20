package find_path_bst;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		if(root==null)
		   return null;

		if(root.data==data){
			ArrayList<Integer> ans=new ArrayList<>();
			ans.add(root.data);
			return ans;
		}   

		if(root.data > data){
			ArrayList<Integer> left=getPath(root.left, data);
			if(left!=null){
				left.add(root.data);
			}   
			return left;
		}

		if(root.data < data){
			ArrayList<Integer> right=getPath(root.right, data);
			if(right!=null){
				right.add(root.data);
			}
			return right;
		}
		
		return null;   //will never happen
	}

}
