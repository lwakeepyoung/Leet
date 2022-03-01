package hot100;

/**
 * @Author: lwa
 * @Date: 2022/2/28 21:19
 */
public class Demo5_error {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = help(s,i,i);
            String s2 = help(s,i,i+1);
            result = result.length()>s1.length()?result:s1;
            result = result.length()>s2.length()?result:s2;
        }
        return result;
    }

    public String help(String s,int left,int right){
        while (right < s.length()&& left>=0 && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left,right+1);
    }
}
