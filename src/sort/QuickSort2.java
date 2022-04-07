package sort;

import java.util.Random;

public class QuickSort2 {

    private static void sort(int[] nums){
        shuffle(nums);
        sort(nums,0,nums.length-1);
    }

    private static void shuffle(int[] nums) {
        Random random = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int r = random.nextInt(n-1);
            swap(nums,i,r);
        }
    }

    private static void sort(int[] nums, int lo, int hi) {
        int p = partition(nums,lo,hi);
        sort(nums,lo,p-1);
        sort(nums,p+1,hi);

    }

    private static int partition(int[] nums, int lo, int hi) {

        int pivot = nums[lo];

        int l = lo+1;
        int r = hi;
        while (l<r){
            while (l<hi && nums[l]<pivot){
                l++;
            }
            while (r>lo && nums[r]>pivot){
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

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
