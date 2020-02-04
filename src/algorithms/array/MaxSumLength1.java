package algorithms.array;

/**
 * 数组中所有元素为正数，求子数组累加和为给定值的最大长度
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class MaxSumLength1 {
    public static void main(String[] args){
        MaxSumLength1 o = new MaxSumLength1();
        int[] arr = {1,2,3,3};
        System.out.print(o.getSumLength(arr, 3));
        System.out.print(o.getSumLength1(arr, 3));
    }
    public int getSumLength1(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 1){
            return 0;
        }
        int l = 0;
        int r = 0;
        int sum = arr[0];
        int len = 0;
        while (r < arr.length){
            if (sum == k){
                len = Math.max(len, r - l + 1);
                sum -= arr[l++];
            } else if (sum < k){
                r++;
                if (r == arr.length){
                    break;
                }
                sum += arr[r];
            } else {
                sum -= arr[l++];
            }
        }
        return len;
    }
    public int getSumLength(int[] arr, int k) {
        int l = 0;
        int r = 0;
        int len = Integer.MIN_VALUE;
        int sum = arr[0];
        while (r < arr.length){
            if (sum < k){
                r++;
                if (r == arr.length){
                    break;
                }
                sum += arr[r];
            } else if (sum > k){
                sum -= arr[l++];
            } else {
                len = Math.max(len, r - l + 1);
                sum -= arr[l++];
            }
        }
        return len;
    }
}
