public class Solution {

    static class Parenthesis {
        char bracket;
        Parenthesis next;

        Parenthesis(char bracket) {
            this.bracket = bracket;
        }
    }

    public boolean isValid(String s) {

        Parenthesis top = null;
        for (int i = 0; i < s.length(); ++i) {

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                Parenthesis open = new Parenthesis(s.charAt(i));
                open.next = top;
                top = open;
            } else {
                if (top == null)
                    return false;

                boolean ret = top.bracket == '(' && s.charAt(i) != ')';
                ret |= top.bracket == '{' && s.charAt(i) != '}';
                ret |= top.bracket == '[' && s.charAt(i) != ']';

                if (ret)
                    return false;

                top = top.next;
            }
        }

        return top == null;
    }

}
