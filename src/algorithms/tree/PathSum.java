package algorithms.tree;

import java.util.ArrayList;

/**
 * 给定二叉树，返回累加和为sum的所有路径，返回值的list中数组长度的大的靠前
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 */
public class PathSum {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        if (root == null || target <= 0){
            return res;
        }
        preorder(root, target, arr, res);
        return res;
    }

    private void preorder(TreeNode head, int target, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> res) {
        if (head == null || target <= 0){
            return;
        }
        /**
         * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径，
         * 所以我们要确保最后一个加进去Arraylist的节点为叶节点，即确保当前遍历的节点无左孩子也无右孩子。
         */
        if (head.left == null && head.right == null){
            if (head.value == target){
                arr.add(head.value);
                res.add(new ArrayList<Integer>(arr));
                arr.remove(arr.size() - 1);
            }
        }
        arr.add(head.value);
        preorder(head.left, target - head.value, arr, res);
        preorder(head.right, target - head.value, arr, res);
        arr.remove(arr.size() - 1);
    }
}
