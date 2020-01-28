package offer;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月20日 上午9:34:35
 * 
 */
public class Solution17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        
        return fun(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean fun(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return fun(root1.left, root2.left) && fun(root1.right, root2.right);
        } else {
            return false;
        }
    }
}
