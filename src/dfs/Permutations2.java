package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给一组数，返回全排列，数组中元素不重复
 * 枚举每个位置上放哪个数
 * 枚举每个数放到哪个位置（本次采用的搜索方式）
 * 将所有相同的数放一起，排序
 * 人为规定相同数字相对顺序不变
 */
public class Permutations2 {
    boolean[] st;
    List<List<Integer>> res = new ArrayList<>();
    Integer[] path;
    public static void main(String[] args){
        Permutations2 o = new Permutations2();
        System.out.println(o.permuteUnique(new int[]{1,1,2}));
    }
    public List<List<Integer>> permuteUnique(int[] nums){
        st = new boolean[nums.length];
        path = new Integer[nums.length];
        mySort(nums);
        dfs(nums,0,0);
        return res;
    }

    private void dfs(int[] nums, int k, int start) {
        int n = nums.length;
        if (k == n) {
            res.add(new ArrayList<>(Arrays.asList(path)));
            return;
        }
        //每个元素可能放在n个位置，如果后面的元素和当前相同，则只能在后面选择位置
        for (int i = start; i < n; i++){
            if (!st[i]){
                st[i] = true;
                path[i] = nums[k];
                dfs(nums,k+1,k+1 < n && nums[k+1]==nums[k]?i+1:0);
                st[i]=false;
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
