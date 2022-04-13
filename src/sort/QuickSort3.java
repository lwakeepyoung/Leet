package sort;

import java.util.Random;

public class QuickSort3 {
    public void sort(int[] nums){
        shuffle(nums);
        sort(nums,0,nums.length-1);
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int r = random.nextInt(n-1);
            swap(nums,i,r);
        }
    }

    private void sort(int[] nums, int lo, int hi) {
        if(lo>hi){
            return;
        }
        int p = partition(nums,lo,hi);
        sort(nums,0,p-1);
        sort(nums,p+1,hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int p = nums[lo];
        int l = lo+1;
        int r = hi;
        while (l<=r){
            while (l<hi && nums[l]<p){
                l++;
            }
            while (r>lo && nums[r]>p){
                r--;
            }
            if(l>=r){
                break;
            }
            swap(nums,l,r);
        }
        swap(nums,lo,r);
        return r;
    }

    public void swap(int[] nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
