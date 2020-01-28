package array;

import java.util.Arrays;

/**
 * 给定升序的有序数组，找到两个数使它们相加等于目标数
 */
public class TwoSum {

    public static void main(String[] args){
        TwoSum o = new TwoSum();
        int[] nums = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(o.myTwoSum(nums,9)));
    }
    public int[] myTwoSum(int[] numbers, int target){
        for (int j = 0, i = numbers.length - 1; j < numbers.length; j++){
            while (i - 1 > j && numbers[i-1] + numbers[j] >= target) i--;
            if (numbers[i] + numbers[j] == target) return new int[]{j+1,i+1};
        }
        return new int[]{-1,-1};
    }
}
