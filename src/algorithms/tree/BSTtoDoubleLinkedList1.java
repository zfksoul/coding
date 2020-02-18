package algorithms.tree;

public class BSTtoDoubleLinkedList1 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node4.left = node2;
        node4.right = node6;
        node2.left = node1;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        BSTtoDoubleLinkedList1 o = new BSTtoDoubleLinkedList1();
        TreeNode node = o.convert(node4);
        while (node.right != null) {
            System.out.println(node);
            node = node.right;
        }
        System.out.println(node);
        System.out.println("-------");
        while (node.left != null) {
            System.out.println(node);
            node = node.left;
        }
        System.out.println(node);
    }

    private TreeNode convert(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tail = process(root);
        TreeNode res = tail.right;
        tail.right = null;
        return res;
    }

    private TreeNode process(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode lr = process(root.left);
        TreeNode rr = process(root.right);
        TreeNode ll = null;
        TreeNode rl = null;
        if (lr != null && rr != null){
            ll = lr.right;
            rl = rr.right;
            lr.right = root;
            root.left = lr;
            rl.left = root;
            root.right = rl;
            rr.right = ll;
            return rr;
        } else if (lr != null){
            ll = lr.right;
            lr.right = root;
            root.left = lr;
            root.right = ll;
            return root;
        } else if (rr != null){
            rl = rr.right;
            rl.left = root;
            root.right = rl;
            rr.right = root;
            return rr;
        } else {
            root.right = root;
            return root;
        }
    }
}