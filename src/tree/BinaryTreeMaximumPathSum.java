package tree;

/**
 * 求最大路径和
 */
public class BinaryTreeMaximumPathSum {
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
        BinaryTreeMaximumPathSum o = new BinaryTreeMaximumPathSum();
        System.out.println(o.maxPathSum(node1));
    }
    /**
     * 枚举每个点，求以该点为最高点的路径权值最大和
     */
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        dfs(root);
        return res;
    }

    //返回root为根的最大路径
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + root.val + right);
        return Math.max(0,root.val+Math.max(left,right));
    }
    private int dfs1(TreeNode root) {
        if (root == null) return 0;
        int left = dfs1(root.left);
        int right = dfs1(root.right);
        res = Math.max(res, left + right + root.val);
        return Math.max(0, Math.max(left, right) + root.val);
    }
}

