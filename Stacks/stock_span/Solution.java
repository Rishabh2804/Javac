package stock_span;
import java.util.Stack;

public class Solution {

	public static int[] stockSpan(int[] price) {
        int size=price.length;
        int ans[]=new int[size];
        ans[0]=1;
        
        Stack<Integer> span=new Stack<>();
        span.push(0);
        for(int i=1;i<size;++i){
            while(!span.empty() && price[span.peek()]<price[i])
                span.pop();
            
            if(span.empty())
                ans[i]=i+1;
            else
                ans[i]=i-span.peek();
        
            span.push(i);
        }
        return ans;
    }

}