package algorithms.tree;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 用先序遍历和后续遍历数组构造二叉树
 * (先序和后序不能构造二叉树，先序/后序和中序可以构造二叉树)
 */
public class ConstructBTByPreorderAndInorder {
    public static void main(String[] args){
        ConstructBTByPreorderAndInorder o = new ConstructBTByPreorderAndInorder();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        System.out.println(o.reConstructBinaryTree(pre, in));
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length != in.length){
            return null;
        }
        TreeNode root = process(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }
    public TreeNode process(int[] pre, int i1, int j1, int[] in, int i2, int j2){
        if (i1 > j1 || i2 > j2){
            return null;
        }
        TreeNode root = new TreeNode(pre[i1]);
        int k = i2;
        while (k <= j2){
            if (in[k] == pre[i1]){
                break;
            }
            k++;
        }
        root.left = process(pre, i1 + 1, i1 + k - i2, in, i2, k - 1);
        root.right = process(pre, i1 + k - i2 + 1, j1, in, k + 1, j2);
        return root;
    }
}
