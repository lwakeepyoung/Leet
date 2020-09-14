//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
//
// 示例：
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
//
//
// 提示：
//
//
// 0 <= len(arr) <= 100000
// 0 <= k <= min(100000, len(arr))
//
// Related Topics 堆 排序 分治算法
// 👍 24 👎 0


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Demo_1714 {
    /**
     * 排序，去前k个数
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(o -> o));
        for (int i = 0; i < arr.length; i++) {
            if(queue.size()==k){
            }
            queue.offer(arr[i]);
        }

        return null;
    }
//    public int[] smallestK(int[] arr, int k) {
//        if(arr==null){
//            return arr;
//        }
//        Arrays.sort(arr);
//        int[] result = new int[k];
//        for (int i = 0; i < k; i++) {
//            result[i] = arr[i];
//        }
//        return result;
//    }

    public static void main(String[] args) {
        int[] a= new int[]{1,3,2,4,5,6,7};
        new Demo_1714().smallestK(a,3);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
