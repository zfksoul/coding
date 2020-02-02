package algorithms.tree;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定数组，没有重复元素，构造MaxTree
 * MaxTree是二叉树，父节点大于子节点
 */
public class MaxTree {
    public static void main(String[] args){
        MaxTree o = new MaxTree();
        int[] arr = {3,4,5,1,2};
        System.out.print(o.getMaxTree(arr));
    }

    public TreeNode getMaxTree(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        TreeNode[] nArr = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++){
            nArr[i] = new TreeNode(arr[i]);
        }
        Stack<TreeNode> st = new Stack<>();
        HashMap<TreeNode, TreeNode> lBigMap = new HashMap<>();
        HashMap<TreeNode, TreeNode> rBigMap = new HashMap<>();
        for (int i = 0; i < nArr.length; i++){
            TreeNode cur = nArr[i];
            while ((!st.empty()) && st.peek().value < cur.value){
                popStackSetMap(st, lBigMap);
            }
            st.push(cur);
        }
        while (!st.empty()){
            popStackSetMap(st, lBigMap);
        }
        for (int i = nArr.length - 1; i >= 0; i--){
            TreeNode cur = nArr[i];
            while ((!st.empty()) && st.peek().value < cur.value){
                popStackSetMap(st, rBigMap);
            }
            st.push(cur);
        }
        while (!st.empty()){
            popStackSetMap(st, rBigMap);
        }
        TreeNode head = null;
        for (int i = 0; i < nArr.length; i++){
            TreeNode cur = nArr[i];
            TreeNode left = lBigMap.get(cur);
            TreeNode right = rBigMap.get(cur);
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

    private void popStackSetMap(Stack<TreeNode> st, HashMap<TreeNode, TreeNode> map) {
        TreeNode node = st.pop();
        if (st.empty()){
            map.put(node, null);
        } else {
            map.put(node, st.peek());
        }
    }
}
