import sort.QuickSort2;

import java.util.Random;

public class Demo912 {
    public int[] sortArray(int[] nums) {
        shuffle(nums);
        sort(nums,0,nums.length-1);
        return nums;
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int r = i+random.nextInt(n-i);
            swap(nums,i,r);
        }
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(nums,lo,hi);
        sort(nums,lo,p-1);
        sort(nums,p+1,hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];

        int l = lo+1;
        int r = hi;
        //[l,pivot) (pivot,r]
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

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        new Demo912().sortArray(new int[]{5,2,3,1});
    }

}
