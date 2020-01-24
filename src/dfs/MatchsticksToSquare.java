package dfs;

import java.util.Arrays;

/**
 * 给一些数量的木棒，凑出一个正方形，即凑出4个长度相等的边，不能拆分，可以拼接
 * 依次构造正方形的每条边
 * 剪枝：
 * 1.从大到小枚举所有边
 * 2.每条边内部的木棒长度规定成从大到小
 * 3.如果当前木棒拼接失败，则跳过接下来所有长度相同的木棒
 * 4.如果当前木棒拼接失败，且是当前边的第一个，则直接减掉当前分支
 * 如果该木棒在当前边第一个位置失败，而最后成功，则该木棒会在下条边的某个位置，此时把木棒和第一个木棒交换，再把边和当前边交换，则与当前结论矛盾
 * 5.如果当前木棒拼接失败，且是当前边的最后一个，则直接减掉当前分支
 * 如果该木棒在不能放在当前边的最后位置，则可以放在下条边的某个位置，当前位置为由其他边组合而成，则可以将该木棒和组合木棒交换，与失败结论矛盾
 */
public class MatchsticksToSquare {
    boolean[] st;
    public static void main(String[] args){
        MatchsticksToSquare o = new MatchsticksToSquare();
        System.out.println(o.makesquare(new int[]{1,1,2,2,2}));
    }
    public boolean makesquare(int[] nums){
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum == 0 || sum % 4 != 0) return false;
        myrevsort(nums);
        st = new boolean[nums.length];
        return dfs(nums,0,0,sum/4);
    }

    private boolean dfs(int[] nums, int n, int cur, int length) {
        if (cur == length) {
            n++;
            cur = 0;
        }
        if (n == 4) return true;
        for (int i = 0; i < nums.length; i++){
            if (!st[i] && cur + nums[i] <= length){
                st[i] = true;
                if (dfs(nums,n,cur+nums[i],length)) return true;
                st[i] = false;
                if (cur == 0) return false;//4.如果当前木棒拼接失败，且是当前边的第一个，则直接减掉当前分支，重要
                if (cur + nums[i] == length) return false;//5.如果当前木棒拼接失败，且是当前边的最后一个，则直接减掉当前分支
                while (i + 1  < nums.length && nums[i+1] == nums[i]) i++;//3.如果当前木棒拼接失败，则跳过接下来所有长度相同的木棒，重要
            }

        }
        return false;
    }

    private void myrevsort(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            int tmp = nums[i];
            int j;
            for (j = i - 1; j >= 0; j--){
                if (nums[j] < tmp){
                    nums[j+1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j+1] = tmp;
        }
    }
}
