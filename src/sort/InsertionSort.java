package sort;

/**
 * @author zfk
 * @date 2019年10月27日 下午10:47:52
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 5, 4, 6};
        InsertionSort o = new InsertionSort();
        arr = o.myInsertionSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] myInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {      //">"而不用“>=”，确保排序稳定
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }
        return arr;
    }

    public int[] myInsertionSort1(int[] arr) {
        if (arr == null || arr.length == 0){
            return null;
        }
        for (int i = 1; i < arr.length; i++){
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--){
                if (arr[j] > arr[j + 1]){
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }


}
