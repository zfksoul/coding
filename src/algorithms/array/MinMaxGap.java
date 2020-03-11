package algorithms.array;

import java.util.Arrays;
import java.util.Scanner;

public class MinMaxGap {
    public static void main(String[] args){
        MinMaxGap o = new MinMaxGap();
        Scanner in = new Scanner(System.in);
        int n;
        int[] arr;
        int[] res = new int[2];
        while (in.hasNext()){
            n = in.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = in.nextInt();
            }
            o.fun(arr, res);
            System.out.println(res[0] + " " + res[1]);
        }
    }

    private void fun(int[] arr, int[] res) {
        if (arr == null || arr.length == 0){
            res[0] = 0;
            res[1] = 0;
            return;
        }
        mySort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++){
            min = Math.min(min, arr[i + 1] - arr[i]);
            max = Math.max(max, arr[i + 1] - arr[i]);
        }
        res[0] = min;
        res[1] = max;
    }

    private void mySort(int[] arr, int l, int r) {
        if (l >= r){
            return;
        }
        int pivot = partition(arr, l, r);
        mySort(arr, l, pivot - 1);
        mySort(arr, pivot + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        int ran = l + (int)(Math.random() * (r - l + 1));
        swap(arr, l, ran);
        int p = l + 1;
        for (int i = p; i <= r; i++){
            if (arr[i] <= arr[l]){
                swap(arr, p++, i);
            }
        }
        swap(arr, p - 1, l);
        return p - 1;
    }
    public void swap(int[] arr, int l, int r){
        if (l == r){
            return;
        }
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
