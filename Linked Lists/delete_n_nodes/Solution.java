package delete_n_nodes;

public class Solution {

    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int m, int n) {
        if (m == 0)
            return null;

        LinkedListNode<Integer> temp = head, t1 = null;
        int index = 1;

        while (temp != null) {
            if (index == m) {
                t1 = temp;
            }
            if (index == (m + n)) {
                t1.next = temp.next;
                index = 0;
            }
            temp = temp.next;
            index++;
        }

        if (index > m && index < (m + n))
            t1.next = null;

        return head;
    }
}