package algorithms.array;

/**
 * 需要排序的最短子数组长度
 * input:[1,5,3,4,2,6,7]
 * output:4
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class GetMinLength {
    public static void main(String[] args){
        GetMinLength o = new GetMinLength();
        int[] arr = {1,5,3,4,2,6,7};
        System.out.print(o.myGetMinlength(arr));
    }

    public int myGetMinlength(int[] arr){
        if (arr == null || arr.length < 2) return 0;
        int min = arr[arr.length - 1];
        int kmin = -1;
        int max = arr[0];
        int kmax = -1;
        for (int i = 1; i < arr.length; i++){
            if (max > arr[i]){
                kmax = i;
            } else {
                max = arr[i];
            }
        }
        if (kmax == -1) return 0;
        for (int i = arr.length - 2; i >= 0; i--){
            if (min < arr[i]){
                kmin = i;
            }else{
                min = arr[i];
            }
        }
        return kmax - kmin + 1;
    }
}
