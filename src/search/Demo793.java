package search;

public class Demo793 {

    public int left_bound(Long target){
        long left = 0;
        long right = Long.MAX_VALUE;
        while (left<=right){
            long mid = left+ (right-left)/2;
            if(trailingZeroes(mid)<=target){
                
            }else {

            }
        }
    }


    public long trailingZeroes(long n){
        int count = 0;
        int divider = 5;
        while (divider<n){
            count += n/divider;
            divider *= 5;
        }
        return count;
    }
}
