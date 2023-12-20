package next_larger;

public class Solution {
    
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
        QueueUsingLL<TreeNode<Integer>> nodes=new QueueUsingLL<>();
        nodes.enqueue(root);
        TreeNode<Integer> ans=new TreeNode<>(Integer.MAX_VALUE);

        while(!nodes.isEmpty()){
            try{
                TreeNode<Integer> front=nodes.dequeue();
                if(front.data > n){
                    if(ans==null || front.data < ans.data)
                       ans=front;
                }

                for(int i=0;i<front.children.size();++i){
                    nodes.enqueue(front.children.get(i));
                }

            } catch( QueueEmptyException e){
                 return null;
            }
        }

        return ans;    
    }

    
}
