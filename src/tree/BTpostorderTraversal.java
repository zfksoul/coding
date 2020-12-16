package tree;

import pack.Pack2d01;

import java.util.*;

/**
 * 后序遍历
 *      1
 *    2  3
 *  4 5 6 7
 */
public class BTpostorderTraversal {
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
        BTpostorderTraversal o = new BTpostorderTraversal();
        System.out.println(o.postOrder1(node1));
        o.postOrder2(node1);
    }
    //后序时，先遍历右，再遍历左，最后将得到的结果反向
    public List<Integer> postOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> st = new LinkedList<>();
        TreeNode p = root;
        while (p != null || st.size() != 0){
            while (p != null){
                res.add(p.val);
                st.push(p);
                p = p.right;
            }
            if (st.size() != 0){
                p = st.pop();
                p = p.left;
            }
        }
        Collections.reverse(res);
        return res;

    }
    public List<Integer> postOrder1(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> st = new LinkedList<>();
        TreeNode p = root;
        while (p != null || st.size() > 0){
            while (p != null) {
                st.push(p);
                res.add(p.val);
                p = p.right;
            }
            if (st.size() > 0){
                p = st.pop();
                p = p.left;
            }
        }
        Collections.reverse(res);
        return res;
    }
    //递归
    public void postOrder2(TreeNode root){
        if (root == null) return;
        postOrder2(root.left);
        postOrder2(root.right);
        System.out.print(root.val + " ");
    }
}
