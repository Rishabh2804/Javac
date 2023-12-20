package even_after_odd;

public class Solution {

	public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
        if(head==null || head.next==null)
          return head;

        LinkedListNode<Integer> odd=null,o_head=null,e_head=null,even=null,temp=head;

        while(temp!=null){
            LinkedListNode<Integer> newnode=new LinkedListNode<>(temp.data);
            if(temp.data%2==0){
                if(even==null)
                   even=e_head=newnode;
                else{   
                   even.next=newnode;
                   even=even.next;
                }
            }
            else{
                if(odd==null)
                  odd=o_head=newnode;
                else{
                    odd.next=newnode;
                    odd=odd.next;
                }  
            }

            temp=temp.next;              
        }

        if(odd==null)
           return e_head;
           
        odd.next=e_head;
        return o_head;
	}
}