package algorithms.array;

public class FindMinFromRotateArray {
    public static void main(String[] args){
        FindMinFromRotateArray o = new FindMinFromRotateArray();
        int[] arr = {3,4,5,1,2};
        System.out.println(o.minNumberInRotateArray(arr));
    }
    public int minNumberInRotateArray(int [] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l < r){
            int mid = (l + r) >> 1;
            if (arr[mid] < arr[arr.length - 1]){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return arr[l];
    }

}
