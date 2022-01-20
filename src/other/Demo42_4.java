package other;

/**
 * @Author: lwa
 * @Date: 2022/1/8 16:29
 */

/**
 * water[i] = min(left[height[0...i]],right[height[i...end]])- height[i]
 * 暴力法
 */
public class Demo42_4 {
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            //找出i左边最高的
            int l_max = 0;
            for (int j = left; j < i; j++) {
                l_max = Math.max(l_max,height[j]);
            }
            //找出i右边最高的
            int r_max = 0;
            for (int j = right ; j>i ; j--) {
                r_max = Math.max(r_max,height[j]);
            }
            int water = Math.min(l_max,r_max)-height[i];
            if(water>0){
                res+=water;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //int[] ints = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] ints = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(ints));
    }
}
