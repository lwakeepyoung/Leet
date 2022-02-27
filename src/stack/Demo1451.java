package stack;

/**
 * @Author: lwa
 * @Date: 2022/1/17 22:02
 */
public class Demo1451 {
    public int minInsertions(String s) {
        int res = 0;
        int needRight = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('){
                needRight +=2;
                if(needRight%2==1){
                    res++;
                    needRight--;
                }
            }

            if(c==')'){
                needRight--;
                if(needRight==-1){
                    res++;
                    needRight=1;
                }
            }
        }
        return res+needRight;
    }
}
