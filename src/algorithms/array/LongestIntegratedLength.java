package algorithms.array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 最长可整合子数组长度
 * 如果arr[i]~arr[j]是可整合子数组，则max - min = j - i，且arr[i]~arr[j]不重复
 */
public class LongestIntegratedLength {
    public static void main(String[] args){
        LongestIntegratedLength o = new LongestIntegratedLength();
        int[] arr = {5,3,4,2,1,5,3,2,4};
        System.out.println(o.getLIL(arr));
        System.out.println(o.getLIL1(arr));
    }
    public int getLIL1(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int len = 0;
        int max = 0;
        int min = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++){
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++){
                if (set.contains(arr[j])){
                    break;
                }
                set.add(arr[j]);
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (max - min == j - i){
                    len = Math.max(len, j - i + 1);
                }
            }
            set.clear();
        }
        return len;
    }
    public int getLIL(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int len = 0;
        int max;
        int min;
        for (int i = 0; i < arr.length; i++){
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++){
                if (!set.contains(arr[j])){
                    set.add(arr[j]);
                    max = Math.max(max, arr[j]);
                    min = Math.min(min, arr[j]);
                    if (max - min == j - i){
                        len = Math.max(len, max - min + 1);
                    }
                } else {
                    break;
                }
            }
            set.clear();
        }
        return len;
    }
}
