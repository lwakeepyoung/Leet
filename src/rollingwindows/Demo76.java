package rollingwindows;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lwa
 * @Date: 2021/12/29 21:11
 */
public class Demo76 {
    public static String minWindow(String s, String t) {
        Map<Character,Integer> need =new HashMap();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> window = new HashMap();
        int left = 0;
        int right = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0)+1);
            while (check(need,window)){
                if(min > right-left){
                    start = left;
                    min = right-left;
                }
                char removeChar = s.charAt(left);
                left++;
                window.put(removeChar,window.getOrDefault(removeChar,0)-1);
            }
        }
        if(min==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+min);
    }

    private static boolean check(Map<Character,Integer> need,Map<Character,Integer> window){
        boolean f = true;
        for (Map.Entry<Character,Integer> entry:
                need.entrySet()) {
            if(window.getOrDefault(entry.getKey(),0)<entry.getValue()){
                return false;
            }
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","BC"));
        System.out.println("ADOBECODEBANC".substring(3,6));
    }



}
