package merge_sortedll;
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
    
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        
        LinkedListNode<Integer> H,head,tail,temp;
        if(head1.data<=head2.data){
            H=head1;
            tail=head2;
        }
        else{
            H=head2;
            tail=head1;
        }
        head=H;

        while(true){
            if(head.next==null){
                head.next=tail;
                break;
            }
            if(head.next.data>tail.data){
                temp=head.next;
                head.next=tail;
                tail=temp;
            }
            else
               head=head.next;
        }

        return H;
    }

}