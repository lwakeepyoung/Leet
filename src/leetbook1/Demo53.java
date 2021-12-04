package leetbook1;

public class Demo53 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int num: nums) {
            sum = Math.max(sum+num,num);
            max = Math.max(max,sum);
        }
        return sum;
    }
}
