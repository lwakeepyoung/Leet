package hot100;

import java.util.ArrayList;
import java.util.List;

public class Demo22_error {

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if(n<=0){
            return result;
        }
        StringBuffer stringBuffer = new StringBuffer();
        backTrack(stringBuffer,n,n);
        return result;
    }

    private void backTrack(StringBuffer stringBuffer, int leftNum, int rightNum) {

        if(leftNum>rightNum){
            return;
        }
        if(leftNum<0 || rightNum<0){
            return;
        }

        if(leftNum==0&&rightNum==0){
            result.add(stringBuffer.toString());
            return;
        }

        stringBuffer.append("(");
        backTrack(stringBuffer,leftNum-1,rightNum);
        stringBuffer.deleteCharAt(stringBuffer.length()-1);

        stringBuffer.append(")");
        backTrack(stringBuffer,leftNum,rightNum-1);
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
    }
}
