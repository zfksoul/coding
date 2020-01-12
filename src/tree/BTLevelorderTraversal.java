package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//层次遍历二叉树
public class BTLevelorderTraversal {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right =node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        BTLevelorderTraversal o = new BTLevelorderTraversal();
        System.out.println(o.levelOrder1(node1));
    }
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0){
            int len = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < len; i++){
                TreeNode t = q.poll();
                level.add(t.val);
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
            res.add(level);
        }
        return res;
    }
    public List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0){
            int len = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < len; i++){
                TreeNode t = q.poll();
                level.add(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            res.add(level);
        }
        return res;
    }
}
