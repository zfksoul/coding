package algorithms.tree;

public class BSTtoDoubleLinkedList {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node4.left = node2;
        node4.right =node6;
        node2.left = node1;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        BSTtoDoubleLinkedList o = new BSTtoDoubleLinkedList();
        TreeNode node = o.convert(node4);
        while (node.right != null){
            System.out.println(node);
            node = node.right;
        }
        System.out.println(node);
        System.out.println("-------");
        while (node.left != null){
            System.out.println(node);
            node = node.left;
        }
        System.out.println(node);
    }

    private TreeNode convert(TreeNode node1) {
        if (node1 == null){
            return null;
        }
        TreeNode last =  process(node1);
        TreeNode head = last.right;
        last.right = null;
        return head;
    }

    private TreeNode process(TreeNode head) {
        if (head == null){
            return null;
        }
        TreeNode lr = process(head.left);
        TreeNode rr = process(head.right);
        TreeNode ll = lr == null ? null : lr.right;
        TreeNode rl = rr == null ? null : rr.right;
        if (lr == null && rr == null){
            head.right = head;
            return head;
        } else if (lr == null && rr != null){
            head.right = rl;
            rl.left = head;
            rr.right = head;
            return rr;
        } else if (lr != null && rr == null){
            head.left = lr;
            lr.right = head;
            head.right = ll;
            return head;
        } else {
            head.left = lr;
            lr.right = head;
            head.right = rl;
            rl.left = head;
            rr.right = ll;
            return rr;
        }
    }
}
