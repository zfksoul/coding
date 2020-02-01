package algorithms.dp;

import java.util.Arrays;

/**
 * 最长递增子序列
 * 时间复杂度O(nlogn)
 */
public class LongestIncreaseSubsequence {
    public static void main(String[] args){
        LongestIncreaseSubsequence o = new LongestIncreaseSubsequence();
        int[] arr = {2,1,5,3,6,4,8,9,7};
        System.out.print(Arrays.toString(o.LIS1(arr)));
    }
    public int[] LIS1(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        int[] dp = getdp(arr);
        return getList1(arr, dp);
    }
    public int[] getdp(int[] arr){
        int[] dp = new int[arr.length];
        int[] help = new int[arr.length];
        help[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int r = 0;
        int l = 0;
        int m = 0;
        for (int i = 1; i < arr.length; i++){
            l = 0;
            r = right;
            while (l <= r){
                m = (l + r) / 2;
                if (arr[i] > help[m]){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            help[l] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }
    public int[] LIS(int[] arr){
        int[] dp = new int[arr.length];//获得dp[]时间复杂度O(nlogn)
        int[] help = new int[arr.length];//help[i]表示长度为i+1的递增序列的最小末尾
        help[0] = arr[0];
        dp[0] = 1;
        int right = 1;
        int l = 0;
        int r = 0;
        int mid;
        for (int i = 1; i < arr.length; i++){
            l = 0;
            r = right;
            while (l < r){//在help[]中二分查找第一个大于arr[i]的位置，插入arr[i]，并更新dp[i]
                mid = (l + r) >> 1;
                if (help[mid] < arr[i]){
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            help[l] = arr[i];
            dp[i] = l + 1;
            right = Math.max(l + 1, right);
        }
        return getList1(arr, dp);
    }

    /**
     * 通过dp获得list时间复杂度O(n)
     */
    private int[] getList(int[] arr, int[] dp) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++){
            max = Math.max(max, dp[i]);
        }
        int[] res = new int[max];
        int k = max - 1;
        int lastIndex = max - 1;
        for (int i = dp.length - 1; i >= 0; i--){
            if (dp[i] == max){
                res[k--] = arr[i];
                lastIndex = i;
            } else if (dp[i] == dp[lastIndex] - 1 && arr[i] < arr[lastIndex]){
                res[k--] = arr[i];
                lastIndex = i;
            }
        }
        return res;
    }
    private int[] getList1(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++){
            if (dp[i] > len){
                len = dp[i];
                index = i;
            }
        }
        int[] res = new int[len];
        res[--len] = arr[index];
        for (int i = index; i >= 0; i--){
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1){
                res[--len] = arr[i];
                index = i;
            }
        }
        return res;
    }

}
