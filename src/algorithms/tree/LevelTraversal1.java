package algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelTraversal1 {
    public static void main(String[] args){
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
        LevelTraversal1 o = new LevelTraversal1();
        o.print(node4);
        o.print1(node4);
    }
    public void print1(TreeNode head){
        if (head == null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int level = 1;
        TreeNode last = head;
        TreeNode nlast = null;
        q.offer(head);
        System.out.print("level " + (level++) + " : ");
        while (!q.isEmpty()){
            head = q.poll();
            System.out.print(head.value + " ");
            if (head.left != null){
                q.offer(head.left);
                nlast = head.left;
            }
            if (head.right != null){
                q.offer(head.right);
                nlast = head.right;
            }
            if (head == last && !q.isEmpty()){
                System.out.print("\nlevel " + (level++) + " : ");
                last = nlast;
            }
        }
        System.out.println();
    }
    public void print(TreeNode head){
        if (head == null){
            return;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(head);
        TreeNode last = head;
        TreeNode cur = head;
        TreeNode nlast = head;
        int n = 1;
        System.out.println("level:" + n++);
        while (!q.isEmpty()){
            cur = q.pollFirst();
            if (cur.left != null){
                q.addLast(cur.left);
                nlast = cur.left;
            }
            if (cur.right != null){
                q.addLast(cur.right);
                nlast = cur.right;
            }
            if (cur == last && !q.isEmpty()){
                System.out.println(cur.value + " ");
                System.out.println("level:" + n++);
                last = nlast;
            } else {
                System.out.print(cur.value + " ");
            }
        }
        System.out.println();
    }
    ArrayList<ArrayList<Integer>> Print(TreeNode root) {
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
                list.add(cur.value);
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
