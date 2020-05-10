package algorithms.tree;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定数组，没有重复元素，构造MaxTree
 * MaxTree是二叉树，父节点大于子节点
 * 单调栈：查找每个数左侧第一个比它小的数
 * 单调队列：滑动窗口中的最值
 */
public class MaxTree1 {
    public static void main(String[] args){
        MaxTree1 o = new MaxTree1();
        int[] arr = {3,4,5,1,2};
        System.out.print(o.getMaxTree(arr));
    }

    public TreeNode getMaxTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode[] arrN = new TreeNode[arr.length];
        for (int i = 0; i < arrN.length; i++){
            arrN[i] = new TreeNode(arr[i]);
        }
        Stack<TreeNode> st = new Stack<>();
        HashMap<TreeNode, TreeNode> lmax = new HashMap<>();
        HashMap<TreeNode, TreeNode> rmax = new HashMap<>();
        for (int i = 0; i < arrN.length; i++){
            TreeNode cur = arrN[i];
            while (!st.isEmpty() && cur.value > st.peek().value){
                fun(st, lmax);
            }
            st.push(cur);
        }
        while (!st.isEmpty()){
            fun(st, lmax);
        }
        for (int i = arrN.length - 1; i >= 0; i--){
            TreeNode cur = arrN[i];
            while (!st.isEmpty() && cur.value > st.peek().value){
                fun(st, rmax);
            }
            st.push(cur);
        }
        while (!st.isEmpty()){
            fun(st, rmax);
        }
        TreeNode head = null;
        for (int i = 0; i < arrN.length; i++){
            TreeNode cur = arrN[i];
            TreeNode left = lmax.get(cur);
            TreeNode right = rmax.get(cur);
            if (left == null && right == null){
                head = cur;
            } else if (left == null){
                if (right.left == null){
                    right.left = cur;
                } else {
                    right.right = cur;
                }
            } else if (right == null){
                if (left.left == null){
                    left.left = cur;
                } else {
                    left.right = cur;
                }
            } else {
                TreeNode parent = left.value < right.value ? left : right;
                if (parent.left == null){
                    parent.left = cur;
                } else {
                    parent.right = cur;
                }
            }
        }
        return head;
    }

    private void fun(Stack<TreeNode> st, HashMap<TreeNode, TreeNode> map) {
        TreeNode node = st.pop();
        if (st.isEmpty()){
            map.put(node, null);
        } else {
            map.put(node, st.peek());
        }
    }
}
