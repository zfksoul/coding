package tree;

/**
 * 验证搜索二叉树
 */
public class BinarySearchTree {
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
        BinarySearchTree o = new BinarySearchTree();
        System.out.println(o.isValidBST(node1));
    }
    public boolean isValidBST(TreeNode root){
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, Long minValue, Long maxValue) {
        if (root == null) return true;
        if (root.val < minValue || root.val > maxValue) return false;
        return dfs(root.left, minValue, (root.val - 1L))//root.val是int类型，可能溢出，转成Long类型
                && dfs(root.right, (root.val + 1L), maxValue);
    }
    private boolean dfs1(TreeNode root, Long minValue, Long maxValue) {
        if (root == null) return true;
        if (root.val < minValue || root.val > maxValue) return false;
        return dfs1(root.left, minValue, root.val - 1L) &&
                dfs1(root.right, root.val + 1L, maxValue);
    }

}
