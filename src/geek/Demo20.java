package geek;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Demo20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c:
             chars) {
            if(c=='('){
                stack.push(')');
            }else if(c=='{'){
                stack.push('}');
            }else if (c=='['){
                stack.push(']');
            }else if (stack.isEmpty()||c!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
