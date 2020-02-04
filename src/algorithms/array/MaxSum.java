package algorithms.array;

/**
 * 子数组最大累加和
 */
public class MaxSum {
    public static void main(String[] args){
        MaxSum o = new MaxSum();
        int[] arr = {1,-2,3,5,-2,6,-1};
        System.out.println(o.myMaxSum(arr));
        System.out.println(o.myMaxSum(arr));
    }
    private int myMaxSum1(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; i++){
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
    private int myMaxSum(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            max = Math.max(max, sum);
            if (sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
