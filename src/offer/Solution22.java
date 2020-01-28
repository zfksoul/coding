package offer;

import java.util.ArrayList;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月21日 下午10:40:54
 * 
 */
public class Solution22 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (root == null) {
            return arr;
        }
        ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
        tmp.add(root);
        while (!tmp.isEmpty()) {
            TreeNode node = tmp.remove(0);
            if (node.left != null) {
                tmp.add(node.left);
            }
            if (node.right != null) {
                tmp.add(node.right);
            }
            arr.add(node.val);
        }
        return arr;
    }
}
