package algorithms.array;

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
