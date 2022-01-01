package windows;

public class Demo76_2 {
    public static String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] window = new int[128];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need[c]++;
        }
        int count = 0;
        for (int i = 0; i < need.length; i++) {
            if(need[i]>0){
                count++;
            }
        }
        int left = 0;
        int right = 0 ;
        int min = Integer.MAX_VALUE;
        int start = 0;
        //满足条件的数量
        int valid = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need[c]>0){
                window[c]++;
                if(window[c] == need[c]){
                    valid++;
                }
            }
            //判断是否收紧窗口
            while (valid==count){
                if(min>right-left){
                    min=right-left;
                    start = left;
                }
                char removeChar = s.charAt(left);
                left++;
                if(need[removeChar]>0){
                    if(window[removeChar] == need[removeChar]){
                        valid--;
                    }
                    window[removeChar]--;
                }
            }
        }
        return min==Integer.MAX_VALUE?"":s.substring(start,start+min);
    }


    public static void main(String[] args) {
        System.out.println(minWindow("aa","aa"));
    }
}
