package search;

public class Demo1011 {
    public static int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < weights.length; i++) {
            right += weights[i];
        }
        while (left<right){
            int mid = left+(right-left)/2;
            if (f(weights,mid)<=days) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    //f(x) 当运载能力为x时需要几天能送完货物
    //单调递减函数
    public static int f(int[] weights,int x){
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            int cap = x;
            while (i < weights.length){
                if(cap < weights[i]){
                    break;
                }else {
                    cap -=weights[i];
                    i++;
                }
            }
            days++;
        }
        return days;
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(weights,5));
    }
}
