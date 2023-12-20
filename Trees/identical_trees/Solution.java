package identical_trees;

public class Solution {

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
        QueueUsingLL<TreeNode<Integer>> nodes1=new QueueUsingLL<>();
        QueueUsingLL<TreeNode<Integer>> nodes2=new QueueUsingLL<>();

        nodes1.enqueue(root1);
        nodes2.enqueue(root2);

        while(!(nodes1.isEmpty() && nodes2.isEmpty())){
            try{
             TreeNode<Integer> front1=nodes1.dequeue();
             TreeNode<Integer> front2=nodes2.dequeue();

             if(!(front1.data==front2.data && front1.children.size()==front2.children.size()))
                return false;

             for(int i=0;i<front1.children.size();++i){
                nodes1.enqueue(front1.children.get(i));
                nodes2.enqueue(front2.children.get(i));
             }   

            } catch(QueueEmptyException e){
                return false;
            }

        }
        return true;
	}
	
    
}
