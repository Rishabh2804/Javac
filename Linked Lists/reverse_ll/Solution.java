package reverse_ll;
/*

    Following is the Node class already written for the Linked List

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        public LinkedListNode(T data) {
            this.data = data;
        }
    }

*/

public class Solution {

	public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {    //Recursive Method
        if(head==null ||head.next==null )
           return head;
           
        LinkedListNode<Integer> tail;
        tail=reverseLinkedListRec(head.next);

        head.next.next=head;
        head.next=null;

        return tail;
	}

    public static LinkedListNode<Integer> reverse_I(LinkedListNode<Integer> head){               //Iterative Method
        LinkedListNode<Integer> tail=null;
        
        while(head!=null){
            LinkedListNode<Integer> newnode;
       
            newnode=head;
            head=head.next;
            
            newnode.next=tail;
            tail=newnode;
        }
        
        return tail;
        }


}