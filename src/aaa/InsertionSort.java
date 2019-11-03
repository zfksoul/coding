package aaa;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月27日 下午10:47:52
 * 
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 2, 5, 4, 6 };
        InsertionSort o = new InsertionSort();
        arr = o.myInsertionSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] myInsertionSort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int tmp = arr[i];
            while (j >= 0 && arr[j] > tmp) { //">"确保排序稳定
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public int[] myInsertionSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int tmp = arr[i];
            while (j >= 0) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    arr[j + 1] = tmp;
                    break;
                }
            }
        }
        return arr;
    }

}
