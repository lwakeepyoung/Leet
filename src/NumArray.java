/**
 * @Author: lwa
 * @Date: 2022/1/14 20:51
 */
public class NumArray {

    int[] sumNums;

    public NumArray(int[] nums) {
        sumNums = new int[nums.length+1];
        for (int i = 1; i < sumNums.length; i++) {
            sumNums[i] = sumNums[i-1]+nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return sumNums[right+1]-sumNums[left];
    }
}
