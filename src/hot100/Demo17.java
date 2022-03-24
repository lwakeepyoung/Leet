package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lwa
 * @Date: 2022/3/22 20:56
 */
public class Demo17 {

    private List<String> result = new ArrayList<>();

    private String[] dic = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return result;
        }
        StringBuffer stringBuffer = new StringBuffer();
        backTrack(stringBuffer,digits,0);
        return result;
    }

    public void backTrack(StringBuffer stringBuffer,String digits,int start){
        if(stringBuffer.length()==digits.length()){
            result.add(stringBuffer.toString());
            return;
        }
        char[] arrays = digits.toCharArray();
        for (int i = start; i < arrays.length; i++) {
            int index = arrays[i]-'0';
            char[] cs = dic[index].toCharArray();
            for (int j = 0; j < cs.length; j++) {
                stringBuffer.append(cs[j]);
                backTrack(stringBuffer,digits,i+1);
                stringBuffer.deleteCharAt(stringBuffer.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        new Demo17().letterCombinations("23");
    }
}
