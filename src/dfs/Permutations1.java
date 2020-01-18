package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给一组数，返回全排列，数组中元素不重复
 * 枚举每个位置上放哪个数（本次采用的搜索方式）
 * 枚举每个数放到哪个位置
 */
public class Permutations1 {
    boolean[] st;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public static void main(String[] args){
        Permutations1 o = new Permutations1();
        System.out.println(o.permute(new int[]{1,2,3}));
    }
    public List<List<Integer>> permute(int[] nums){
        st = new boolean[nums.length];
        dfs(nums,0);
        return res;
    }

    private void dfs(int[] nums, int k) {
        if (k == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!st[i]){
                st[i] = true;
                path.add(nums[i]);
                dfs(nums,k+1);
                path.remove(path.size()-1);
                st[i] = false;
            }
        }
    }

}
