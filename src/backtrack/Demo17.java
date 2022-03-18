package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo17 {
    private String[] dic = new String[]{"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    List<String> result = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        StringBuffer stringBuffer = new StringBuffer();
        backTack(stringBuffer,digits,0);
        return result;
    }

    public void backTack(StringBuffer stringBuffer,String digits,int start){
        if(stringBuffer.length()==digits.length()){
            result.add(stringBuffer.toString());
            return;
        }

        for (int i = start; i < digits.length(); i++) {
            int index = digits.charAt(i)+'0';
            for (char c : dic[index].toCharArray()) {
                stringBuffer.append(c);
                backTack(stringBuffer,digits,i+1);
                stringBuffer.deleteCharAt(stringBuffer.length()-1);
            }
        }
    }
}
