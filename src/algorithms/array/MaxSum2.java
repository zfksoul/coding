package algorithms.array;

/**
 * 不相容子数组最大累加和
 * 两段数组不能重合
 */
public class MaxSum2 {
    public static void main(String[] args){
        MaxSum2 o = new MaxSum2();
        int[] arr = {-1,-2,3,5,-2,6,-1};
        System.out.println(o.myMaxSum(arr));
        System.out.println(o.myMaxSum1(arr));
    }
    private int myMaxSum1(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int N = arr.length;
        int[] help = new int[N];
        help[0] = arr[0];
        int sum = arr[0] < 0 ? 0 : arr[0];
        for (int i = 1; i < N - 1; i++){
            sum += arr[i];
            help[i] = Math.max(help[i - 1], sum);
            sum = sum < 0 ? 0 : sum;
        }
        help[N - 1] = arr[N - 1];
        sum = arr[N - 1] < 0 ? 0 : arr[N - 1];
        int res = help[N - 2] + help[N - 1];
        for (int i = N - 2; i >= 1; i--){
            sum += arr[i];
            help[i] = Math.max(help[i + 1], sum);
            sum = sum < 0 ? 0 : sum;
            res = Math.max(res, help[i - 1] + help[i]);
        }
        return res;
    }
    private int myMaxSum(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int[] help = new int[arr.length];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            max = Math.max(max, sum);
            sum = sum < 0 ? 0 : sum;
            help[i] = max;
        }
        sum = arr[arr.length - 1] < 0 ? 0 : arr[arr.length - 1];
        help[arr.length - 1] = sum;
        max = sum;
        int res = 0;
        for (int i = arr.length - 2; i >= 0; i--){
            sum += arr[i];
            max = Math.max(max, sum);
            res = Math.max(help[i] + help[i + 1], res);
            help[i] = max;
            sum = sum < 0 ? 0 : sum;
        }
        return res;
    }

}
