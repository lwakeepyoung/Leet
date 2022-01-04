package other;

public class Demo26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast<nums.length){
            if(nums[fast]!=nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
