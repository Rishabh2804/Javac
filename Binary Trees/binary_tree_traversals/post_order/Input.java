package binary_tree_traversals.post_order;

import java.util.Scanner;

import binary_tree_traversals.BinaryTreeNode;
import queue_usingll.Queue;
import queue_usingll.QueueEmptyException;

public class Input {

	public static BinaryTreeNode<Integer> takeInput_level(Scanner s) throws QueueEmptyException {
		Queue<BinaryTreeNode<Integer>> pendingnodes = new Queue<>();
		System.out.print("Enter root data: ");
		int data = s.nextInt();
		if (data == -1)
			return null;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
		pendingnodes.enqueue(root);

		while (!pendingnodes.isEmpty()) {
			try {
				BinaryTreeNode<Integer> front = pendingnodes.dequeue();
				System.out.print("Enter left child of " + front.data + ": ");
				int left = s.nextInt();
				if (left != -1) {
					BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(left);
					pendingnodes.enqueue(child);
					front.left = child;
				}

				System.out.print("Enter right child of " + front.data + ": ");
				int right = s.nextInt();
				if (right != -1) {
					BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(right);
					pendingnodes.enqueue(child);
					front.right = child;
				}

			} catch (QueueEmptyException e) {
				return null;
			}
		}

		return root;
	}
}
