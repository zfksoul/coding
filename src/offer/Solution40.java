package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 */
public class Solution40 {
    public void myFindNumsAppearOnce(int [] arr,int num1[] , int num2[]) {
        if (arr == null || arr.length == 0){
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            if (!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], 2);
            }
        }
        int k = 0;
        for (Map.Entry<Integer, Integer> entries : map.entrySet()){
            if (entries.getValue() == 1){
                if (k == 0){
                    num1[0] = entries.getKey();
                    k++;
                } else {
                    num2[0] = entries.getKey();
                }
            }
        }
    }
    public void myFindNumsAppearOnce1(int [] arr,int num1[] , int num2[]) {
        if (arr == null || arr.length == 0){
            return;
        }
        int x = 0;
        for (int i = 0; i < arr.length; i++){
            x ^= arr[i];
        }
        int k = 1;
        while ((x & k) == 0){
            k <<= 1;
        }
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < arr.length; i++){
            if ((arr[i] & k) == 0){
                res1 ^= arr[i];
            } else {
                res2 ^= arr[i];
            }
        }
        num1[0] = res1;
        num2[0] = res2;
    }
}
