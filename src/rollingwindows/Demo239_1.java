package rollingwindows;

/**
 * @Author: lwa
 * @Date: 2022/1/2 21:19
 */
public class Demo239_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int[] arr = new int[n - k + 1];
        int l = 0, r = k - 1, prex = -1;
        while (r < n) {
            //最大值仍在滑动窗口中
            if (l <= prex) {
                //比较新滑入的值和目前的最大值哪个大，如果新滑入的大，则更新最大值与prex坐标，反之结束if语句
                if (nums[r] >= max) {
                    max = nums[r];
                    prex = r;
                }
            }
            //最大值不在滑动窗口了，但是新滑入的值大于等于最大值（减一是避免数组刚开始时就直接错误得到的滑动窗口最右端的值作为最大值）
            else if (nums[r] >= max - 1) {
                max = nums[r];
                prex = r;
            }
            //最大值不在滑动窗口，但是滑动窗口最左端的值大于等于最大值（减一是避免数组刚开始时就直接错误得到的滑动窗口最左端的值作为最大值）
            else if (nums[l] >= max - 1) {
                max = nums[l];
                prex = l;
            } else {
                max = Integer.MIN_VALUE;
                for (int i = l; i <= r; i++) {
                    if (nums[i] >= max) {
                        max = nums[i];
                        prex = i;
                    }
                }
            }
            arr[l] = max;
            l++;
            r++;
        }
        return arr;
    }
}
