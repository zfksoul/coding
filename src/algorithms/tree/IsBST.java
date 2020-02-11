package algorithms.tree;

import java.util.Stack;

public class IsBST {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node4.left = node2;
        node4.right =node6;
        node2.left = node1;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        IsBST o = new IsBST();
        System.out.println(o.checkBST(node4));
    }
    public boolean checkBST(TreeNode head){
        Stack<TreeNode> st = new Stack<>();
        TreeNode last = null;
        head = head.left;
        while (!st.isEmpty() || head != null){
            if (head == null){
                head = st.pop();
                if (last != null && last.value > head.value){
                    return false;
                }
                last = head;
                head = head.right;
            } else {
                st.push(head);
                head = head.left;
            }
        }
        return true;
    }
}
