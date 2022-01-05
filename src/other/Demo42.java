package other;

import java.util.Map;

public class Demo42 {

    /**
     * water[i] = min(
     * l_max(height[0...i]),
     * r_max(height[e.....end])
     * )-height[i];
     *
     * @param height
     * 暴力法
     * @return
     */
    public static int trap(int[] height) {
        int res=0;
        int size = height.length;
        for (int i = 0; i < size; i++) {
            //找出i右侧最高的值
            int r_max = 0;
            for (int j = i; j < size; j++) {
                int value = height[j];
                if(r_max<value){
                    r_max = value;
                }
            }
            int l_max = 0;
            //找出i左侧最高的值
            for (int j = i; j >= 0; j--) {
                int value = height[j];
                if(l_max<value){
                    l_max = value;
                }
            }
            int min = Math.min(l_max,r_max);
            res += min - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        //int[] ints = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] ints = new int[]{4,2,0,3,2,5};
        System.out.println(trap(ints));
    }
}
