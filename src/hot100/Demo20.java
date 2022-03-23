package hot100;

import java.util.Stack;

public class Demo20 {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if (stack.isEmpty() || c!=(char)stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
