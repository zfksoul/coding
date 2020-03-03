package algorithms.tree;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {
    public static void main(String[] args){
        IsSymmetrical o = new IsSymmetrical();
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(o.myIsSymmetrical(n1));
    }
    boolean myIsSymmetrical1(TreeNode head) {
        if (head == null){
            return true;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = head.left;
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        while (st != null && p != null){
            if (p != null){
                arr1.add(p.value);
                st.push(p);
                p = p.left;
            } else {
                p = st.pop();
                p = p.right;
            }
        }
        p = head.right;
        while (st != null && p != null){
            if (p != null){
                arr2.add(p.value);
                st.push(p);
                p = p.right;
            } else {
                p = st.pop();
                p = p.left;
            }
        }
        while (!arr1.isEmpty() && !arr2.isEmpty()){
            if (arr1.get(0) != arr2.get(0)){
                return false;
            }
            arr1.remove(0);
            arr2.remove(0);
        }
        return arr1.isEmpty() && arr2.isEmpty();
    }
    boolean myIsSymmetrical(TreeNode head) {
        if (head == null){
            return true;
        }
        return check(head.left, head.right);
    }
    public boolean check(TreeNode l, TreeNode r){
        if (l == null && r == null){
            return true;
        }
        if ((l != null && r == null) || (l == null && r != null) || l.value != r.value){
            return false;
        }
        return check(l.right, r.left) && check(l.left, r.right);
    }
}
