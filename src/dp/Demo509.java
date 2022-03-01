package dp;

import java.util.HashMap;
import java.util.Map;

public class Demo509 {

    private Map<Integer,Integer> map = new HashMap();

    public int fib(int n) {
        if(n<2){
            return n;
        }
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }

//    public int fib(int n) {
//        if(n==0){
//            return 0;
//        }
//        if(n==1){
//            return 1;
//        }
//        return fib(n-1)+fib(n-2);
//    }
}
