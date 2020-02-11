package algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteBT {
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
        IsCompleteBT o = new IsCompleteBT();
        System.out.println(o.isCBT(node4));
        System.out.println(o.isCBT1(node4));
    }
    public boolean isCBT1(TreeNode head){
        if (head == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        q.offer(head);
        while (!q.isEmpty()){
            head = q.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)){
                return false;
            }
            if (l != null){
                q.offer(l);
            }
            if (r != null){
                q.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }
    public boolean isCBT(TreeNode head){
        if (head == null){
            return false;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        boolean flag = false;
        TreeNode cur = head;
        q.addLast(cur);
        while (!q.isEmpty()){
            cur = q.pollFirst();
            if (!flag){
                if (cur.left != null && cur.right != null){
                    q.addLast(cur.left);
                    q.addLast(cur.right);
                } else if (cur.left != null){
                    q.addLast(cur.left);
                    flag = true;
                } else if (cur.right != null){
                    return false;
                }
            } else {
                if (cur.left != null || cur.right != null){
                    return false;
                }
            }
        }
        return true;
    }
}
