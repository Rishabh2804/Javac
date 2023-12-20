package reverse_queue;
import java.util.Queue;
import java.util.Stack;

public class Solution {

	public static void reverseQueue(Queue<Integer> input) {
		Stack<Integer> temp=new Stack<>();
        while(!input.isEmpty()){
            temp.push(input.poll());
        }
        
        while(!temp.isEmpty()){
            input.add(temp.pop());    
        }
        
	}

}