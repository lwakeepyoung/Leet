package hot100;

public class Demo11 {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;

        while (l<r){
            int minHeight = Math.min(height[l],height[r]);
            int area = (r-l)*minHeight;
            max = Math.max(area,max);
            if(height[l]<height[r]){
                l++;
            }else {
                r--;
            }
        }
        return max;
    }
}
