package reverse_k;

public class Solution {

    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {    //Recursive Method
        if(head==null ||head.next==null )
           return head;
           
        LinkedListNode<Integer> tail;
        tail=reverse(head.next);

        head.next.next=head;
        head.next=null;

        return tail;
	}

	public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
		if(head==null || k==1 || k==0){
            return head;
        }

        LinkedListNode<Integer> temp,temp2,rev,rest=null;
        int i=0;
        temp=head;

        while(temp!=null){
            i++;
            if(i==k){
                if(temp.next==null)
                  break;

                rest=kReverse(temp.next,k);
                temp.next=null;
                i=0;
                break;
            }
            temp=temp.next;
        }

        rev=reverse(head);

        temp2=rev;
        while(true){
            if(temp2.next==null){
               temp2.next=rest;
               break;
            }
            temp2=temp2.next;
        }

        return rev;
	}

}