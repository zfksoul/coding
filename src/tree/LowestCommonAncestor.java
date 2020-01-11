package tree;

//求两个节点的第一个公共祖先
public class LowestCommonAncestor {
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
        LowestCommonAncestor o = new LowestCommonAncestor();
        System.out.println(o.myLowestCommonAncestor(node1,node4,node7).val);
        System.out.println(o.myLowestCommonAncestor1(node1,node4,node7).val);
    }

    /**
     *
     * 返回值有四种：
     * 1.如果以root为根的子树中包含p和q，则返回它们的最近公共祖先
     * 2.如果root==p，则返回p
     * 3.如果root==q，则返回q
     * 4.如果都不包含，则返回null
     */
    public TreeNode myLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q) return root;
        TreeNode left = myLowestCommonAncestor(root.left, p, q);
        TreeNode right = myLowestCommonAncestor(root.right, p, q);
        /**
         * 当left返回空时：
         * 1.右边也都不包含，则right=null，最终需要返回null
         * 2.右边只包含p或q，则right=p或q，最终需要返回p或q
         * 3.右边同时包含p和q，则right是最近公共祖先，我们最终需要返回最近公共祖先
         * 不管right什么情况，返回都和right相同，所以返回right
         * right返回空时同上
         */
        if (left == null) return right;
        if (right == null) return left;
        /**
         * 如果left和right都不为null，说明left和right各包含一个，则root为最近公共祖先
         */
        return root;
    }

    public TreeNode myLowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q) return root;
        TreeNode left = myLowestCommonAncestor(root.left, p, q);
        TreeNode right = myLowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
