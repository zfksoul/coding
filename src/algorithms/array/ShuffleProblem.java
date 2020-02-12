package algorithms.array;

import java.util.Arrays;

/**
 * 洗牌问题
 */
public class ShuffleProblem {
    public static void main(String[] args) {
        ShuffleProblem o = new ShuffleProblem();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        o.myShuffle(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void myShuffle(int[] arr) {
        if (arr != null && arr.length != 0 && (arr.length & 1) == 0) {
            shuffle(arr, 0, arr.length - 1);
        }
    }

    public void shuffle(int[] arr, int l, int r) {
        while (r - l + 1 > 0) {
            int lenAndOne = r - l + 2;//找到3^n-1中的n
            int bloom = 3;
            int k = 1;
            while (bloom <= lenAndOne / 3) {
                bloom *= 3;
                k++;
            }
            int m = (bloom - 1) / 2;
            int mid = (l + r) / 2;
            rotate(arr, l + m, mid, mid + m);
            cycles(arr, l - 1, bloom, k);
            l = l + bloom - 1;
        }
    }

    private void cycles(int[] arr, int base, int bloom, int k) {
        for (int i = 0, trigger = 1; i < k; i++, trigger *= 3) {
            int next = (2 * trigger) % bloom;
            int cur = next;
            int record = arr[next + base];//next从1开始，base要从l-1开始
            int tmp = 0;
            arr[next + base] = arr[trigger + base];
            while (cur != trigger) {
                next = (2 * cur) % bloom;
                tmp = arr[next + base];
                arr[next + base] = record;
                cur = next;
                record = tmp;
            }
        }
    }

    private void rotate(int[] arr, int l, int m, int r) {
        reverse(arr, l, m);
        reverse(arr, m + 1, r);
        reverse(arr, l, r);
    }

    private void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int tmp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = tmp;
        }
    }
}
