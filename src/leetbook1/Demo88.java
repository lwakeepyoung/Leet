package leetbook1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new ArrayList();
        if(m==0){
            System.arraycopy(nums2,0,nums1,0,n);
        }
        int nums1Index = m-1;
        int nums2Index = n-1;
        int index = m+n-1;
        while(index>=0){
            if(nums1Index<0){
                nums1[index--] = nums2[nums2Index--];
            }else if(nums2Index<0){
                nums1[index--] = nums1[nums1Index--];
            }else{
                int value1= nums1[nums1Index];
                int value2= nums2[nums2Index];
                if(value1>value2){
                    nums1[index--]=value1;
                    nums1Index--;
                }else{
                    nums1[index--]=value2;
                    nums2Index--;
                }
            }
        }
        return;
    }
}
