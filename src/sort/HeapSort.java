package sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月29日 下午8:52:27
 * 
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 1,22, 3, 2, 5, 4, 6, 5, 9, 8, 7, 10, 11 };
        HeapSort o = new HeapSort();
        arr = o.myHeapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] myHeapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {// 建立大顶堆
            heapify(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {//排序，将最大的节点放在堆尾，然后从根节点重新调整
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
        return arr;
    }

    public void heapify(int[] arr, int i, int len) {//堆调整
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < len && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < len && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
