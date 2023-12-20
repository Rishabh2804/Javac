package merge_sort;

public class Solution {

    private Solution() {

    }

    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1,
            LinkedListNode<Integer> head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        LinkedListNode<Integer> front;
        LinkedListNode<Integer> head;
        LinkedListNode<Integer> tail;
        LinkedListNode<Integer> temp;
        if (head1.data <= head2.data) {
            front = head1;
            tail = head2;
        } else {
            front = head2;
            tail = head1;
        }
        head = front;

        while (true) {
            if (head.next == null) {
                head.next = tail;
                break;
            }
            if (head.next.data > tail.data) {
                temp = head.next;
                head.next = tail;
                tail = temp;
            } else
                head = head.next;
        }

        return front;
    }

    public static LinkedListNode<Integer> findmid(LinkedListNode<Integer> head) {
        if (head == null)
            return head;

        LinkedListNode<Integer> slow;
        LinkedListNode<Integer> fast;
        slow = head;
        fast = head;

        while (true) {
            fast = fast.next;
            if (fast == null || fast.next == null)
                break;

            fast = fast.next;

            slow = slow.next;
        }
        return slow;
    }

    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) // Contains 1 or no nodes
            return head;
        if (head.next.next == null) { // Contains exactly 2 nodes
            if (head.data > head.next.data) {
                int temp = head.data;
                head.data = head.next.data;
                head.next.data = temp;
            }
            return head;
        }

        LinkedListNode<Integer> mid = findmid(head);
        LinkedListNode<Integer> head1 = mergeSort(mid.next); // Sort second half with first node as mid.next
        mid.next = null; // Unlink the sub-list to create a division
        LinkedListNode<Integer> head2 = mergeSort(head); // Sort the first half of linked list

        head = mergeTwoSortedLinkedLists(head1, head2);

        return head;
    }

}