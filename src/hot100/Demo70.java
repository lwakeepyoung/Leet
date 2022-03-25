package hot100;

public class Demo70 {

    public int climbStairs(int n) {
        int first = 0;
        int second = 0;
        int result = 1;
        for (int i = 1; i < n; ++i) {
            first = second;
            second = result;
            result = first+second;
        }
        return result;
    }


}
