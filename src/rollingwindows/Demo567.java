package rollingwindows;

/**
 * @Author: lwa
 * @Date: 2022/1/2 17:51
 */
public class Demo567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[128];
        int[] window = new int[128];
        for(char c : s1.toCharArray()){
            need[c]++;
        }
        int diffCount = 0;
        for(int i: need){
            if(i>0){
                diffCount++;
            }
        }
        int left = 0;
        int right = 0;
        int vaild = 0;
        while(right<s2.length()){
            char c = s2.charAt(right);
            right++;
            if(need[c]>0){
                window[c]++;
                if(window[c]==need[c]){
                    vaild++;
                }
            }
            while(vaild == diffCount){
                if(right-left == s1.length()){
                    return true;
                }
                char removeChar = s2.charAt(left);
                left++;
                if(need[removeChar]>0){
                    if(window[removeChar]==need[removeChar]){
                        vaild--;
                    }
                    window[removeChar]--;
                }
            }
        }
        return false;
    }
}
