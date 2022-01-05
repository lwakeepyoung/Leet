package other;

public class Demo11 {
    public int maxArea(int[] height) {
        int left = 0 ;
        int right = 0;
        int result = 0;
        while (left < right){
            int min = Math.min(height[left],height[right]);
            result = Math.max(result,min *(right-left));
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return result;
    }
}
