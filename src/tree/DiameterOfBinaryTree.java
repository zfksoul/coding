package tree;

//树中两点之间最长的路径，枚举所有最高点
public class DiameterOfBinaryTree {
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
        DiameterOfBinaryTree o = new DiameterOfBinaryTree();
        System.out.println(o.myDiameterOfBinaryTree(node1));
        System.out.println(o.dfs3(node1));
    }
    int res = 0;
    public int myDiameterOfBinaryTree(TreeNode root){
        dfs1(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right);//只加边，不加点
        return Math.max(left + 1, right + 1);
    }

    private int dfs1(TreeNode root) {
        if (root == null) return 0;
        int left = dfs1(root.left);
        int right = dfs1(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right)+1;//加1表示节点连接父节点的那条边，也可以表示该节点
    }

    //求树最大深度
    private int dfs3(TreeNode root){
        if (root == null) return 0;
        return 1 + Math.max(dfs3(root.left),dfs3(root.right));
    }
}
