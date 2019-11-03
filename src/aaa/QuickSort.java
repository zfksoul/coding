package aaa;

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
        arr = o.myQuickSort1(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public int[] myQuickSort2(int[] arr, int l, int r) {
        if (l < r) {
            int i = l - 1;
            int j = r + 1;
            int mid = (l + r) >> 1;
            while (i < j) {
                do {
                    j--;
                }while (arr[j] > arr[mid]);
                do {
                    i++;
                }while(arr[i]<arr[mid]);
                if (i < j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }else {
                    myQuickSort2(arr,l,j);
                    myQuickSort2(arr,j+1,r);
                }
            }
        }
        return arr;
    }
    public int[] myQuickSort1(int[] arr, int l, int r) {
        if (l < r) {
            int partionIndex = partition(arr, l, r);
            myQuickSort1(arr, l, partionIndex-1);
            myQuickSort1(arr, partionIndex+1, r);
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

