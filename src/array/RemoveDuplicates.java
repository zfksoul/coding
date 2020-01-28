package array;

import java.util.Arrays;

/**
 * input:
 * nums=[0,0,1,1,1,2,2,3,3,4]
 * output:
 * 返回新长度5，原数组nums前5个元素修改为0,1,2,3,4，不考虑数组中超出新长度后面的元素
 * 双指针算法
 */
public class RemoveDuplicates {

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicates o = new RemoveDuplicates();
        System.out.println(o.myRemoveDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int myRemoveDuplicates(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int k = 1;
        for (int j = 1; j < nums.length; j++){
            if (nums[j] != nums[j-1]) nums[k++] = nums[j];
        }
        return k;
    }

}
