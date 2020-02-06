package algorithms.array;

/**
 * 给定数组，b在a右边，求arr[b]-arr[a]的最大值
 * input: arr=[3,4,1,7,2,9,3]
 * outout: 8
 */
public class MaxDifference {
    public static void main(String[] args){
        MaxDifference o = new MaxDifference();
        int[] arr = {3,4,1,7,2,9,3};
        System.out.println(o.getMaxDifference(arr));
    }

    public int getMaxDifference(int[] arr) {
        if (arr == null || arr.length < 2){
            return 0;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(arr[i] - min, max);
        }
        return max;

    }
}
