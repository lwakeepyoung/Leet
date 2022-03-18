package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo22 {

    private List<String> result = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        if(n==0){
            return result;
        }
        StringBuffer stringBuffer = new StringBuffer();
        backTrack(stringBuffer,n,n);
        return result;
    }
    public void backTrack(StringBuffer stringBuffer,int left,int right){
        if(left>right){
            return;
        }
        if(left<0 || right<0){
            return;
        }
        if(left==0&&right==0){
            result.add(stringBuffer.toString());
            return;
        }

        stringBuffer.append('(');
        backTrack(stringBuffer,left-1,right);
        stringBuffer.deleteCharAt(stringBuffer.length()-1);

        stringBuffer.append(')');
        backTrack(stringBuffer,left,right-1);
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
    }

    public static void main(String[] args) {
        new Demo22().generateParenthesis(3);
    }

}
