package tree;


import java.util.LinkedList;
import java.util.Stack;

/**
 * 判断二叉树是否对称
 */
public class SymmeticTree {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right =node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        SymmeticTree o = new SymmeticTree();
        System.out.println(o.isSymmetric1(node1));
        System.out.println(o.isSymmetric2(node1));
    }
    //迭代，左边：左中右遍历，右边：右中左遍历，两边做对称的中序遍历
    public boolean isSymmetric1(TreeNode root){
        if (root == null) return true;
        LinkedList<TreeNode> lst = new LinkedList<>();
        LinkedList<TreeNode> rst = new LinkedList<>();
        TreeNode l = root.left;
        TreeNode r = root.right;
        while (l != null || lst.size() > 0 || r != null || rst.size() > 0){
            while (l != null && r != null){
                lst.push(l);
                l = l.left;
                rst.push(r);
                r = r.right;
            }
            if ( l != null || r != null) {
                return false;//上一轮循环后，如果l或r不为空，则不对称
            }
            l = lst.pop();
            r = rst.pop();
            if (l.val != r.val) {
                return false;
            }
            l = l.right;
            r = r.left;
        }
        return true;
    }
    public boolean isSymmetric2(TreeNode root){
        if (root == null){
            return true;
        }
        LinkedList<TreeNode> lst = new LinkedList<>();
        LinkedList<TreeNode> rst = new LinkedList<>();
        TreeNode l = root.left;
        TreeNode r = root.right;
        while (l != null || lst.size() > 0 || r != null || rst.size() > 0){
            while (l != null && r != null){
                lst.push(l);
                l = l.left;
                rst.push(r);
                r = r.right;
            }
            if (l != null || r != null){
                return false;
            }
            l = lst.pop();
            r = rst.pop();
            if (l.val != r.val){
                return false;
            }
            l = l.right;
            r = r.left;
        }
        return true;
    }
    //递归
    public boolean isSymmetric3(TreeNode root){
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null || q == null){
            return (p == null && q == null);
        }
        return p.val == q.val && dfs(p.left,q.right) && dfs(p.right,q.left);
    }
}
