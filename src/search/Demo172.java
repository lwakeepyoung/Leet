package search;

public class Demo172 {
    public int trailingZeroes(int n) {
        int count = 0;
        int divider = 5;
        while (divider<n){
            count += n/divider;
            divider *= 5;
        }
        return count;
    }
}
