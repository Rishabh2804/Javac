package zigzag;

import queue_usingll.*;
import queue_usingll.Queue;

import java.util.*;

public class Solution {

    public static void printZigZag(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode<Integer>> pendingnodes = new Stack<>();
        pendingnodes.push(root);

        boolean zig = true;
        int n;

        while (!pendingnodes.isEmpty()) {
            try {
                n = pendingnodes.size();
                Queue<BinaryTreeNode<Integer>> child = new Queue<>();
                if (zig) {
                    for (int i = 0; i < n; ++i) {
                        BinaryTreeNode<Integer> front = pendingnodes.pop();
                        System.out.print(front.data + " ");
                        if (front.left != null)
                            child.enqueue(front.left);

                        if (front.right != null)
                            child.enqueue(front.right);
                    }
                } else {
                    for (int i = 0; i < n; ++i) {
                        BinaryTreeNode<Integer> front = pendingnodes.pop();
                        System.out.print(front.data + " ");
                        if (front.right != null)
                            child.enqueue(front.right);

                        if (front.left != null)
                            child.enqueue(front.left);
                    }

                }

                while (!child.isEmpty()) {
                    pendingnodes.push(child.dequeue());
                }

                System.out.println();
                zig = zig == false;

            } catch (EmptyStackException | QueueEmptyException e) {
                return;
            }

        }
    }

}
