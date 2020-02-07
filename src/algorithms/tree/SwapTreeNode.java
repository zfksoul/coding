package algorithms.tree;

import java.util.Stack;

public class SwapTreeNode {
    public static TreeNode swap(TreeNode head,  TreeNode t1, TreeNode t2){
        TreeNode[] parents = getTwoParents(head, t1, t2);
        TreeNode t1P = parents[0];
        TreeNode t1L = t1.left;
        TreeNode t1R = t1.right;
        TreeNode t2P = parents[1];
        TreeNode t2L = t2.left;
        TreeNode t2R = t2.right;
        if (t1 == head){
            if (t1 == t2P){//1.t1是t2父，t2只能是t1右孩子
                t1.left = t2L;
                t1.right = t2R;
                t2.left = t1L;
                t2.right = t1;
            } else if (t2P.left == t2){//2.t1不是t2父，t2是t2P左孩子
                t2.left = t1L;
                t2.right = t1R;
                t2P.left = t1;
                t1.left = t2L;
                t2.right = t2R;
            } else {//3.t1不是t2父，t2是t2P右孩子
                t2.left = t1L;
                t2.right = t1R;
                t2P.right = t1;
                t1.left = t2L;
                t1.right = t2R;
            }
            head = t2;
        } else if (t2 == head) {
            if (t1P == t2){//4.t2是t1父，t1只能是t2左孩子
                t2.left = t1L;
                t2.right = t1R;
                t1.left = t2;
                t1.right = t2R;
            } else if (t1 == t1P.left){//5.t2不是t1父，t1是t1P左孩子
                t1.left = t2L;
                t1.right = t2R;
                t1P.left = t2;
                t2.left = t1L;
                t2.right = t1R;
            } else {//6.t2不是t1父，t1是t1P右孩子
                t1.left = t2L;
                t1.right = t2R;
                t1P.right = t2;
                t2.left = t1L;
                t2.right = t1R;
            }
            head = t1;
        } else {
            if (t1 == t2P){//t1是t2父，t2只能是t1右孩子
                if (t1P.left == t1){//7.t1是t1P左孩子
                    t1P.left = t2;
                    t2.left = t1L;
                    t2.right = t1;
                    t1.left = t2L;
                    t1.right = t2R;
                } else {//8.t1是t1P右孩子
                    t1P.right = t2;
                    t2.left = t1L;
                    t2.right = t1;
                    t1.left = t2L;
                    t1.right = t2R;
                }
            } else if (t2 == t1P){//t2是t1父，t1只能是t2左孩子
                if (t2P.left == t2){//9.t2是t2P左孩子
                    t2P.left = t1;
                    t1.left = t2;
                    t1.right = t2R;
                    t2.left = t1L;
                    t2.right = t1R;
                } else {//10.t2是t2P右孩子
                    t2P.right = t1;
                    t1.left = t2;
                    t1.right = t2R;
                    t2.left = t1L;
                    t2.right = t1R;
                }
            } else {//t1和t2相互不是父节点
                if (t1P.left == t1){//t1是t1P左孩子
                    if (t2P.left == t2){//11.t2是t2P左孩子
                        t1P.left = t2;
                        t2.left = t1L;
                        t2.right = t1R;
                        t2P.left = t1;
                        t1.left = t2L;
                        t1.right = t2R;
                    } else {//12.t2是t2P右孩子
                        t1P.left = t2;
                        t2.left = t1L;
                        t2.right = t1R;
                        t2P.right = t1;
                        t1.left = t2L;
                        t1.right = t2R;
                    }
                } else {//t1是t1P右孩子
                    if (t2P.left == t2){//13.t2是t2P左孩子
                        t1P.right = t2;
                        t2.left = t1L;
                        t2.right = t1R;
                        t2P.left = t1;
                        t1.left = t2L;
                        t1.right = t2R;
                    } else {//14.t2是t2P右孩子
                        t1P.right = t2;
                        t2.left = t1L;
                        t2.right = t1R;
                        t2P.right = t1;
                        t1.left = t2L;
                        t1.right = t2R;
                    }
                }
            }

        }
        return head;
    }
    //中序遍历找到父节点
    public static TreeNode[] getTwoParents(TreeNode head, TreeNode t1, TreeNode t2){
        TreeNode[] parents = new TreeNode[2];
        if (head == null){
            return parents;
        }
        Stack<TreeNode> st = new Stack<>();
        while (!st.empty() || head != null){
            if (head != null){
                st.push(head);
                head = head.left;
            } else {
                head = st.pop();
                if (head.left == t1 || head.right == t1){
                    parents[0] = head;
                }
                if (head.left == t2 || head.right == t2){
                    parents[1] = head;
                }
                head = head.right;
            }
        }
        return parents;
    }
}
