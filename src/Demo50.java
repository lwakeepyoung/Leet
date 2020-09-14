//实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//
// 示例 1:
//
// 输入: 2.00000, 10
//输出: 1024.00000
//
//
// 示例 2:
//
// 输入: 2.10000, 3
//输出: 9.26100
//
//
// 示例 3:
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25
//
// 说明:
//
//
// -100.0 < x < 100.0
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
//
// Related Topics 数学 二分查找
// 👍 491 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Demo50 {

    public double myPow(double x,int n){
        return 0;
    }


//    /**
//     * 递归
//     * O(log n)
//     * O(log n)
//     * @param x
//     * @param n
//     * @return
//     */
//    public double myPow(double x, int n) {
//        return n>0?quickMul(x,n):1/quickMul(x,n);
//    }
//
//    public double quickMul(double x, long n){
//        double result = 0;
//        if(n==0){
//            return 1;
//        }
//        double y = quickMul(x,n/2);
//
//        if(n%2==0){
//            result = y*y;
//        }else {
//            result = y*y*x;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        new Demo50().myPow(2,10);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
