package pair_sum_root_to_leaf;

import java.util.ArrayList;
import java.util.List;

class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
        next = null;
    }

}

public class Solution {

    private Solution() {
    }

    public static List<LinkedListNode<Integer>> helper(BinaryTreeNode<Integer> root, int k) {
        if (root == null || root.data > k)
            return new ArrayList<>();

        if (root.data == k) {
            if (root.left == null && root.right == null) { // required leaf node
                LinkedListNode<Integer> leaf = new LinkedListNode<>(root.data);
                ArrayList<LinkedListNode<Integer>> ans = new ArrayList<>();
                ans.add(leaf);
                return ans;
            } else
                return new ArrayList<>(); // k satisfied but path is not complete(not a leaf)
        }

        List<LinkedListNode<Integer>> left = helper(root.left, k - root.data);
        List<LinkedListNode<Integer>> right = helper(root.right, k - root.data);
        List<LinkedListNode<Integer>> out = new ArrayList<>();

        if (left == null && right == null) // incomplete path
            return new ArrayList<>();

        if (left != null) {
            for (int i = 0; i < left.size(); i++) {
                LinkedListNode<Integer> self = new LinkedListNode<>(root.data);
                LinkedListNode<Integer> head = left.get(i);
                self.next = head;
                out.add(self);
            }
        }

        if (right != null) {
            for (int i = 0; i < right.size(); i++) {
                LinkedListNode<Integer> self = new LinkedListNode<>(root.data);
                LinkedListNode<Integer> head = right.get(i);
                self.next = head;
                out.add(self);
            }
        }

        return out;

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

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        List<LinkedListNode<Integer>> ans = helper(root, k);
        if (ans.isEmpty())
            return;

        for (int i = 0; i < ans.size(); i++) {
            LinkedListNode<Integer> head = ans.get(i);
            printll(head);
            System.out.println();
        }
    }

}
