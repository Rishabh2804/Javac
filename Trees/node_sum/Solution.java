package node_sum;

public class Solution {
    
        public static int sumOfAllNode(TreeNode<Integer> root){
            int sum=0;
            QueueUsingLL<TreeNode<Integer>> pendingnodes=new QueueUsingLL<>();
            pendingnodes.enqueue(root);

            while(!pendingnodes.isEmpty()){
                try{
                    TreeNode<Integer> frontnode=pendingnodes.dequeue();
                    sum+=frontnode.data;

                    for(int i=0;i<frontnode.children.size();++i){
                        pendingnodes.enqueue(frontnode.children.get(i));
                    }
                    
                } catch(QueueEmptyException e){
                    return -1;                                  //will never happen
                }
            }
            
            
            return sum;
        }
    }
    