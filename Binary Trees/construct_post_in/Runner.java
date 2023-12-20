package construct_post_in;

import java.util.Scanner;

import queue_usingll.Queue;
import queue_usingll.QueueEmptyException;

class BinaryTreeNode<T> {
    public final T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Runner {

    public static void printLevel2(BinaryTreeNode<Integer> root) {
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

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter no of nodes: ");
        int n = s.nextInt();

        System.out.print("Enter elements in postorder: ");
        int[] post = new int[n];
        for (int i = 0; i < n; ++i) {
            post[i] = s.nextInt();
        }

        System.out.print("Enter elements in inorder: ");
        int[] in = new int[n];
        for (int i = 0; i < n; ++i) {
            in[i] = s.nextInt();
        }

        BinaryTreeNode<Integer> root = Solution.buildTree(post, in);
        System.out.println();
        printLevel2(root);

        s.close();
    }
}
