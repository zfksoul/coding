package algorithms.array;

import java.util.HashMap;

/**
 * 最长不重复子数组
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class LongestNotRepeatSubstring {
    public static void main(String[] args){
        LongestNotRepeatSubstring o = new LongestNotRepeatSubstring();
        int[] arr = {1,3,2,5,3,5,7,9,6,5,3,2};
        System.out.println(o.maxUnique(arr));
        System.out.println(o.maxUnique1(arr));
    }
    public int maxUnique1(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int pre = -1;//以arr[i-1]为结尾的最长无重复子数组左边界位置
        int res = 0;
        for (int i = 0; i < arr.length; i++){
            if (map.containsKey(arr[i])){
                pre = Math.max(pre, map.get(arr[i]));
            } else {
                pre = Math.max(pre, -1);
            }
            res = Math.max(i - pre, res);
            map.put(arr[i], i);
        }
        return res;
    }
    public int maxUnique(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();//每种字符上次出现的位置
        int pre = 0;//以arr[i-1]为结尾的最长无重复子数组长度
        int res = 0;
        for (int i = 0; i < arr.length; i++){
            if (map.containsKey(arr[i])){
                int k = map.get(arr[i]);
                pre = Math.min(i - k, pre + 1);
                res = Math.max(pre, res);
            } else {
                pre++;
            }
            map.put(arr[i], i);
        }
        return res;
    }
}
