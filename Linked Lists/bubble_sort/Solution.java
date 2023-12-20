package bubble_sort;

public class Solution {

    private Solution() {
    }

    private static int getsizell(LinkedListNode<Integer> ll) {
        int length = 0;
        LinkedListNode<Integer> temp = ll;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = null;

        int length = getsizell(head);
        int i = 1;

        while (i <= length) {
            temp = head;
            if (temp.next.data < temp.data) {
                head = temp.next;
                temp.next = head.next;
                head.next = temp;
            }

            while (temp != null) {
                if (temp.next.next == null)
                    break;
                if (temp.next.data > temp.next.next.data) {
                    LinkedListNode<Integer> temp2 = temp.next.next;
                    temp.next.next = temp.next.next.next;
                    temp2.next = temp.next;
                    temp.next = temp2;
                }
                temp = temp.next;
            }
            i++;
        }

        return head;
    }
}