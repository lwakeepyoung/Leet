public class Demo852 {
//    public int peakIndexInMountainArray(int[] arr) {
//        int result = 0;
//        for (int i = 1; i < arr.length-1; i++) {
//            if(arr[i]>arr[i-1]&& arr[i]>arr[i+1]){
//                result = i;
//            }
//        }
//        return result;
//    }

    public int peakIndexInMountainArray(int[] arr) {
        int l = 1;
        int r = arr.length-2;
        while (l<r){
           int mid = (l+r)/2;
           if(arr[mid]>arr[mid+1]&&arr[mid]>arr[mid-1]){
               return mid;
           }else if (arr[mid]<arr[mid+1]&&arr[mid]>arr[mid-1]){
                l = mid+1;
           }else if (arr[mid]>arr[mid+1]&&arr[mid]<arr[mid-1]){
                r = mid-1;
           }
        }
        return l;
    }
}
