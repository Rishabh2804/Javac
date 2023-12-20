package level_linked_list;

import java.util.List;
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

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
        next = null;
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

    public static void print(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode<Integer>> pendingnodes = new Queue<>();
        pendingnodes.enqueue(root);

        int l1 = 1;
        int l2 = 0;

        while (!pendingnodes.isEmpty()) {
            try {
                BinaryTreeNode<Integer> front = pendingnodes.dequeue();
                System.out.print(front.data + " ");

                if (front.left != null) {
                    l2++;
                    pendingnodes.enqueue(front.left);
                }
                if (front.right != null) {
                    l2++;
                    pendingnodes.enqueue(front.right);
                }

                l1--;
                if (l1 == 0) {
                    System.out.println();
                    l1 = l2;
                    l2 = 0;
                }

            } catch (QueueEmptyException e) {
                return;
            }
        }
    }

    public static void printll(LinkedListNode<Integer> head) {
        if (head == null)
            return;

        LinkedListNode<Integer> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws QueueEmptyException {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevel(s);

        print(root);

        System.out.println();

        List<LinkedListNode<Integer>> arr = Solution.constructLinkedListForEachLevel(root);

        for (int i = 0; i < arr.size(); ++i) {
            LinkedListNode<Integer> head = arr.get(i);
            printll(head);
            System.out.println();
        }

    }
}