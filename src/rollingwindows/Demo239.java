package rollingwindows;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: lwa
 * @Date: 2022/1/2 19:28
 */

public class Demo239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int[] window = new int[k];
        int[] result = new int[nums.length-k+1];
        int index = 0;
        while(right<nums.length){
            int num = nums[right];
            window[right-left] = num;
            right++;
            if(right-left==k){
                int max = getMax(window);
                result[index++] = max;
                left++;
                update(window);
            }
        }
        return result;
    }

    public static int getMax(int[] window){
        int max = Integer.MIN_VALUE;
        for(int i:window){
            if(max<i){
                max = i;
            }
        }
        return max;
    }

    public static void update(int[] window){
        for (int i = 0; i < window.length-1; i++) {
            window[i] = window[i+1];
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(ints,3);
    }
}
