package algorithms.tree;

/**
 * 返回按中序遍历顺序的该节点的后继节点
 * 如果节点和后继节点的距离为L,则时间复杂度为O(L)
 */
public class GetNextNode {
    
    public static void main(String[] args){
        GetNextNode o = new GetNextNode();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        node6.left = node3;
        node6.right = node9;
        node3.parent = node6;
        node9.parent = node6;
        node3.left = node1;
        node3.right = node4;
        node1.parent = node3;
        node4.parent = node3;
        node9.left = node8;
        node9.right = node10;
        node8.parent = node9;
        node10.parent = node9;
        node1.right = node2;
        node2.parent = node1;
        node4.right = node5;
        node5.parent = node4;
        node8.left = node7;
        node7.parent = node8;
        System.out.println(o.getNextNode(node1));
        System.out.println(o.getNextNode(node2));
        System.out.println(o.getNextNode(node3));
        System.out.println(o.getNextNode(node4));
        System.out.println(o.getNextNode(node5));
        System.out.println(o.getNextNode(node6));
        System.out.println(o.getNextNode(node7));
        System.out.println(o.getNextNode(node8));
        System.out.println(o.getNextNode(node9));
        System.out.println(o.getNextNode(node10));
    }

    private TreeNode getNextNode(TreeNode node) {
        if (node == null) return node;
        if (node.right != null){//1.节点有右子树，后继节点是右子树最左节点
            TreeNode r = node.right;
            while (r.left != null) {
                r = r.left;
            }
            return r;
        }
        TreeNode p = node.parent;
        TreeNode cur = node;
        /**
         * 2.节点没有右子树，一直找父节点，如果一个节点是父节点的左孩子，则后继节点是这个父节点
         * 3.找不到父节点，后继节点为空
         */
        while (p != null && p.left != cur){
            cur = p;
            p = p.parent;
        }
        return p;
    }
}
