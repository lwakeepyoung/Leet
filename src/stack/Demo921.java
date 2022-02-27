package stack;

/**
 * @Author: lwa
 * @Date: 2022/1/17 21:47
 */
public class Demo921 {
    public int minAddToMakeValid(String s) {
        int res =0;
        int need = 0 ;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if('(' == c){
                need++;
            }
            if(')' == c) {
                need--;
                //如果=-1表示确实一个（
                if(need == -1){
                    need = 0;
                    res++;
                }
            }
        }
        return res+need;
    }
}
