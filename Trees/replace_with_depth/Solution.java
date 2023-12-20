package replace_with_depth;

public class Solution {

    public static void replaceWithDepthValue(TreeNode<Integer> root){
        root.data=0;

        QueueUsingLL<TreeNode<Integer>> nodes=new QueueUsingLL<>();
        nodes.enqueue(root);

        int level=1,l1=root.children.size(),l2=0;
        while(!nodes.isEmpty()){
            try{
             TreeNode<Integer> front=nodes.dequeue();

             for(int i=0;i<front.children.size();++i){
                 front.children.get(i).data=level;
                 nodes.enqueue(front.children.get(i));
                 l2+=front.children.get(i).children.size();
                 l1--;    
             }

             if(l1==0){
                 level++;
                 l1=l2;
                 l2=0;
             }

            } catch(QueueEmptyException e){
                return;
            }


        }
	}

    
}
