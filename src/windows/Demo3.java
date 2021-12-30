package windows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Demo3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            map.put(c,map.getOrDefault(c,0)+1);
            //判断是否收缩窗口
            while (map.getOrDefault(c,0)>1){
                char removeChar = s.charAt(left);
                left++;
                map.put(removeChar,map.get(removeChar)-1);
            }
            max = Math.max(max,right-left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
