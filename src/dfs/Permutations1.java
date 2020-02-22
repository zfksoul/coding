package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一组数，返回全排列，数组中元素不重复
 * 枚举每个位置上放哪个数（本次采用的搜索方式）
 * 枚举每个数放到哪个位置
 */
public class Permutations1 {



    public static void main(String[] args){
        Permutations1 o = new Permutations1();
        System.out.println(o.permute(new int[]{1,2,3}));
    }
    public List<List<Integer>> permute(int[] nums){
        boolean[] record = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums,0, record, res, path);
        return res;
    }

    private void dfs(int[] nums, int n, boolean[] record, List<List<Integer>> res, List<Integer> path) {
        if (n == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){//枚举每个位置放哪个数
            if (!record[i]){
                record[i] = true;
                path.add(nums[i]);
                dfs(nums,n+1, record, res, path);
                path.remove(path.size()-1);
                record[i] = false;
            }
        }
    }

}
