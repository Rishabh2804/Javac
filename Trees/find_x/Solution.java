package find_x;

public class Solution {
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
        QueueUsingLL<TreeNode<Integer>> nodes=new QueueUsingLL<>();
        nodes.enqueue(root);
        
        while(!nodes.isEmpty()){
            try{
                TreeNode<Integer> front =nodes.dequeue();
                if(front.data==x)
                    return true;
                
                for(int i=0;i<front.children.size();++i)
                   nodes.enqueue(front.children.get(i));   

            } catch( QueueEmptyException e){
                return false;
            }
        }

        return false;
    }

}
