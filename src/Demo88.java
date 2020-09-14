//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针
// 👍 602 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Demo88 {
    /**
     * 两个指针比较
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m-1;
        int nIndex = n-1;
        int index = nums1.length-1;
        while (mIndex>=0&&nIndex>=0){
            if(nums1[mIndex]>nums2[nIndex]){
                nums1[index--] = nums1[mIndex--];
            }else {
                nums1[index--] = nums2[nIndex--];
            }
        }

    }

    public static void main(String[] args) {
        int[] as = new int[]{0};
        int[] as2 = new int[]{1};
        new Demo88().merge(as,0,as2,1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
