package no2;

/**
 * @Author: lwa
 * @Date: 2021/11/8 23:17
 */
public class Demo704 {
    private int result = -1;

    public int search(int[] nums, int target) {

        s(nums,0,nums.length-1,target);
        return result;
    }
    public void s(int[] nums,int l,int r,int target){
        if(l>r) {
            return;
        }
        int mid = (r-l)/2+l;
        int value = nums[mid];
        if(value<target){
            s(nums,mid+1,r,target);
        }else if(value==target){
            result = mid;
            return;
        }else{
            s(nums,l,mid-1,target);
        }

    }

    public static void main(String[] args) {
        int[] nums  = new int[]{-1,0,3,5,9,12};
        int target = 9;
        new Demo704().search(nums,target);
    }
}
