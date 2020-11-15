package sort;

/**
* 
*
* @author zfk
* @date 2019年10月27日 下午9:57:29 
* 
*/
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,5,4,6};
        SelectionSort o = new SelectionSort();
        arr = o.mySelectionSort1(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public int[] mySelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        return arr;
    }

    public int[] mySelectionSort1(int[] arr) {
        if (arr == null || arr.length == 0){
            return null;
        }
        for (int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        return arr;
    }

}
