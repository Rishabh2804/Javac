package delete_node;

public class Solution {


	public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
    	if(head==null)
          return head;

        if(pos==0){
            return head.next;
        }  

        if(pos==1){
            if(head.next==null)
               return head;
               
            head.next=head.next.next;
            return head;
        }  

        head.next=deleteNodeRec(head.next, pos-1);
        return head;
	}

}