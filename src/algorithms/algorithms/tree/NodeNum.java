package algorithms.algorithms.tree;

/**
 * 统计完全二叉树节点数
 * 时间复杂度O(h^2),h为树高度
 */
public class NodeNum {
    public static void main(String[] args){
        NodeNum o = new NodeNum();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        System.out.print(o.myNodeNum(node1));
    }

    public int myNodeNum(TreeNode node) {
        if (node == null) return 0;
        return mycount(node, 1, mostLeftLevel(node, 1));
    }

    private int mycount(TreeNode node, int l, int h) {
        if (l == h) return 1;
        if (mostLeftLevel(node.right, l + 1) == h){
            return (1 << (h - l))+ mycount(node.right, l+1, h);
        } else {
            return (1 << (h - l - 1)) + mycount(node.left, l+1, h);
        }
    }
    public int mostLeftLevel(TreeNode node, int l){
        while (node != null){
            node = node.left;
            l++;
        }
        return l - 1;
    }
}
