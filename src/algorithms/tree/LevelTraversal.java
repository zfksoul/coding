package algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelTraversal {
    public static void main(String[] args){
        LevelTraversal o = new LevelTraversal();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node4.left = node2;
        node4.right =node6;
        node2.left = node1;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        System.out.println(o.PrintFromTopToBottom(node4));
        System.out.println(o.PrintFromTopToBottom1(node4));
    }


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode cur = root;
        TreeNode last = root;
        TreeNode nlast = cur;
        int level = 1;
        System.out.println("level:" + level++);
        while (!q.isEmpty()){
            cur = q.poll();
            res.add(cur.value);
            if (cur.left != null){
                q.offer(cur.left);
                nlast = cur.left;
            }
            if (cur.right != null){
                q.offer(cur.right);
                nlast = cur.right;
            }
            if (cur == last && !q.isEmpty()){
                System.out.println(cur.value);
                System.out.println("level:" + level++);
                last = nlast;
            } else {
                System.out.print(cur.value + " ");
            }
        }
        return res;
    }

    public ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode cur = root;
        TreeNode last = root;
        TreeNode nlast = root;
        int level = 1;
        System.out.println("level:" + level++);
        while (!q.isEmpty()){
            cur = q.poll();
            res.add(cur.value);
            if (cur.left != null){
                q.offer(cur.left);
                nlast = cur.left;
            }
            if (cur.right != null){
                q.offer(cur.right);
                nlast = cur.right;
            }
            if (cur == last && !q.isEmpty()){
                System.out.println(cur.value);
                System.out.println("level:" + level++);
                last = nlast;
            } else {
                System.out.print(cur.value + " ");
            }
        }
        return res;
    }
}
