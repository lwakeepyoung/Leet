//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划
// 👍 1202 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Demo70 {

    private Map<Integer,Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        int result = 0;
        if (n==0){
            result = 0;
        }else if(n==1){
            result = 1;
        }else if(n==2){
            result = 2;
        }else {
            int temp1 = 0;
            if(map.containsKey(n-1)){
                temp1 = map.get(n-1);
            }else {
                temp1 = climbStairs(n-1);
            }
            int temp2 = 0;
            if(map.containsKey(n-2)){
                temp2 = map.get(n-2);
            }else {
                temp2 = climbStairs(n-2);
            }
            result = temp1+temp2;
        }
        map.put(n,result);
        return result;
    }

//    public int climbStairs(int n) {
//        int first = 0;
//        int second = 0;
//        int result = 1;
//        for (int i = 0; i < n; i++) {
//            first = second;
//            second = result;
//            result = first+second;
//        }
//        return result;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

