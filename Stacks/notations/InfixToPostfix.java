package notations;

import java.util.*;

public class InfixToPostfix {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the infix expression");
        String infix = sc.nextLine();
        String postfix = infixToPostfix(infix);
        System.out.println("The postfix expression is " + postfix);
    }

    public static String infixToPostfix(String exp) {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;

            // If the scanned character is an '(',
            // push it to the stack.
            else if (c == '(')
                stack.push(c);

            // If the scanned character is an ')',
            // pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                stack.pop();
            } else // an operator is encountered
            {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {

                    result += stack.pop();
                }
                stack.push(c);
            }

            System.out.print(c);
            System.out.print('\t');
            System.out.print('(');
            for (int j = 0; j < exp.length() / 2; j++) {
                if (j < stack.size()) {
                    System.out.print(stack.get(j));
                } else
                    System.out.print(' ');
            }

            System.out.println('\t' + result);
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    public static int precedence(char ch) {
        switch (ch) {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;

        case '^':
            return 3;
        default:
            break;
        }
        return -1;
    }

}
