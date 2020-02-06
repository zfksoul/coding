package algorithms.array;

import java.util.HashMap;

/**
 * 2个数组，窗口坐标相同，求包含相同数量1的最长子数组
 */
public class SameOneNumber {
    public int maxLength(int[] arr1, int[] arr2){
        if (arr1 == null || arr2 == null || arr1.length != arr2.length){
            return 0;
        }
        for (int i = 0; i < arr1.length; i++){
            arr1[i] += arr2[i] == 1 ? -1 : 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr1.length; i++){
            sum += arr1[i];
            if (map.containsKey(sum)){
                len = Math.max(len, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return len;
    }
}
