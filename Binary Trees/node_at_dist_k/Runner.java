package node_at_dist_k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		return size == 0;
	}

	public T front() throws QueueEmptyException {
		if (size == 0) {
			throw new QueueEmptyException();
		}

		return head.data;
	}

	public void enqueue(T element) {
		Node<T> newNode = new Node<>(element);

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
			throw new QueueEmptyException();
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
		this.left = null;
		this.right = null;
	}
}

public class Runner {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		int start = 0;

		String[] nodeDatas = br.readLine().trim().split(" ");

		if (nodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(nodeDatas[start]);
		start += 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}

			int leftChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}

			int rightChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}

		return root;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		int q = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < q; ++i) {
			String[] targetK = br.readLine().trim().split(" ");

			int target = Integer.parseInt(targetK[0].trim());
			int k = Integer.parseInt(targetK[1].trim());

			Solution.nodesAtDistanceK(root, target, k);
		}
	}
}