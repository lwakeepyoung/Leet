package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Demo17_2 {
    private String[] dic = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};


    private List<String> result =  new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return result;
        }
        StringBuffer stringBuffer = new StringBuffer();
        backTrack(stringBuffer,digits,0);
        return result;
    }

    public void backTrack(StringBuffer stringBuffer,String digits,int start){
        if(stringBuffer.length() == digits.length()){
            result.add(stringBuffer.toString());
            return;
        }

        for (int i = start; i < digits.length(); i++) {
            int index = digits.charAt(i)-'0';
            for (char c:dic[index].toCharArray()) {
                stringBuffer.append(c);
                backTrack(stringBuffer,digits,i+1);
                //取消选择
                stringBuffer.deleteCharAt(stringBuffer.length()-1);
            }
        }
    }

}
