package sorted_ll;

class Pair<T,V>{
    T a;
    V b;

    Pair(T a,V b){
        this.a=a;
        this.b=b;
    }
}

public class Solution {    

    public static Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> constructLinkedList2(BinaryTreeNode<Integer> root) {
        if(root==null){
            return new Pair<>(null,null);
        }

        Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> left=constructLinkedList2(root.left);   
        Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> right=constructLinkedList2(root.right);

        LinkedListNode<Integer> self=new LinkedListNode<>(root.data);
        if(left.b!=null)
           left.b.next=self;

           self.next=right.a;  //OK even if null

        LinkedListNode<Integer> head=left.a;
        if(head==null)
           head=self;

        LinkedListNode<Integer> tail=right.b;
        if(tail==null)
          tail=self;

        return new Pair<>(head,tail);
	}

    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> ans=constructLinkedList2(root);

        return ans.a;
    }
        
}
