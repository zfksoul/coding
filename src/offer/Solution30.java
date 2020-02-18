package offer;

/**
 * 连续子数组最大和
 */
public class Solution30 {
    public static void main(String[] args){
        Solution30 o = new Solution30();
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        System.out.println(o.FindGreatestSumOfSubArray(arr));
    }
    public int FindGreatestSumOfSubArray(int[] arr) {
        if (arr == null || arr.length == 0){
            throw new RuntimeException("invalid arr");
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
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
