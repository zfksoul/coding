package dfs;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定集合的所有子集
 * 递归
 * 迭代
 * 二进制：n，i=0~2^(n-1)
 * i的二进制表示的第j位是否为1：i>>j&1
 */
public class Subsets1 {
    public static void main(String[] args){
        Subsets1 o = new Subsets1();
        System.out.println(o.subsets(new int[]{1,2,3}));
        System.out.println(o.subsets1(new int[]{1,2,3}));
    }
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 1<<nums.length; i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++){
                if ((i >> j & 1) == 1) list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }
    public List<List<Integer>> subsets1(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        for (int i = 0; i < 1 << nums.length; i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++){
                if (((i >> j) & 1) == 1){
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }

}
