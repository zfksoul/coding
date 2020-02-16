package algorithms.tree;

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
        //o.preOrderUnRecur(node4);
        //o.preOrderUnRecur1(node4);
        //o.preOrderRecur(node4);
        //o.inOrderUnRecur(node4);
        //o.inOrderUnRecur1(node4);
        //o.inOrderRecur(node4);
        //o.posOrderUnRecur1(node4);
        o.posOrderUnRecur2(node4);
        o.posOrderUnRecur3(node4);
        o.posOrderUnRecur4(node4);
        o.posOrderRecur(node4);
    }

    public void preOrderUnRecur(TreeNode head){
        System.out.println("preOrderUnRecur:");
        if (head == null){
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(head);
        while (!st.empty()){
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
    public void preOrderUnRecur1(TreeNode head){
        if (head == null){
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        while(!st.empty() || head != null){
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
    public void preOrderRecur(TreeNode head){
        if (head == null){
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    public void inOrderUnRecur(TreeNode head){
        System.out.println("inOrderUnRecur:");
        if (head == null){
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        while (!st.empty() || head != null){
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
    public void inOrderUnRecur1(TreeNode head){
        if (head == null){
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        while (!st.empty() || head != null){
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
    public void inOrderRecur(TreeNode head){
        if (head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }
    public void posOrderUnRecur1(TreeNode head){
        System.out.println("posOrderUnRecur1:");
        if (head == null){
            return;
        }
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(head);
        while (!st1.empty()){
            head = st1.pop();
            st2.push(head);
            if (head.left != null){
                st1.push(head.left);
            }
            if (head.right != null){
                st1.push(head.right);
            }
        }
        while (!st2.empty()){
            System.out.print(st2.pop().value + " ");
        }
        System.out.println();
    }
    public void posOrderUnRecur2(TreeNode head){
        System.out.println("posOrderUnRecur2:");
        if (head == null){
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(head);
        TreeNode p = head;//标记上一个打印的节点,p=head防止特殊情况，如果p=null，可能出现null==null
        TreeNode c = null;//判断当前节点
        while (!st.empty()){
            c = st.peek();
            if (c.left != null && p != c.left && p != c.right){//左边有节点且左子树没打印完
                st.push(c.left);
            } else if (c.right != null && p != c.right){//右边有节点且右子树没打印完
                st.push(c.right);
            } else {//左右子树都打印完
                System.out.print(st.pop().value + " ");
                p = c;
            }
        }
        System.out.println();
    }

    public void posOrderUnRecur3(TreeNode head){
        if (head == null){
            return;
        }
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        while(!st1.empty() || head != null){
            if (head != null){
                st1.push(head);
                st2.push(head);
                head = head.right;
            } else {
                head = st1.pop();
                head = head.left;
            }
        }
        while (!st2.empty()){
            head = st2.pop();
            System.out.print(head.value + " ");
        }
        System.out.println();
    }
    public void posOrderUnRecur4(TreeNode head){
        if (head == null){
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode last = head;
        st.push(head);
        while (!st.empty()){
            head = st.peek();
            if (head.left != null && head.left != last && head.right != last){
                head = head.left;
                st.push(head);
            } else if (head.right != null && head.right != last){
                head = head.right;
                st.push(head);
            } else {
                System.out.print(st.pop().value + " ");
                last = head;
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
