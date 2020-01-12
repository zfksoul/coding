package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//先序遍历二叉树
public class BTpreorderTraversal {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right =node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        BTpreorderTraversal o = new BTpreorderTraversal();
        System.out.println(o.preOrder3(node1));
        o.preOrder2(node1);
    }
    //迭代
    public List<Integer> preOrder1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        //对于前序遍历，需要一直往二叉树的左子树上走，直道左子树走完。在走左子树的过程中需要输出遇到节点的值
        while (p != null || st.size() != 0){
            while (p != null){
                res.add(p.val);
                st.push(p);
                p = p.left;
            }
            //左边节点都走完了，需要改变节点方向
            if (st.size() != 0){
                p = st.pop();
                p = p.right;
            }
        }
        return res;
    }
    public List<Integer> preOrder3(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        TreeNode p = root;
        while (p != null || st.size() != 0){
            while (p != null){
                list.add(p.val);
                st.push(p);
                p = p.left;
            }
            p = st.pop();
            p = p.right;
        }
        return list;

    }
    //递归
    public void preOrder2(TreeNode root){
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder2(root.left);
        preOrder2(root.right);
    }
}
