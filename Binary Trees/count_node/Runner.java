package count_node;

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

    public static void print(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode<Integer>> pendingnodes = new Queue<>();
        pendingnodes.enqueue(root);

        int n;

        while (!pendingnodes.isEmpty()) {
            try {
                n = pendingnodes.getSize();
                for (int i = 0; i < n; ++i) {
                    BinaryTreeNode<Integer> front = pendingnodes.dequeue();
                    System.out.print(front.data + " ");

                    if (front.left != null)
                        pendingnodes.enqueue(front.left);

                    if (front.right != null)
                        pendingnodes.enqueue(front.right);

                }

                System.out.println();

            } catch (QueueEmptyException e) {
                return;
            }
        }

    }

    public static void main(String[] args) throws QueueEmptyException {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInput_level(s);

        System.out.println();
        print(root);

        System.out.println();
        System.out.println("No of nodes in given tree is/are: " + Solution.count(root));
    }
}