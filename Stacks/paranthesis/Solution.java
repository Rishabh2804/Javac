package paranthesis;

import java.util.Stack;

public class Solution {

   public static boolean isBalanced(String expression) {
      Stack<Character> s = new Stack<>();

      for (int i = 0; i < expression.length(); ++i) {
         char c = expression.charAt(i);
         if (c == '(' || c == '{' || c == '[')
            s.push(c);

         if (c == ')') {
            if (s.isEmpty())
               return false;

            char p = s.pop();
            if (p != '(')
               return false;
         }
         if (c == '}') {
            if (s.isEmpty())
               return false;

            char p = s.pop();
            if (p != '{')
               return false;
         }
         if (c == ']') {
            if (s.isEmpty())
               return false;

            char p = s.pop();
            if (p != '[')
               return false;
         }

      }

      if (s.isEmpty())
         return true;
      else
         return false;
   }
}