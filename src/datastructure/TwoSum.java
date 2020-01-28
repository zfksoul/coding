package datastructure;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个数组，找到2个数的和等于target，每个数使用一次
 * input:[2,7,11,15],target=9
 * output:[0,1]
 */
public class TwoSum {
    public static void main(String[] args){
        TwoSum o = new TwoSum();
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(o.myTwoSum(nums,9)));
    }

    public int[] myTwoSum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
