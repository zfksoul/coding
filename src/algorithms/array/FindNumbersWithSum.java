package algorithms.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    public static void main(String[] args){
        FindNumbersWithSum o = new FindNumbersWithSum();
        int[] arr = {1,2,4,7,11,15};
        System.out.println(o.myFindNumbersWithSum1(arr, 15));
    }
    public ArrayList<Integer> myFindNumbersWithSum1(int [] arr, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (arr == null || arr.length < 2){
            return res;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l < r){
            if (arr[l] + arr[r] < sum){
                l++;
            } else if (arr[l] + arr[r] > sum){
                r--;
            } else {
                res.add(arr[l]);
                res.add(arr[r]);
                break;
            }
        }
        return res;
    }
    public ArrayList<Integer> myFindNumbersWithSum(int [] arr, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        boolean flag = false;
        for (int i = 0; i < arr.length; i++){
            if (set.contains(sum - arr[i])){
                if (flag){
                    if (res.get(0) * res.get(1) > (sum - arr[i]) * arr[i]){
                        res.set(0, sum - arr[i]);
                        res.set(1, arr[i]);
                    }
                } else {
                    res.add(sum - arr[i]);
                    res.add(arr[i]);
                    flag = true;
                }
            } else {
                set.add(arr[i]);
            }
        }
        return res;
    }
}
