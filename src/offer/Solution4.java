package offer;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月12日 下午10:43:12
 * 
 */
public class Solution4 {

    public static void main(String[] args) {
        int[] pre = { 1, 2, 3, 4, 5, 6, 7 };
        int[] in = { 3, 2, 4, 1, 6, 5, 7 };
        Solution4 so = new Solution4();
        System.out.println(so.reConstructBinaryTree(pre, in).toString());
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        TreeNode node = fun(pre, 0, pre.length - 1, in, 0, in.length - 1);

        return node;
    }

    public TreeNode fun(int[] pre, int i1, int i2, int[] in, int j1, int j2) {
        if (pre == null || in == null) {
            return null;
        }
        if (i1 > i2 || j1 > j2) {
            return null;
        }

        TreeNode node = new TreeNode(pre[i1]);

        for (int j = j1; j <= j2; j++) {
            if (pre[i1] == in[j]) {
                node.left = fun(pre, i1 + 1, i1 + j - j1, in, j1, j - 1);
                node.right = fun(pre, i1 + j - j1 + 1, i2, in, j + 1, j2);
            }
        }
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
