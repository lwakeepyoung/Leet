package other;

/**
 * @Author: lwa
 * @Date: 2022/1/8 16:57
 */
public class Demo42_5 {
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int l_max = 0;
        int r_max = 0;
        int res =0;
        while (left<right){
            l_max = Math.max(l_max,height[left]);
            r_max = Math.max(r_max,height[right]);
            if(l_max<r_max){
                res += l_max-height[left];
                left++;
            }else {
                res+= r_max-height[right];
                right--;
            }
        }
        return res;
    }
}
