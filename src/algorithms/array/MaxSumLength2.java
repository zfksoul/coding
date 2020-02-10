package algorithms.array;

import java.util.HashMap;

/**
 * 未排序数组中累加和小于等于给定值的最长子数组
 * 时间复杂度O(nlogn)
 * 空间复杂度O(n)
 */
public class MaxSumLength2 {
    public static void main(String[] args){
        MaxSumLength2 o = new MaxSumLength2();
        int[] arr = {3,-2,-4,0,6};
        System.out.println(o.getMaxLength(arr, -2));
        System.out.println(o.getMaxLength1(arr, -2));
        System.out.println(o.getMaxLength2(arr, -2));
    }
    public int getMaxLength1(int[] arr, int k){
        int[] h = new int[arr.length + 1];
        int sum = 0;
        h[0] = sum;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            h[i + 1] = Math.max(sum, h[i]);
        }
        sum = 0;
        int res = 0;
        int pre = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            pre = getLessLength(h, sum - k);
            len = pre == -1 ? 0 : i - pre + 1;
            res = Math.max(res, len);
        }
        return res;
    }

    private int getLessLength(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int res = -1;
        while (low <= high){
            mid = (low + high) / 2;
            if (arr[mid] >= num){
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    /**
     * 时间复杂度O(n)
     * 辅助数组sums[i]表示以i开始往右的最小累加和
     * HashMap记录i开始最小累加和的右边界
     */
    public int getMaxLength2(int[] arr, int k){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int[] sums = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        sums[arr.length - 1] = arr[arr.length - 1];
        map.put(arr.length - 1, arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--){
            if (sums[i + 1] < 0){
                sums[i] = arr[i] + sums[i + 1];
                map.put(i, map.get(i + 1));
            } else {
                sums[i] = arr[i];
                map.put(i, i);
            }
        }
        int end = 0;
        int sum = sums[0];
        int res = 0;
        int index = 0;
        while (end < arr.length){
            while (sum <= k){
                res = Math.max(res, end - index);
                sum += sums[end];
                end = map.get(end) + 1;
            }
            sum -= arr[index++];
        }
        /*int end = 0;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++){
            while (end < arr.length && sum + sums[end] <= k){
                sum += sums[end];
                end = map.get(end) + 1;
            }
            sum -= end > i ? arr[i] : 0;
            res = Math.max(res, end - i);
            end = Math.max(end, i + 1);
        }*/
        return res;
    }
    private int getMaxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int help[] = new int[arr.length + 1];
        int l = 0;
        int r = 0;
        int sum = 0;
        help[0] = 0;
        int len = sum <= k ? 1 : 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            help[i + 1] = Math.max(help[i], sum);
            l = 0;
            r = i + 1;
            while (l < r){
                int mid = (l + r) / 2;
                if (help[mid] < sum - k){
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (help[l] >= sum - k){
                len = Math.max(len, i + 1 - l);
            }
        }
        return len;
    }
}
