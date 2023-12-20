package redundant_brackets;
import java.util.Stack;

public class Solution {

    public static boolean checkRedundantBrackets(String expression) {
        Stack<Character> s=new Stack<>();
        int size=expression.length();
        
        for(int i=0;i<size;++i){
            char c=expression.charAt(i);
            if(c==')'){
               if(i==0) 
                   return true;
                
                int count=0;
                while(s.pop()!='('){
                    count++;
                }
                if(count<2)
                    return true;
            }
            else{
                s.push(c);
            }
        }
        
        return false;
    }
}