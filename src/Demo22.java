//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
//
// Related Topics 字符串 回溯算法
// 👍 1283 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Demo22 {
    private List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
       generate(0,0,n,"");
        return null;
    }

    public void generate(int left,int right,int n, String s){
        if(left==n && right==n){
            result.add(s);
        }
        if(left<n){
            generate(left+1,right,n,s+"(");
        }
        if(right<left){
            generate(left,right+1,n,s+")");
        }
    }

    public static void main(String[] args) {
        new Demo22().generateParenthesis(3);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
