package algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 找到无序数组中最小的k个数
 * BFPRT时间复杂度O(n)
 * 至少(n/10-2)*3个数小于中位数，最多n-(n/10-2)*3=7n/10+6个数大于中位数
 * T(n)=O(n)+T(n/5)+T(7n/10+6)
 */
public class GetMinKNums {
    public static void main(String[] args){
        GetMinKNums o = new GetMinKNums();
        int[] arr = {1,2,3,3,5,3,7,7,4,5,6,7,8,9,10};
        System.out.print(Arrays.toString(o.getMinKNumsByBFPRT(arr, 6)));
        System.out.print(o.getMinKNums(arr, 6));
    }


    public int[] getMinKNumsByBFPRT(int[] arr, int k){
        if (k < 1 || k > arr.length){
            return arr;
        }
        int minKth = getMinKthByBFPRT(arr, k);
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < minKth){
                res[index++] = arr[i];
            }
        }
        for (; index < res.length; index++){
            res[index] = minKth;
        }
        return res;
    }

    public int getMinKthByBFPRT(int[] arr, int k) {
        int[] copyArr = copyArr(arr);
        return select(copyArr, 0, copyArr.length - 1, k - 1);//数组下标以0开始
    }
    public int[] copyArr(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < res.length; i++){
            res[i] = arr[i];
        }
        return res;
    }
    public int select(int[] arr, int begin, int end, int i) {
        if (begin == end){
            return arr[begin];
        }
        int pivot = medianOfMedians(arr, begin, end);
        int[] pivotRange = partition(arr, begin, end, pivot);
        if (i >= pivotRange[0] && i <= pivotRange[1]){
            return arr[i];
        } else if (i < pivotRange[0]){
            return select(arr, begin, pivotRange[0] - 1, i);
        } else {
            return select(arr, pivotRange[1] + 1, end, i);
        }
    }

    public int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + offset];
        for (int i = 0; i < mArr.length; i++){
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        return select(mArr, 0, mArr.length - 1, mArr.length / 2);
    }


    //返回分区后pivot所在的坐标范围
    private int[] partition(int[] arr, int begin, int end, int pivot) {
        int small = begin - 1;
        int cur = begin;
        int big = end + 1;
        while (cur != big){
            if (arr[cur] < pivot){
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivot){
                swap(arr, cur, --big);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }

    private void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    private int getMedian(int[] arr, int begin, int end) {
        insertionSort(arr, begin, end);
        int sum = end + begin;
        int mid = (sum / 2) + (sum % 2);
        return arr[mid];
    }

    private void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin + 1; i <= end; i++){
            for (int j = i; j > begin; j--){
                if (arr[j - 1] > arr[j]){
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
    public ArrayList<Integer> getMinKNums(int[] arr, int k){
        if(arr == null || arr.length < k){
            return null;
        }
        quickSort(arr, 0, arr.length - 1);
        ArrayList<Integer> res = new ArrayList<>();
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
}
