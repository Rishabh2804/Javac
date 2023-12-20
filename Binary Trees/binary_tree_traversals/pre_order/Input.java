package binary_tree_traversals.pre_order;

import java.util.Scanner;
import binary_tree_traversals.BinaryTreeNode;

public class Input {

	public static BinaryTreeNode<Integer> takeInput(Scanner s) {
		int rootdata;
		// System.out.print("Enter root data: ");
		rootdata = s.nextInt();
		if (rootdata == -1) {
			return null;
		}

		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);
		root.left = takeInput(s);
		root.right = takeInput(s);

		return root;
	}
}
