package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 求组合数
 * 从1-9中找到k个数之和为n
 */
public class CombinationSum {


    public static void main(String[] args){
        CombinationSum o = new CombinationSum();
        System.out.println(o.combinationSum(3,9));
    }
    public List<List<Integer>> combinationSum(int k, int n){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(k,1,n, res, path);
        return res;
    }
    //k：枚举到第几个数字，start：开始枚举的位置，n：当前选择的所有数的和
    private void dfs(int k, int start, int n, List<List<Integer>> res, List<Integer> path) {
        if (k == 0){
            if (n == 0) res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= 10 - k; i++){//从i到9至少要有k个数，9-i+1>=k，
            path.add(i);
            dfs(k-1,i+1,n-i, res, path);
            path.remove(path.size()-1);
        }
    }
    private void dfs1(int k, int start, int n, List<List<Integer>> res, List<Integer> path) {
        if (k == 0){
            if (n == 0) res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; 10 - k >= i; i++){//枚举每个位置放哪个数
            path.add(i);
            dfs1(k - 1, i + 1, n - i, res, path);
            path.remove(path.size() - 1);
        }
    }
}
