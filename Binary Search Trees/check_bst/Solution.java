package check_bst;

/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

 */
class Pair<T, V> {
	T a;
	V b;

	Pair(T a, V b) {
		this.a = a;
		this.b = b;
	}
}

public class Solution {

	private Solution() {

	}

	public static Pair<Pair<Integer, Integer>, Boolean> isBST2(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return new Pair<>(new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE), true);
		}

		Pair<Pair<Integer, Integer>, Boolean> left = isBST2(root.left);
		Pair<Pair<Integer, Integer>, Boolean> right = isBST2(root.right);

		int min = Math.min(root.data, Math.min(left.a.a, right.a.a));
		int max = Math.max(root.data, Math.max(left.a.b, right.a.b));
		boolean bst = (root.data > left.a.b) && (root.data <= right.a.a) && left.b && right.b;

		return new Pair<>(new Pair<>(min, max), bst);
	}

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if (root == null)
			return true;

		return isBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBST3(BinaryTreeNode<Integer> root, int min, int max) {
		if (root == null)
			return true;

		if (root.data < min || root.data > max)
			return false;

		boolean left = isBST3(root.left, min, root.data - 1);
		boolean right = isBST3(root.right, root.data, max);

		return left && right;
	}

}