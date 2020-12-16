package algorithms.tree;

import java.util.LinkedList;
import java.util.Stack;

public class BTTraversal {
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
        BTTraversal o = new BTTraversal();
        /*o.preOrder(node4);
        o.preOrder1(node4);
        o.preOrder2(node4);
        o.preOrderRecur(node4);*/
        /*o.inOrder(node4);
        o.inOrder1(node4);
        o.inOrderRecur(node4);*/
        o.posOrder(node4);
        o.posOrder1(node4);
        o.posOrder2(node4);
        o.posOrder3(node4);
        o.posOrderRecur(node4);
    }

    public void preOrder(TreeNode head){
        System.out.println("preOrderUnRecur:");
        if (head == null){
            return;
        }
        LinkedList<TreeNode> st = new LinkedList<>();
        st.push(head);
        while (!st.isEmpty()){
            head = st.pop();
            System.out.print(head.value + " ");
            if (head.right != null){
                st.push(head.right);
            }
            if (head.left != null){
                st.push(head.left);
            }
        }
        System.out.println();
    }
    public void preOrder1(TreeNode head){
        if (head == null){
            return;
        }
        LinkedList<TreeNode> st = new LinkedList<>();
        while(!st.isEmpty() || head != null){
            if (head != null){
                System.out.print(head.value + " ");
                st.push(head);
                head = head.left;
            } else {
                head = st.pop();
                head = head.right;
            }
        }
        System.out.println();
    }
    private void preOrder2(TreeNode head) {
        if (head == null) return;
        LinkedList<TreeNode> st = new LinkedList<>();
        while (head != null || !st.isEmpty()){
            while (head != null){
                System.out.print(head.value + " ");
                st.push(head);
                head = head.left;
            }
            if (!st.isEmpty()){
                head = st.pop();
                head = head.right;
            }
        }
        System.out.println();
    }

    public void preOrderRecur(TreeNode head){
        if (head == null){
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    public void inOrder(TreeNode head){
        System.out.println("inOrderUnRecur:");
        if (head == null){
            return;
        }
        LinkedList<TreeNode> st = new LinkedList<>();
        while (!st.isEmpty() || head != null){
            if (head != null){
                st.push(head);
                head = head.left;
            } else {
                head = st.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
        System.out.println();
    }
    public void inOrder1(TreeNode head){
        if (head == null) return;
        LinkedList<TreeNode> st = new LinkedList<>();
        while (head != null || !st.isEmpty()){
            while(head != null){
                st.push(head);
                head = head.left;
            }
            head = st.pop();
            System.out.print(head.value + " ");
            head = head.right;
        }
        System.out.println();
    }
    public void inOrderRecur(TreeNode head){
        if (head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }
    public void posOrder(TreeNode head){
        System.out.println("posOrderUnRecur1:");
        if (head == null){
            return;
        }
        LinkedList<TreeNode> st1 = new LinkedList<>();
        LinkedList<TreeNode> st2 = new LinkedList<>();
        st1.push(head);
        while (!st1.isEmpty()){
            head = st1.pop();
            st2.push(head);
            if (head.left != null){
                st1.push(head.left);
            }
            if (head.right != null){
                st1.push(head.right);
            }
        }
        while (!st2.isEmpty()){
            System.out.print(st2.pop().value + " ");
        }
        System.out.println();
    }
    public void posOrder1(TreeNode head){
        if (head == null){
            return;
        }
        LinkedList<TreeNode> st1 = new LinkedList<>();
        LinkedList<TreeNode> st2 = new LinkedList<>();
        while(!st1.isEmpty() || head != null){
            if (head != null){
                st1.push(head);
                st2.push(head);
                head = head.right;
            } else {
                head = st1.pop();
                head = head.left;
            }
        }
        while (!st2.isEmpty()){
            head = st2.pop();
            System.out.print(head.value + " ");
        }
        System.out.println();
    }
    public void posOrder2(TreeNode head){
        System.out.println("posOrderUnRecur2:");
        if (head == null){
            return;
        }
        LinkedList<TreeNode> st = new LinkedList<>();
        st.push(head);
        TreeNode last = head;//标记上一个打印的节点,last=head防止特殊情况，如果last=null，可能出现null==null
        TreeNode cur = null;//判断当前节点
        while (!st.isEmpty()){
            cur = st.peek();
            if (cur.left != null && last != cur.left && last != cur.right){//左边有节点且左子树没打印完
                st.push(cur.left);
            } else if (cur.right != null && last != cur.right){//右边有节点且右子树没打印完
                st.push(cur.right);
            } else {//左右子树都打印完
                System.out.print(st.pop().value + " ");
                last = cur;
            }
        }
        System.out.println();
    }


    public void posOrder3(TreeNode head){
        if (head == null) return;
        LinkedList<TreeNode> st = new LinkedList<>();
        TreeNode last = head;
        TreeNode cur;
        st.push(head);
        while (!st.isEmpty()){
            cur = st.peek();
            if (cur.left != null && last != cur.left && last != cur.right){
                st.push(cur.left);
            } else if (cur.right != null && last != cur.right){
                st.push(cur.right);
            } else {
                System.out.print(cur.value + " ");
                st.pop();
                last = cur;
            }
        }
        System.out.println();
    }
    public void posOrderRecur(TreeNode head){
        if (head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }
}
