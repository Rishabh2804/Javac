package quick_sort;

public class Solution {

    private Solution() {
    }

    public static LinkedListNode<Integer> quickSort(LinkedListNode<Integer> node) {
        LinkedListNode<Integer> last = node;
        LinkedListNode<Integer> first = node;
        while (last.next != null) {
            last = last.next;
        }

        return quickS(first, last);
    }

    public static LinkedListNode<Integer> partition(LinkedListNode<Integer> first, LinkedListNode<Integer> last) {

        if (first == null || first == last) {
            return first;
        }

        LinkedListNode<Integer> front = first;
        LinkedListNode<Integer> pivot = first;
        int temp = 0;

        while (front != null && front != last) {
            if (front.data < last.data) {
                pivot = first;
                temp = first.data;
                first.data = front.data;
                front.data = temp;
                first = first.next;
            }
            front = front.next;
        }

        temp = first.data;
        first.data = last.data;
        last.data = temp;

        return pivot;
    }

    public static LinkedListNode<Integer> quickS(LinkedListNode<Integer> first, LinkedListNode<Integer> last) {

        if (first == last) {
            return first;
        }
        LinkedListNode<Integer> pivot = partition(first, last);

        if (pivot != null && pivot.next != null) {
            quickS(pivot.next, last);
        }
        if (pivot != null && first != pivot) {
            quickS(first, pivot);
        }
        return first;
    }

}
