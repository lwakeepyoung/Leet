package stack;

/**
 * @Author: lwa
 * @Date: 2022/1/17 21:53
 */
public class Demo921_2 {
    public int minAddToMakeValid(String s) {
       int res = 0;
       int need_right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('){
                need_right++;
            }
            if(c==')'){
                need_right--;
                if(need_right==-1){
                    need_right=0;
                    res++;
                }
            }
        }
        return res+need_right;
    }
}
