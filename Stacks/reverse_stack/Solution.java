package reverse_stack;
import java.util.Stack;
public class Solution {

	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		while(!input.isEmpty()){
            extra.push(input.pop());
        }
        
        Stack<Integer> extra2 =new Stack<>();
        while(!extra.isEmpty()){
            extra2.push(extra.pop());
        }
        
        while(!extra2.isEmpty()){
            input.push(extra2.pop());
        }
        
        
        
	}
}