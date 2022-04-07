package sort;

import java.util.Random;

public class QuickSort {
    public static void sort(int[] nums){
        shuffle(nums);
        sort(nums,0,nums.length-1);
    }

    private static void shuffle(int[] nums) {
        Random random = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int r = i+random.nextInt(n-i);
            swap(nums,i,r);
        }
    }

    private static void swap(int[] nums, int i, int r) {
        int temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
    }

    private static void sort(int[] nums, int lo, int hi) {
        if(lo>=hi){
            return;
        }
        int p = partition(nums,lo,hi);
        sort(nums,lo,p-1);
        sort(nums,lo,p+1);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int l = lo+1;
        int r = hi;
        while (l<=r){
            while (l<hi && nums[l]<=pivot){
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


}
