package algorithms.tree;

public class IsSubTree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        return process(root1, root2) || process(root1.left, root2) || process(root1.right, root2);
    }
    public boolean process(TreeNode root1, TreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.value == root2.value){
            return process(root1.left, root2.left) && process(root1.right, root2.right);
        } else {
            return false;
        }
    }
}
