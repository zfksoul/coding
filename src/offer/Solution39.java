package offer;

import algorithms.tree.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution39 {
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
        Solution39 o = new Solution39();
        System.out.println(o.isBalance(node4));
    }
    public boolean isBalance(TreeNode head){
        return getHeight(head, 0) != -1;
    }

    /**
     * @param level 上一层的层数
     * @return 是平衡二叉树，返回树的高度，不是则返回-1
     */
    public int getHeight(TreeNode head, int level) {
        if (head == null){
            return level;
        }
        int lh = getHeight(head.left, level + 1);
        int rh = getHeight(head.right, level + 1);
        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1){
            return -1;
        }
        return Math.max(lh, rh);
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        int left = getHeight1(root.left);
        int right = getHeight1(root.right);
        if (Math.abs(left - right) > 1){
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int getHeight1(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = getHeight1(root.left);
        int right = getHeight1(root.right);
        return Math.max(left, right) + 1;
    }
}
