package insert_node;

import linkedlist_node.*;

public class Solution {

    public static LinkedListNode<Integer> insert_R(LinkedListNode<Integer> head,int pos,int elem){
        if(pos==0){
            LinkedListNode<Integer> newnode=new LinkedListNode<>(elem);
            newnode.next=head;
            return newnode;
        }

        head.next=insert_R(head.next,pos-1,elem);
        return head;
    }

    public static LinkedListNode<Integer> insert_I(LinkedListNode<Integer> head,int data,int pos){           //Iterative Method
        LinkedListNode<Integer> newnode=new LinkedListNode<>(data);
        LinkedListNode<Integer> temp=head;
        
        if(pos==1){
        int t=newnode.data;
        newnode.data=head.data;
        head.data=t;
        
        newnode.next=head.next;
        head.next=newnode;
        }

        int index=1;
        while(temp!=null){
            index++;
            if(index==pos){
                newnode.next=temp.next;
                temp.next=newnode;                
            }
            temp=temp.next;
        }
    
        return head;
    }

}
