package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lwa
 * @Date: 2022/2/28 20:33
 */
public class Demo3_error {
    public int lengthOfLongestSubstring(String s) {
       int left = 0;
       int right = 0;
       int max = 0;
       Map<Character,Integer> map = new HashMap();
       while (right<s.length()){
            Character c = s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);
            right++;
           while (map.getOrDefault(c,0)>1){
               char removeChar = s.charAt(left);
               map.put(removeChar,map.getOrDefault(removeChar,0)-1);
               left++;
           }
           max = Math.max(max,right-left);
       }
       return max;
    }
}
