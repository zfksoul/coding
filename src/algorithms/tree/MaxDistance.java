package algorithms.tree;

/**
 * 返回二叉树两节点最远距离
 */
public class MaxDistance {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node4.left = node2;
        node4.right = node6;
        node2.left = node1;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        MaxDistance o = new MaxDistance();
        System.out.println(o.mymaxDistance(node4));
    }
    public int mymaxDistance(TreeNode head){
        int[] record = new int[1];
        return posOrder(head, record);
    }

    /**
     * @param record 记录二叉树最大深度
     * @return 返回二叉树中两节点最大距离
     */
    public int posOrder(TreeNode head, int[] record) {
        if (head == null){
            record[0] = 0;
            return 0;
        }
        int lMax = posOrder(head.left, record);
        int maxFromLeft = record[0];
        int rMax = posOrder(head.right, record);
        int maxFromRight = record[0];
        int curNodeMax = maxFromLeft + maxFromRight + 1;
        record[0] = Math.max(maxFromLeft, maxFromRight) + 1;
        return Math.max(Math.max(lMax, rMax), curNodeMax);
    }
}
