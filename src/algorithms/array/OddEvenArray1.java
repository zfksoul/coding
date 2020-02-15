package algorithms.array;

import java.util.Arrays;

/**
 * 调整数组，使奇数在数组前半部分，偶数在数组后半部分
 */
public class OddEvenArray1 {
    public static void main(String[] args){
        OddEvenArray1 o = new OddEvenArray1();
        int[] arr = {2,1,3,4,5,6};
        o.fun(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void fun(int[] arr) {
        if (arr == null || arr.length == 0){
            return;
        }
        for (int i = 1; i < arr.length; i++){
            if ((arr[i] & 1) == 1){
                int tmp = arr[i];
                int j = i - 1;
                for (; j >= 0; j--){
                    if ((arr[j] & 1) == 0){
                        arr[j + 1] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + 1] = tmp;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        if (i == j){
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
