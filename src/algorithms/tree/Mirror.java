package algorithms.tree;

public class Mirror {

    public void myMirror(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        myMirror(root.left);
        myMirror(root.right);
    }

}
