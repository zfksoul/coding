package sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月29日 下午8:52:27
 * 
 */
public class HeapSort1 {

    public static void main(String[] args) {
        int[] arr = new int[] { 1,22, 3, 2, 5, 4, 6, 5, 9, 8, 7, 10, 11 };
        HeapSort1 o = new HeapSort1();
        o.myHeapSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] myHeapSort1(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--){
            pushDown(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i >= 0; i--){
            swap(arr, 0, i);
            pushDown(arr, 0, i);
        }
        return arr;
    }
    public int[] myHeapSort2(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            pushUp(arr, i);
        }
        for (int i = arr.length - 1; i > 0; i--){
            swap(arr, 0, i);
            pushDown(arr, 0, i);
        }
        return arr;
    }
    public void swap(int[] heap, int i, int j){
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
    public void pushUp(int[] heap, int i){
        int father = (i - 1) / 2;
        if (father >= 0 && heap[father] < heap[i]){
            swap(heap, father, i);
            pushUp(heap, father);
        }
    }
    public void pushDown(int[] heap, int i, int len){
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int maxIndex = i;
        if (left < len && heap[left] > heap[maxIndex]){
            maxIndex = left;
        }
        if (right < len && heap[right] > heap[maxIndex]){
            maxIndex = right;
        }
        if (maxIndex != i){
            swap(heap, maxIndex, i);
            pushDown(heap, maxIndex, len);
        }
    }

}
