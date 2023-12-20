package leaf_to_root_path;

import java.util.List;
import java.util.Scanner;

class QueueEmptyException extends Exception {
}

class QueueUsingLL<T> {

	class Node<T1> {
		T1 data;
		Node<T1> next;

		Node(T1 data) {
			this.data = data;
		}
	}

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public T front() throws QueueEmptyException {
		if (size == 0) {
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}

		return head.data;
	}

	public void enqueue(T element) {
		Node<T> newNode = new Node<T>(element);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public T dequeue() throws QueueEmptyException {
		if (head == null) {
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		if (head == tail) {
			tail = null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

public class Runner {

	public static BinaryTreeNode<Integer> takeInput() {
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); // we can skip
																											// writing
																											// again
																											// inside <>
																											// after
																											// java
																											// version
																											// 1.7
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				s.close();
				return null;
			}
			int leftChildData = s.nextInt();
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		s.close();
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		List<Integer> output = Solution.longestRootToLeafPath(root);
		for (int i : output) {
			System.out.println(i);
		}
	}

}
