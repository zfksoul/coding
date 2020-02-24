package algorithms.tree;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return getDepth(root, 1);
    }
    public int getDepth(TreeNode root, int level){
        int res = level;
        if (root.left != null){
            res = Math.max(res, getDepth(root.left, level + 1));
        }
        if (root.right != null){
            res = Math.max(res, getDepth(root.right, level + 1));
        }
        return res;
    }
}
