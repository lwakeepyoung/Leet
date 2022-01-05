package other;

public class Demo283 {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = slow+1;
        while (fast<nums.length){
            if(nums[fast]!=0){
                nums[slow] = nums[fast];
                slow++;
            }
            nums[fast]=0;
            fast++;
        }
    }
}
