package search;

public class Demo875 {

    public int minEatingSpeed(int[] piles, int H) {
        int left = 0;
        int right = 10_000_000_00+1;
        while (left<right){
            int mid = left+ (right - left)/2;
            if(function(piles,mid)<=H){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    int function(int[] piles,int x){
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            //计算需要吃几小时香蕉
            hours += piles[i]/x;
            if (piles[i]%x>0){
                hours++;
            }
        }
        return hours;
    }
}
