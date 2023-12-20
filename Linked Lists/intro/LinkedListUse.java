package intro;

import java.util.Scanner;

public class LinkedListUse {
    static Scanner s=new Scanner(System.in);
    public static Node<Integer> input(){
        Node<Integer> head=null;
        Node<Integer> tail=head;
       
        int in;
        
       
        
        System.out.println("Enter data elements:(-1 to stop) ");
          while(true){
              in=s.nextInt();
              if(in==-1)
                 break;
  
                 Node<Integer> newnode=new Node<>(in);
                 if(tail==null){
                     head=newnode;
                     tail=head;
                 }
                 else{
                     tail.next=newnode;
                     tail=newnode;
                 }
  
          }
  
        //  s.close();
          return head;
    }
   
    public static void insert(Node<Integer> head,int data,int pos){
        Node<Integer> newnode=new Node<>(data);
        Node<Integer> temp=head;
        
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
    }

    public static void print(Node<Integer> head){
       while(true){
           System.out.print(head.data);
           head=head.next;
           if(head==null)
              break;

              System.out.print("-> ");
       }
       System.out.println();

    }
    public static void main(String [] args){
     System.out.println("Hello! Welcome to the \"Linked List Wizard\"");
     Node<Integer> list=input();

     System.out.println("\n   -:Operations Menu:-");
     System.out.println("1.New Input");
     System.out.println("2.Insert Value");
     System.out.println("3.Print List");
     System.out.print("Enter your choice: ");
     int ch=s.nextInt();

     switch(ch){
         case 1: list=input();
                 System.out.println("\nHere's the resultant list:");
                 print(list);
                 break;
         case 2: int pos,value;
                 System.out.print("\nEnter the data value to be inserted: ");
                 value=s.nextInt();
                 System.out.print("Enter insertion position: ");
                 pos=s.nextInt();
                 insert(list, value, pos);
                 System.out.println("\nHere's the resultant list:");
                 print(list);
                 break;
         case 3: print(list);
                 break;
        default: System.out.println("\nInvalid Choice!!");
                 System.out.println("Anyway,here's your list:");
                 print(list);
     }
     s.close();
    }
}
   