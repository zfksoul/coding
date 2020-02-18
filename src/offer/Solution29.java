package offer;

import java.util.ArrayList;

/**
 * 最小的k个数
 */
public class Solution29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(arr == null || arr.length < k){
            return res;
        }
        quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < k; i++){
            res.add(arr[i]);
        }
        return res;
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r){
            return;
        }
        int pivot = partition(arr, l, r);
        quickSort(arr, l, pivot - 1);
        quickSort(arr, pivot + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        int ran = (int) (l + Math.random() * (r - l + 1));
        swap(arr, l, ran);
        int p = l + 1;
        for (int i = p; i <= r; i++){
            if (arr[i] <= arr[l]){
                swap(arr, p++, i);
            }
        }
        swap(arr, l, p - 1);
        return p - 1;
    }
    private void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
