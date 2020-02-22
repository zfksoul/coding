package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给一组数，返回全排列，数组中元素重复
 * 枚举每个位置上放哪个数
 * 枚举每个数放到哪个位置（本次采用的搜索方式）
 * 将所有相同的数放一起，排序
 * 人为规定相同数字相对顺序不变
 */
public class Permutations2 {
    public static void main(String[] args){
        Permutations2 o = new Permutations2();
        System.out.println(o.permuteUnique(new int[]{1,1,2}));
    }
    public List<List<Integer>> permuteUnique(int[] nums){
        boolean[] record = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        Integer[] path = new Integer[nums.length];
        mySort(nums);
        dfs(nums,0,0, record, res, path);
        return res;
    }

    private void dfs(int[] nums, int n, int start, boolean[] record, List<List<Integer>> res, Integer[] path) {
        if (n == nums.length) {
            res.add(new ArrayList<>(Arrays.asList(path)));
            return;
        }
        //每个元素可能放在n个位置，如果后面的元素和当前相同，则只能在后面选择位置
        for (int i = start; i < path.length; i++){
            if (!record[i]){
                record[i] = true;
                path[i] = nums[n];//枚举位置，将nums[n]放在所有i位置
                dfs(nums,n+1,n+1 < nums.length && nums[n+1]==nums[n]?i+1:0, record, res, path);
                record[i]=false;
            }
        }
    }

    private void mySort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 1; i < nums.length; i++){
            int tmp = nums[i];
            for (int j = i - 1; j >= 0; j--){
                if (nums[j] > tmp){
                    nums[j+1] = nums[j];
                } else {
                    nums[j+1] = tmp;
                    break;
                }
            }
        }
    }
}
