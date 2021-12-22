package search;

public class Demo34 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left_bound(nums,target),right_bound(nums,target)};
    }

    //[left,right)
    public int left_bound(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                right = mid-1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }
        }
        if(left>=nums.length || nums[left]!=target){
            return -1;
        }
        return left;
    }
    //(left,right]
    public int right_bound(int[] nums, int target){
        if(nums.length==0){
            return -1;
        }
        int left = 0 ;
        int right = nums.length;
        while (left < right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }
        }
        if (left==0){
            return -1;
        }
        return nums[left-1]==target?left-1:-1;
    }


}
