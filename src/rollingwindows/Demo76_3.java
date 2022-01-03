package rollingwindows;

/**
 * @Author: lwa
 * @Date: 2022/1/1 17:39
 */
public class Demo76_3 {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] window = new int[128];
        for(char c : t.toCharArray()){
            need[c]++;
        }
        //计算有多少不同的字符
        int charCount = 0;
        for(int i: need){
            if(i>0){
                charCount++;
            }
        }
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int valid = 0;
        while(right < s.length()){
            char addChar = s.charAt(right);
            right++;
            if(need[addChar]>0){
                window[addChar]++;
                if(window[addChar] == need[addChar]){
                    valid++;
                }
            }
            //所有char都满足条件 移动左窗口
            while(valid == charCount){
                if(min> right - left){
                    min = right - left;
                    start = left;
                }

                char removeChar = s.charAt(left);
                left++;
                //删除的是需要判断的char，则窗口更新
                if(need[removeChar]>0){
                    if(need[removeChar]==window[removeChar]){
                        valid--;
                    }
                    window[removeChar]--;
                }
            }
        }
        return min == Integer.MAX_VALUE?"":s.substring(start,start+min);
    }
}
