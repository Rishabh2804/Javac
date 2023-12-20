package level_linked_list;

import java.util.ArrayList;
import java.util.List;

import queue_usingll.Queue;
import queue_usingll.QueueEmptyException;

public class Solution {

    private Solution() {

    }

    public static List<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<LinkedListNode<Integer>> ans = new ArrayList<>();

        Queue<BinaryTreeNode<Integer>> pendingnodes = new Queue<>();
        pendingnodes.enqueue(root);

        int n;

        while (!pendingnodes.isEmpty()) {
            try {
                n = pendingnodes.getSize();
                LinkedListNode<Integer> head = null;
                LinkedListNode<Integer> temp = null;
                for (int i = 0; i < n; ++i) {
                    BinaryTreeNode<Integer> front = pendingnodes.dequeue();
                    LinkedListNode<Integer> newnode = new LinkedListNode<>(front.data);

                    if (i == 0) {
                        head = newnode;
                        temp = head;
                    } else {
                        temp.next = newnode;
                        temp = temp.next;
                    }

                    if (front.left != null)
                        pendingnodes.enqueue(front.left);
                    if (front.right != null)
                        pendingnodes.enqueue(front.right);

                }
                ans.add(head);
            } catch (QueueEmptyException e) {
                return new ArrayList<>();
            }
        }

        return ans;
    }

}
