//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//
//
// 示例 2:
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
//
//
//
// 说明：
//
//
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
// 我们可以不考虑输出结果的顺序。
//
//
// 进阶：
//
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
// Related Topics 排序 哈希表 双指针 二分查找
// 👍 384 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Demo350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i],map1.getOrDefault(nums1[i],0)+1);
        }
        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i],map2.getOrDefault(nums2[i],0)+1);
        }
        Map<Integer,Integer> maxMap = map1.size()>map2.size()?map1:map2;
        Map<Integer,Integer> minMap = map1.size()<=map2.size()?map1:map2;
        List<Integer> list = new ArrayList();
        for (Map.Entry entry:maxMap.entrySet()) {
            int value1 = maxMap.get(entry.getKey());
            int value2 = minMap.getOrDefault(entry.getKey(),0);
            int min = value1<value2?value1:value2;
            if(min!=0){
                for (int i = 0; i < min; i++) {
                    list.add ((int) entry.getKey());
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        new Demo350().intersect(nums1,nums2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
