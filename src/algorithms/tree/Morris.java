package algorithms.tree;

/**
 * Morris遍历二叉树，时间复杂度O(n)，空间复杂度O(1)
 * 将节点左链所有节点的先驱节点指向自己
 */
public class Morris {
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
        Morris o = new Morris();
        o.inOrder(node4);
        o.preOrder(node4);
        o.posOrder(node4);
    }
    public void inOrder(TreeNode head){
        if (head == null){
            return;
        }
        TreeNode cur1 = head;
        TreeNode cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if (cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if (cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {//cur2.right != cur1
                    cur2.right = null;
                }
            }
            System.out.print(cur1.value + " ");
            cur1 = cur1.right;
        }
        System.out.println();
    }
    public void preOrder(TreeNode head){
        if (head == null){
            return;
        }
        TreeNode cur1 = head;
        TreeNode cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if (cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if (cur2.right == null){
                    cur2.right = cur1;
                    System.out.print(cur1.value + " ");
                    cur1 = cur1.left;
                    continue;
                } else {//cur2.right != cur1
                    cur2.right = null;
                }
            } else {
                System.out.print(cur1.value + " ");
            }
            cur1 = cur1.right;
        }
        System.out.println();
    }
    public void posOrder(TreeNode head){
        if (head == null){
            return;
        }
        TreeNode cur1 = head;
        TreeNode cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if (cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if (cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {//cur2.right != cur1
                    cur2.right = null;
                    printEdge(cur1.left);
                }
            } 
            cur1 = cur1.right;
        }
        printEdge(head);
        System.out.println();
    }

    private void printEdge(TreeNode head) {
        TreeNode tail = reverseEdge(head);
        TreeNode cur = tail;
        while (cur != null){
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private TreeNode reverseEdge(TreeNode from) {
        TreeNode pre = null;
        TreeNode next = null;
        while (from != null){
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }
}
