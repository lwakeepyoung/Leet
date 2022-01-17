package stack;

import java.util.Stack;

/**
 * @Author: lwa
 * @Date: 2022/1/14 21:12
 */
public class Demo20 {
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if('('==c){
                stack.push(')');
            }else if('['==c){
                stack.push(']');
            }else if('{'==c){
                stack.push('}');
            }else if(stack.isEmpty()||c!=(char)stack.pop()){
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()")); ;
        System.out.println(isValid("({}])")); ;
    }
}
