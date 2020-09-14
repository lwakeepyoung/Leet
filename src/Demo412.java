//写一个程序，输出从 1 到 n 数字的字符串表示。
//
// 1. 如果 n 是3的倍数，输出“Fizz”；
//
// 2. 如果 n 是5的倍数，输出“Buzz”；
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
//
// 示例：
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
//
// 👍 70 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Demo412 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        Map<Integer,String> map = new HashMap<>();
        map.put(3,"Fizz");
        map.put(5,"Buzz");
        for (int i = 1; i <=n ; i++) {
            String result = "";
            for (Integer key : map.keySet()){
                if(i%key==0){
                    result+=map.get(key);
                }
            }
            if(result.equals("")){
                result += Integer.toString(i);
            }
            list.add(result);
        }
        return list;

    }

    public static void main(String[] args) {
        new Demo412().fizzBuzz(17);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
