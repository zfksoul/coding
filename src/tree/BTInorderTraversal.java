package tree;

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 *      1
 *    2  3
 *  4 5 6 7
 */
public class BTInorderTraversal {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right =node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        BTInorderTraversal o = new BTInorderTraversal();
        o.inorderTraversal3(node1);
        System.out.println(o.inorderTraversal1(node1));
    }
    //迭代,将整颗树的最左边一条链压入栈中，每次取栈顶元素，如果它有右边子树，则将右子树压入栈中
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        LinkedList<TreeNode> st = new LinkedList<>();
        TreeNode p = root;
        while (p != null || st.size() > 0){
            while (p != null){
                st.push(p);
                p = p.left;
            }
            p = st.pop();
            res.add(p.val);
            p = p.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal1(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> st = new LinkedList<>();
        TreeNode q = root;
        while (q != null || st.size() > 0){
            while (q != null){
                st.push(q);
                q = q.left;
            }
            q = st.pop();
            res.add(q.val);
            q = q.right;
        }
        return res;
    }
    //递归
    public void inorderTraversal3(TreeNode root){
        if (root == null) return;
        inorderTraversal3(root.left);
        System.out.print(root.val+" ");
        inorderTraversal3(root.right);
    }
}
