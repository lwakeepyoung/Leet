package hot100;

public class Demo33 {
    public int search(int[] nums, int target) {
        int n = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]>nums[i+1]){
                n = i;
            }
        }
        int reslut1 = search(nums,0,n,target);
        int result2 = search(nums,n+1,nums.length-1,target);
        return reslut1>result2?reslut1:result2;
    }

    public int search(int[] nums,int l,int r,int target){
        while (l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testData = new int[]{4,5,6,7,8,9,0,1,2,3};
        int result = new Demo33().search(testData,10);
        System.out.println(result);
    }
}
