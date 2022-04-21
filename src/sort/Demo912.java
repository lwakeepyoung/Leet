package sort;

public class Demo912 {

    private int[] temp;

    public void sort(int[] nums) {

    }

    public void sort(int[] nums,int lo,int hi){
        if(lo==hi){
            //单个元素不用排序
            return;
        }

        int mid = lo+(hi-lo)/2;
        sort(nums,lo,mid);
        sort(nums,mid+1,hi);
        merge(nums,lo,mid,hi);
    }

    // 将 nums[lo..mid] 和 nums[mid+1..hi] 这两个有序数组合并成一个有序数组
    private void merge(int[] nums, int lo, int mid, int hi) {
        // 先把 nums[lo..hi] 复制到辅助数组中
        // 以便合并后的结果能够直接存入 nums
    }
}