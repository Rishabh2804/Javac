package swap_nodes;

public class Solution {

   private Solution() {

   }

   public static LinkedListNode<Integer> swapNodes(swap_nodes.LinkedListNode<Integer> head, int i, int j) {
      int index = 1;
      LinkedListNode<Integer> a, b, temp; // a : ith node ; b: jth node
      temp = head;
      a = b = null;

      while (temp != null) {
         if (index == Math.min(i, j))
            a = temp;
         if (index == Math.max(i, j))
            b = temp;

         index++;
         temp = temp.next;
      }

      LinkedListNode<Integer> t1;
      LinkedListNode<Integer> t2;
      LinkedListNode<Integer> temp2;
      if (a == null)
         t1 = head;
      else
         t1 = a.next;

      t2 = b.next;

      if (Math.abs(i - j) == 1) { // If consecitive nodes are to be swapped
         temp2 = t1;

      } else
         temp2 = t1.next;

      t1.next = t2.next;
      t2.next = temp2;

      if (Math.abs(i - j) != 1)
         b.next = t1;

      if (a == null)
         head = t2;
      else
         a.next = t2;

      return head;
   }
}
