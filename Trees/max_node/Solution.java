package max_node;

public class Solution {
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		QueueUsingLL<TreeNode<Integer>> nodes=new QueueUsingLL<>();
        nodes.enqueue(root);

        TreeNode<Integer> max=root;
        int maxsum=0;
        while(!nodes.isEmpty()){
            try{
            TreeNode<Integer> front=nodes.dequeue();
            int sum=front.data;

            for(int i=0;i<front.children.size();++i){
                nodes.enqueue(front.children.get(i));
                sum+=front.children.get(i).data;
            }

            if(sum>maxsum){
                maxsum=sum;
                max=front;
            }

            } catch(QueueEmptyException e){
                return null;
            }

        }

        return max;
    }
	
    
}
