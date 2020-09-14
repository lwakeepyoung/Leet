//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组
// 👍 671 👎 0

/**
 * 1.每次移动一位，移动k次； for
 * 2.新建一个数组，将移动后度数放在新数组中
 * 3.环状替换
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Demo189 {
    /**
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k% nums.length;
        int count=0;
        for (int start = 0; count < nums.length; start++) {
            int curr = start;
            int pre = nums[curr];
            do {
               int next = (curr+k) %nums.length;
               int temp = nums[next];
               nums[next] = pre;
               pre = temp;
               curr = next;
               count++;
            }while (start!=curr);
        }

    }

    /**
     * 一次移动一位，移动k次
     * O(n*k)
     * O(1)
     * @param nums
     * @param k
     */
//    public void rotate(int[] nums, int k) {
//        for (int i = 0; i < k; i++) {
//            int temp = nums[nums.length-1];
//            for (int j = nums.length-1; j > 0 ; j--) {
//                nums[j] = nums[j-1];
//            }
//            nums[0] = temp;
//        }
//    }

    /**
     * 新建一个数组，将移动后度数放在新数组中
     * O(n)
     * O(n)
     * @param nums
     * @param k
     */
//    public void rotate(int[] nums, int k) {
//        int[] arrays = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            arrays[(i+k)% nums.length] = nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = arrays[i];
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
