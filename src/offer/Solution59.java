package offer;

import algorithms.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return res;
        }
        TreeNode last = root;
        TreeNode nlast = root;
        TreeNode cur = null;
        boolean reverse = false;
        q.offer(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            while (cur != last) {
                cur = q.poll();
                if (reverse) {
                    list.add(0, cur.value);
                } else {
                    list.add(cur.value);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                    nlast = cur.left;
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                    nlast = cur.right;
                }
            }
            res.add(list);
            last = nlast;
            reverse = !reverse;
        }
        return res;
    }
}
