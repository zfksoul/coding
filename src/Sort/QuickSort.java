package Sort;

/**
* 
*
* @author zfk
* @date 2019年10月28日 下午11:00:34 
* 
*/
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 2, 5, 4, 6, 5, 9, 8, 7, 10, 11 };
        QuickSort o = new QuickSort();
        arr = o.myQuickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public int[] myQuickSort(int[] arr, int l, int r) {
        if (l < r) {
            int partionIndex = partition(arr, l, r);
            myQuickSort(arr, l, partionIndex-1);
            myQuickSort(arr, partionIndex+1, r);
        }
        return arr;
    }
    public int partition(int[] arr, int l ,int r) {
        int pivot = l;
        int p = l + 1;
        for (int i = p; i <= r; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, p);
                p++;
            }
        }
        swap(arr, pivot, p-1);
        return p-1;
    }
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

}
