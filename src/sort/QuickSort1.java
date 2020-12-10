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
        o.myQuickSort2(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }



    public int[] myQuickSort1(int[] arr, int l, int r) {
        if (l < r){
            int pivotIndex = partition1(arr, l, r);
            myQuickSort1(arr, l, pivotIndex - 1);
            myQuickSort1(arr, pivotIndex + 1, r);
        }
        return arr;
    }

    private int partition1(int[] arr, int l, int r) {
        int ran = l + (int) (Math.random() * (r - l + 1));
        swap(arr, l, ran);
        int pivot = arr[l];
        int p = l + 1;
        for (int i = p; i <= r; i++){
            if (arr[i] < pivot){
                swap(arr, i, p++);
            }
        }
        swap(arr, l, p - 1);
        return p - 1;
    }
    public int[] myQuickSort2(int[] arr, int l, int r) {
        if (l < r){
            int[] pivotIndex = partition2(arr, l, r);
            myQuickSort2(arr, l, pivotIndex[0] - 1);
            myQuickSort2(arr, pivotIndex[1] + 1, r);
        }
        return arr;
    }
    private int[] partition2(int[] arr, int l, int r) {
        int ran = (int) (l + (Math.random() * (r - l + 1)));
        int pivot = arr[ran];
        swap(arr, l, ran);
        int p = l + 1;
        int i = p;
        int q = r;
        while (i <= q){
            if (arr[i] < pivot){
                swap(arr, i++, p++);
            } else if (arr[i] > pivot){
                swap(arr, i, q--);
            } else {
                i++;
            }
        }
        swap(arr, l, p - 1);
        return new int[]{p - 1, q};
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
