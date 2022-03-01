package rollingwindows;

import java.util.HashMap;
import java.util.Map;

public class Demo3_2 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        while (right<s.length()){
            Character addChar = s.charAt(right);
            map.put(addChar,map.getOrDefault(addChar,0)+1);
            right++;
            while (map.getOrDefault(addChar,0)>1){
                Character removeChar = s.charAt(left);
                map.put(removeChar,map.getOrDefault(removeChar,0)-1);
                left++;
            }
            max = Math.max(max,right-left);
        }
        return max;
    }
}
