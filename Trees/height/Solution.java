package height;
public class Solution {

	/*	TreeNode structure 
	 * 
	 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/

	public static int getHeight(TreeNode<Integer> root){
		QueueUsingLL<TreeNode<Integer>> pendingnodes =new QueueUsingLL<>();
        pendingnodes.enqueue(root);
       
        int l1=1,l2=0,level=0;
        
        while(!pendingnodes.isEmpty()){
            try{
                TreeNode<Integer> frontnode=pendingnodes.dequeue();
                for(int i=0;i<frontnode.children.size();++i){
                    pendingnodes.enqueue(frontnode.children.get(i));
                }
                l2+=frontnode.children.size();
                l1--;
                if(l1==0){
                    level++;
                    l1=l2;
                    l2=0;
                }
                
            } catch(QueueEmptyException e){
                return -1;
            }
           
        }
        
        return level;
	}

}