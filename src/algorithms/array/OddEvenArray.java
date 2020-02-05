package algorithms.array;

import java.util.Arrays;

/**
 * 调整数组，使奇数下标都是奇数，偶数下标都是偶数
 */
public class OddEvenArray {
    public static void main(String[] args){
        OddEvenArray o = new OddEvenArray();
        int[] arr = {2,1,3,4,5,6};
        o.fun(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void fun1(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        int even = 0;
        int odd = 1;
        int end = arr.length - 1;
        while (even <= end && odd <= end){
            if ((arr[end] & 1) == 0){
                swap(arr, even, end);
                even += 2;
            } else {
                swap(arr, odd, end);
                odd += 2;
            }
        }
    }
    public void fun(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        int i = 0;
        int j = 1;
        while (i < arr.length && j < arr.length){
            if ((arr[arr.length - 1] & 1) == 0){
                swap(arr, i, arr.length - 1);
                i += 2;
            } else {
                swap(arr, j, arr.length - 1);
                j += 2;
            }
        }
    }
    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
