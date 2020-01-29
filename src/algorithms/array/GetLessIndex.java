package algorithms.array;

public class GetLessIndex {
    public static void main(String[] args){
        GetLessIndex o = new GetLessIndex();
        int[] arr = {3,2,1,4,5};
        System.out.print(o.myGetLessIndex(arr));
    }

    public int myGetLessIndex(int[] arr){
        if (arr == null || arr.length == 2){
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]){
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]){
            return arr.length - 1;
        }
        int l = 1;
        int r = arr.length - 2;
        int mid = 0;
        while (l < r){
            mid = (l + r) >> 1;
            if (arr[mid] > arr[mid - 1]){
                r = mid - 1;
            } else if (arr[mid] > arr[mid + 1]){
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}
