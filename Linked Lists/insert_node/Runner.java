package insert_node;

import java.util.Scanner;

import linkedlist_node.*;
public class Runner {
    static Scanner s=new Scanner(System.in);

    public static LinkedListNode<Integer> takeInput(){
        LinkedListNode<Integer> head=null;
        LinkedListNode<Integer> tail=head;
       
        int in;
        
        System.out.println("Enter data elements:(-1 to stop) ");
          while(true){
              in=s.nextInt();
              if(in==-1)
                 break;
  
                 LinkedListNode<Integer> newnode=new LinkedListNode<>(in);
                 if(tail==null){
                     head=newnode;
                     tail=head;
                 }
                 else{
                     tail.next=newnode;
                     tail=newnode;
                 }
  
          }
  
        return head;
    }

    public static void print(LinkedListNode<Integer> head){
        while(true){
            System.out.print(head.data);
            head=head.next;
            if(head==null)
               break;
 
               System.out.print("-> ");
        }
        System.out.println();
 
     }

     public static void main(String[] args) {
         LinkedListNode<Integer> head=takeInput();
         head=Solution.insert_I(head, 2, 10);
         print(head);
     }
 
    
}
