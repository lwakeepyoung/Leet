public class Demo11 {
    public int maxArea(int[] height) {
        int max = 0;
        int left=0;
        int right=height.length-1;
        while (left != right){
            int min = Math.min(height[left],height[right]);
            int temp = min*(right-left);
            if(temp>max){
                max = temp;
            }
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }

        }
        return max;
    }
}
