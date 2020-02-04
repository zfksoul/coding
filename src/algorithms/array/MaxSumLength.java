package algorithms.array;

import java.util.HashMap;

/**
 * 未排序数组累加和为给定值的最长子数组
 */
public class MaxSumLength {

    public static void main(String[] args){
        MaxSumLength o = new MaxSumLength();
        int[] arr = {1,2,3,3};
        System.out.println(o.maxLength1(arr, 6));
        System.out.println(o.maxLength(arr, 6));
    }
    public int maxLength1(int[] arr, int k){
        if (arr == null || arr.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            if (map.containsKey(sum - k)){
                len = Math.max(len, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return len;
    }
    public int maxLength(int[] arr, int k){
        if (arr == null || arr.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            if (map.containsKey(sum - k)){
                len = Math.max(len, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return len;

    }
}
