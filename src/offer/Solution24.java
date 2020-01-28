package offer;

import java.util.ArrayList;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月22日 下午11:44:09
 * 
 */
public class Solution24 {
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        fun(root, res, array, target);
        return res;
    }

    public void fun(TreeNode node, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> array, int target) {
        if (target <= 0 || node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (node.val == target) {
                array.add(node.val);
                res.add(new ArrayList<Integer>(array));
                array.remove(array.size()-1);
            } else {
                return;
            }
        }
        array.add(node.val);
        
        fun(node.left, res, array, target - node.val);
        fun(node.right, res, array, target - node.val);
        
        array.remove(array.size()-1);
    }
    
    public void fun1(TreeNode node, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> array, int target) {
        if (target <= 0) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (node.val == target) {
                array.add(node.val);
                res.add(array);
            } else {
                return;
            }
        }
        if (node.left != null) {
            ArrayList<Integer> arr1 = new ArrayList<Integer>(array);
            arr1.add(node.val);
            fun(node.left, res, arr1, target - node.val);
        }
        if (node.right != null) {
            ArrayList<Integer> arr2 = new ArrayList<Integer>(array);
            arr2.add(node.val);
            fun(node.right, res, arr2, target - node.val);
        }
    }
}
