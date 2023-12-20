package minStack;

import java.util.Stack;

public class MinStack {

    int minEle = Integer.MAX_VALUE;
    Stack<Integer> s = new Stack<>();

    /* returns min element from stack */
    public int getMin() {

        // Write your code here
        if (s.empty())
            return -1;
        return minEle;
    }

    /* returns poped element from stack */
    int pop() {

        // Write your code here
        if (s.empty())
            return -1;
        int y = s.pop();
        int x;
        if (y < 0) {
            x = minEle;
            minEle = minEle - y;
        } else {
            x = minEle + y;
        }
        return x;
    }

    /* push element x into the stack */
    void push(int x) {

        // Write your code here
        if (s.empty()) {
            minEle = x;
            s.push(0);
        } else {
            s.push(x - minEle);
            minEle = Math.min(minEle, x);
        }
    }
}
