package getsizell;

import linkedlist_node.*;

public class Solution {

    private static int getsizell(LinkedListNode<Integer> ll){
        int length=0;
        LinkedListNode<Integer> temp=ll;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
	public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
		if(n==0)
          return head;

        LinkedListNode<Integer> temp=head;
       // LinkedListNode<Integer> tail=null;
        LinkedListNode<Integer> newhead=null;
        LinkedListNode<Integer> newtail=null;
        int length=getsizell(head);
        
        int index=0;
        while(temp!=null){
            index++;
            
            if(index==length-n){
                newtail=temp;
                newhead=temp.next;
            }
            if(index==length-n+1){
                newhead.next=temp.next;
            }
            if(index==length){
                temp.next=head;
                newtail.next=null;
            }
            else{
                temp=temp.next;
            }
            
        }
        return newhead;
        
	}


    
}
