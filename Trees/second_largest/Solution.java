package second_largest;

public class Solution {

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){

        TreeNode<Integer> large1=root,large2=null;

        QueueUsingLL<TreeNode<Integer>> nodes=new QueueUsingLL<>();
        nodes.enqueue(root);

        while(!nodes.isEmpty()){
            try{
                TreeNode<Integer> front=nodes.dequeue();
            
                if(front.data > large1.data){
                    large2=large1;
                    large1=front;
                } 

                if(front.data < large1.data){
                    if(large2==null || front.data > large2.data)
                    large2=front;
                }

                for(int i=0;i<front.children.size();++i){
                    nodes.enqueue(front.children.get(i));
                }

            } catch(QueueEmptyException e){
                return null;
            }
        }

        return large2;
    }

    
}
