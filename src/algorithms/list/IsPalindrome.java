package algorithms.list;

import java.util.Stack;

/**
 * 判断链表是否为回文结构
 */
public class IsPalindrome {
    public static void main(String[] args){
        IsPalindrome o = new IsPalindrome();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        System.out.println(o.myIsPalindromt(node1));
        System.out.println(o.myIsPalindromt1(node1));
        System.out.println(o.myIsPalindromt2(node1));
        System.out.println(o.myIsPalindromt3(node1));
        ListNode p = node1;
        while(p != null){
            System.out.print(p.value);
            p = p.next;
        }
    }

    //空间复杂度O(1)
    public boolean myIsPalindromt(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        ListNode n3 = null;
        while(n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;//右边
        n2 = head;//左边
        boolean res = true;
        while (n1 != null && n2 != null){
            if (n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
    //空间复杂度O(1)
    public boolean myIsPalindromt1(ListNode node) {
        if (node == null || node.next == null){
            return true;
        }
        ListNode f = node;
        ListNode s = node;
        while (f.next != null && f.next.next != null){
            f = f.next.next;
            s = s.next;
        }
        while (f.next != null){
            f = f.next;
        }
        ListNode p = s.next;;
        ListNode q = s;
        ListNode r;
        q.next = null;
        while (p != null){
            r = p.next;
            p.next = q;
            q = p;
            p = r;
        }
        p = node;
        boolean res = true;
        while (p.next != null && q.next != null){
            if (p.value != q.value){
                res = false;
                break;
            }
            p = p.next;
            q = q.next;
        }
        p = f;
        q = null;
        while (p != null){
            r = p.next;
            p.next = q;
            q = p;
            p = r;
        }
        return res;
    }
    //空间复杂O(n/2)
    public boolean myIsPalindromt2(ListNode node) {
        if (node == null || node.next == null){
            return true;
        }
        ListNode f = node;
        ListNode s = node;
        Stack<Integer> st = new Stack<>();
        while(f.next != null && f.next.next != null){
            f = f.next.next;
            s = s.next;
        }
        f = s.next;
        while (f != null){
            st.push(f.value);
            f = f.next;
        }
        f = node;
        while (!st.empty()){
            if (f.value != st.pop()){
                return false;
            }
            f = f.next;
        }
        return true;
    }
    //空间复杂O(n)
    public boolean myIsPalindromt3(ListNode node) {
        if (node == null || node.next == null){
            return true;
        }
        Stack<Integer> st = new Stack<>();
        ListNode p = node;
        while (p != null){
            st.push(p.value);
            p = p.next;
        }
        p = node;
        while(p != null){
            if (p.value != st.pop()){
                return false;
            }
            p = p.next;
        }
        return true;
    }

}
