package algorithms.tree;

/**
 * 找到最大二叉搜索子树
 */
public class BiggestSubBST {
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
        BiggestSubBST o = new BiggestSubBST();
        System.out.println(o.myBiggestSubBST(node4));
    }
    public TreeNode myBiggestSubBST(TreeNode head){
        int[] record = new int[3];
        return posOrder(head, record);
    }

    public TreeNode posOrder(TreeNode head, int[] record) {
        if (head == null){
            record[0] = 0;                //二叉搜索子树大小
            record[1] = Integer.MAX_VALUE;//子树最小值
            record[2] = Integer.MIN_VALUE;//子树最大值
            return null;                  //返回二叉搜索子树头结点
        }
        int value = head.value;
        TreeNode left = head.left;
        TreeNode right = head.right;
        TreeNode lBST = posOrder(left, record);
        int lSize = record[0];
        int lMin = record[1];
        int lMax = record[2];
        TreeNode rBST = posOrder(right, record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];
        record[1] = Math.min(lMin, value);
        record[2] = Math.max(rMax, value);
        if (left == lBST && right == rBST && lMax < value && rMin > value){
             record[0] = lSize + rSize + 1;
             return head;
        }
        record[0] = Math.max(lSize, rSize);
        return lSize > rSize ? lBST : rBST;
    }
}
