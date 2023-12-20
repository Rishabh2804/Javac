package b_height;

import java.util.Scanner;

import queue_usingll.Queue;
import queue_usingll.QueueEmptyException;

class BinaryTreeNode<T> {
	public T data;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class Runner {
	public static BinaryTreeNode<Integer> takeInputLevel(Scanner s) throws QueueEmptyException {
		Queue<BinaryTreeNode<Integer>> pendingnodes = new Queue<>();
		System.out.print("Enter root data: ");
		int data = s.nextInt();
		if (data == -1)
			return null;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
		pendingnodes.enqueue(root);

		while (!pendingnodes.isEmpty()) {
			try {
				BinaryTreeNode<Integer> front = pendingnodes.dequeue();
				System.out.print("Enter left child of " + front.data + ": ");
				int left = s.nextInt();
				if (left != -1) {
					BinaryTreeNode<Integer> child = new BinaryTreeNode<>(left);
					pendingnodes.enqueue(child);
					front.left = child;
				}

				System.out.print("Enter right child of " + front.data + ": ");
				int right = s.nextInt();
				if (right != -1) {
					BinaryTreeNode<Integer> child = new BinaryTreeNode<>(right);
					pendingnodes.enqueue(child);
					front.right = child;
				}

			} catch (QueueEmptyException e) {
				return null;
			}
		}

		return root;
	}

	public static void main(String[] args) throws QueueEmptyException {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevel(s);

		System.out.println(Solution.height(root));
	}
}