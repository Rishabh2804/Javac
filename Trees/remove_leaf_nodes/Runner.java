package remove_leaf_nodes;

import java.util.ArrayList;
import java.util.Scanner;

class QueueEmptyException extends Exception {
}

class QueueUsingLL<T> {

	class Node<T1> {
		T1 data;
		Node<T1> next;
		Node(T1 data){
			this.data = data;
		}
	}

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public T front() throws QueueEmptyException{
		if(size == 0){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}

		return head.data;
	}


	public void enqueue(T element){
		Node<T> newNode = new Node<T>(element);

		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public T dequeue() throws QueueEmptyException{
		if(head == null){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		if(head == tail){
			tail = null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}

class TreeNode<T> {
	T data;
	ArrayList<TreeNode<T>> children;

	TreeNode(T data){
		this.data = data;
		children = new ArrayList<TreeNode<T>>();
	}
}

public class Runner {



	static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.enqueue(childNode);
					currentNode.children.add(childNode);
				}
			} catch (QueueEmptyException e) {
			}
		}
		return root;
	}

	public static void printTreeLevelWise(TreeNode<Integer> root){
		if(root == null) {
			return;
		}
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>(); 
		pendingNodes.enqueue(root);
		pendingNodes.enqueue(null);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode = null;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				e.printStackTrace();
			}
			if(currentNode == null) {
				if(pendingNodes.isEmpty()) {
					break;
				}
				System.out.println();
				pendingNodes.enqueue(null);
				continue;
			}
			System.out.print(currentNode.data + " ");
			int numChild = currentNode.children.size();
			for(int i = 0 ; i < numChild; i++){
				pendingNodes.enqueue(currentNode.children.get(i));
			}
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> root =  takeInputLevelWise();
		root = Solution.removeLeafNodes(root);
		printTreeLevelWise(root);
	}
}
