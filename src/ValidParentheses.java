import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {

            /*
            Push char onto stack if it's an opening parentheses
             */
            if(ch == '(' || ch == '[' || ch == '{') stack.push(ch);

            else {

                /*
                If at any time during the loop, the stack is empty return false
                 */
                if(stack.isEmpty()) return false;

                /*
                If a closing parentheses isn't preceded by an opening parentheses, return false
                 */
                if(ch == ')' && stack.pop() != '(') return false;
                if(ch == ']' && stack.pop() != '[') return false;
                if(ch == '}' && stack.pop() != '{') return false;

            }

        }

        return stack.isEmpty();
    }

}
