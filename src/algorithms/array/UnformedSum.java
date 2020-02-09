package algorithms.array;

import java.util.HashSet;

/**
 * 最小不可组成和
 */
public class UnformedSum {
    public static void main(String[] args){
        UnformedSum o = new UnformedSum();
        int[] arr = {1,2,3,5,7,9};
        System.out.println(o.mySum(arr));
        System.out.println(o.mySumDP(arr));
    }
    public int mySumDP1(int[] arr){
        if (arr == null || arr.length == 0){
            return 1;
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            min = Math.min(min, arr[i]);
        }
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < arr.length; i++){
            for (int j = sum; j >= arr[i]; j--){
                dp[j] = dp[j - arr[i]] ? true : dp[j];
            }
        }
        for (int i = min; i < dp.length; i++){
            if (!dp[i]){
                return i;
            }
        }
        return sum + 1;
    }
    public int mySumDP(int[] arr){
        if (arr == null || arr.length == 0){
            return 1;
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            min = Math.min(min, arr[i]);
        }
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < arr.length; i++){
            for (int j = dp.length - 1; j >= arr[i]; j--){
                dp[j] = dp[j - arr[i]];
            }
        }
        for (int i = min; i < dp.length; i++){
            if (!dp[i]){
                return i;
            }
        }
        return sum + 1;
    }
    public int mySum(int[] arr){
        if (arr == null || arr.length == 0){
            return 1;
        }
        HashSet<Integer> set = new HashSet<>();
        process(arr, 0, 0, set);//收集所有子集的和
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            min = Math.min(min, arr[i]);
        }
        for (int i = min + 1; i != Integer.MIN_VALUE; i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return 0;
    }

    private void process(int[] arr, int i, int sum, HashSet<Integer> set) {
        if (i == arr.length){
            set.add(sum);
            return;
        }
        process(arr, i + 1, sum, set);
        process(arr, i + 1, sum + arr[i], set);
    }
}
