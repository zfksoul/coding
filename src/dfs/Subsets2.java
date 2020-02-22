package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 元素可以重复
 * 1,2,2,2,3,3
 * 1:0,1
 * 2:0,1,2,3
 * 3:0,1,2
 * 共24种选择
 */
public class Subsets2 {


    public static void main(String[] args){
        Subsets2 o = new Subsets2();
        System.out.println(o.subsetsWithDup(new int[]{1,2,2}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        mysort(nums,0,nums.length-1);
        dfs1(nums, 0, res, path);
        return res;
    }

    private void dfs(int[] nums, int k, List<List<Integer>> res, List<Integer> path) {
        if (k == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        int n = 0;
        while (k + n < nums.length && nums[k +n] == nums[k]) n++;//计算当前数字个数
        for (int i = 0; i <= n; i++){//数字有n个时，共n+1种情况
            dfs(nums,k+n, res, path);//当前数枚举完从下一个数开始枚举，从0到n
            path.add(nums[k]);//最后一次add多于，也没有在递归中用到
        }
        //恢复现场
        for (int i = 0; i <= n; i++) path.remove(path.size()-1);//最后一次add把多于的值删掉
    }
    private void dfs1(int[] nums, int k, List<List<Integer>> res, List<Integer> path) {
        if(k == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        int n = 0;
        while (k + n < nums.length && nums[k] == nums[k + n]) n++;
        for (int i = 0; i <= n; i++){
            dfs1(nums, k +n, res, path);
            path.add(nums[k]);
        }
        for (int i = 0; i <= n; i++){
            path.remove(path.size() - 1);
        }
    }

    private void mysort(int[] nums,int l,int r) {
        if (l < r){
            int pivot = partition(nums,l,r);
            mysort(nums,l,pivot-1);
            mysort(nums,pivot+1,r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int ran = l + (int)(Math.random() * (r - l + 1));
        swap(nums,l,ran);
        int p = l + 1;
        for (int i = p; i <= r; i++){
            if (nums[i] < nums[l]){
                swap(nums,i,p++);
            }
        }
        swap(nums,p-1,l);
        return p-1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
