package find_path;

import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data) {
		if (root == null)
			return null;

		if (root.data == data) {
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(root.data);
			return ans;
		}

		ArrayList<Integer> left = getPath(root.left, data);
		if (left != null) {
			left.add(0, root.data);
			return left;
		}

		ArrayList<Integer> right = getPath(root.right, data);
		if (right != null) {
			right.add(0, root.data);
			return right;
		}

		return null;
	}

	public static ArrayList<Integer> getPath2(BinaryTreeNode<Integer> root, int data) {
		if (root == null)
			return null;

		if (root.data == data) {
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(root.data);
			return ans;
		}

		ArrayList<Integer> left = getPath2(root.left, data);
		if (left != null) {
			left.add(root.data);
			return left;
		}

		ArrayList<Integer> right = getPath2(root.right, data);
		if (right != null) {
			right.add(root.data);
			return right;
		}

		return null;
	}

}
