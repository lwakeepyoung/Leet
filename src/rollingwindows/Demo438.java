package rollingwindows;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lwa
 * @Date: 2022/1/2 17:19
 */
public class Demo438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] need = new int[128];
        int[] window = new int[128];
        for(char c : p.toCharArray()){
            need[c]++;
        }
        int diffChar = 0;
        for(int i : need){
            if(i>0){
                diffChar++;
            }
        }
        int left = 0;
        int right = 0;
        int vaild = 0;
        List<Integer> result = new ArrayList();
        while(right<s.length()){
            char c = s.charAt(right);
            right++;
            if(need[c]>0){
                window[c]++;
                if(need[c]==window[c]){
                    vaild++;
                }
            }
            while(vaild==diffChar){
                if(vaild==diffChar && right-left == p.length()){
                    result.add(left);
                }
                char removeChar = s.charAt(left);
                left++;
                if(need[removeChar]>0){
                    if(need[removeChar]==window[removeChar]){
                        vaild--;
                    }
                    window[removeChar]--;
                }
            }
        }
        return result;
    }
}
