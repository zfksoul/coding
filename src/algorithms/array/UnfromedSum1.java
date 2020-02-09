package algorithms.array;

/**
 * 整数数组包含1，求最小不可组成和
 * 排序，时间复杂度O(nlogn)
 */
public class UnfromedSum1 {
    public static void main(String[] args){
        UnfromedSum1 o = new UnfromedSum1();
        int[] arr = {2,3,5,4,6,1,9,11};
        System.out.println(o.mySum(arr));
    }
    public int mySum1(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        quickSort(arr, 0, arr.length - 1);
        int r = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > r + 1){
                return r + 1;
            } else {
                r += arr[i];
            }
        }
        return r + 1;
    }
    public int mySum(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int r = 1;//表示1~r都可以被组成
        quickSort(arr, 0, arr.length - 1);
        for (int i = 1; i < arr.length; i++){
            if (arr[i] <= r + 1){
                r += arr[i];
            } else {
                return r + 1;
            }
        }
        return r + 1;
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l < r){
            int pivot = partition(arr, l, r);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, r);
        }
    }

    private int partition(int[] arr, int l, int r) {
        int rand = (int) (l + Math.random() * (r - l + 1));
        swap(arr, l, rand);
        int p = l + 1;
        for (int i = p; i <= r; i++){
            if (arr[i] <= arr[l]){
                swap(arr, p++, i);
            }
        }
        swap(arr, l, p - 1);
        return p - 1;
    }

    private void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
