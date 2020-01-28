package offer;

/**
* 
*
* @author zfk
* @date 2019年10月20日 下午7:11:40 
* 
*/
public class Solution18 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);
    }
}
