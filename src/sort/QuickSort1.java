package sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月28日 下午11:00:34
 * 
 */
public class QuickSort1 {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 2, 5, 4, 6, 5, 9, 8, 7, 10, 11 };
        QuickSort1 o = new QuickSort1();
        o.myQuickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }



    public int[] myQuickSort(int[] arr, int l, int r) {
        if (l < r){
            int pivot = partition(arr, l, r);
            myQuickSort(arr, l, pivot - 1);
            myQuickSort(arr, pivot + 1, r);
        }
        return arr;
    }

    private int partition(int[] arr, int l, int r) {
        int ran = l + (int)Math.random() * (r - l + 1);
        swap(arr, l, ran);
        int pivot = l;
        int p = pivot + 1;
        for (int i = p; i <= r; i++){
            if (arr[i] < arr[pivot]){
                swap(arr, i, p);
                p++;
            }
        }
        swap(arr, pivot, p - 1);
        return p - 1;
    }

    private void swap(int[] arr, int l, int r) {
        if (l == r){
            return;
        }
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


}
