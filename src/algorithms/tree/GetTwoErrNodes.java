package algorithms.tree;

import java.util.Arrays;
import java.util.Stack;

/**
 * 二叉搜索树中有2个节点位置交换，找到这2个节点
 */
public class GetTwoErrNodes {
    public static void main(String[] args){
        GetTwoErrNodes o = new GetTwoErrNodes();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node4.left = node3;
        node3.left = node1;
        node3.right = node2;
        System.out.println(Arrays.toString(o.getTwoNodes(node4)));
    }

    public TreeNode[] getTwoNodes(TreeNode head){
        TreeNode[] errs = new TreeNode[2];
        if (head == null){
            return errs;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode pre = null;
        while (!st.empty() || head != null){//中序遍历
            if (head != null){
                st.push(head);
                head = head.left;
            } else {
                head = st.pop();
                if (pre != null && head.value < pre.value){
                    errs[0] = errs[0] == null ? pre : errs[0];
                    errs[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return errs;
    }
}
