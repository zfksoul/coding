package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution60 {
    ArrayList<ArrayList<Integer> > Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        TreeNode nlast = root;
        TreeNode last = root;
        TreeNode cur = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            while (cur != last){
                cur = q.poll();
                list.add(cur.val);
                if (cur.left != null){
                    q.offer(cur.left);
                    nlast = cur.left;
                }
                if (cur.right != null){
                    q.offer(cur.right);
                    nlast = cur.right;
                }
            }
            res.add(list);
            last = nlast;
        }
        return res;
    }

}
