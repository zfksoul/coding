package algorithms.array;

import java.util.HashSet;

/**
 * 给定5个数字的数组，0代表任意数字，如果5个数字连续返回true，否则返回false
 */
public class IsContinuous {
    public static void main(String[] args){
        IsContinuous o = new IsContinuous();
        int[] arr = {1,0,0,1,0};
        System.out.println(o.myIsContinuous(arr));
    }
    public boolean myIsContinuous(int [] arr) {
        if (arr == null || arr.length == 0){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != 0 && set.contains(arr[i])) return false;
            set.add(arr[i]);
        }
        for (Integer i : set){
            if (i == 0){
                continue;
            }
            if (min > i){
                min = i;
            }
            if (max < i){
                max = i;
            }
        }
        return max - min + 1 <= arr.length;
    }
}
