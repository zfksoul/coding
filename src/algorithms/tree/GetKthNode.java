package algorithms.tree;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class GetKthNode {
    TreeNode KthNode(TreeNode head, int k) {
        if (head == null || k < 1){
            return null;
        }
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || head != null){
            if (head != null){
                st.push(head);
                head = head.left;
            } else {
                head = st.pop();
                k--;
                if (k == 0){
                    return head;
                } else {
                    head = head.right;
                }
            }
        }
        return null;
    }

}
