package linkedlist;

/**
* 
*
* @author zfk
* @date 2019年11月4日 下午9:15:31 
* 
*/
public class SwapNodes {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        SwapNodes o = new SwapNodes();
        n1 = o.mySwapNodes1(n1,3,6);
        System.out.println(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }
    
    public ListNode mySwapNodes1(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode pre1 = null;
        ListNode pos2 = null;
        ListNode cur = dummy;
        while (m > 1 && cur.next != null) {
            cur = cur.next;
            m--;
        }
        if (m > 1) {
            return null;
        }else {
            p1 = cur.next;
            pre1 = cur;
        }
        cur = dummy;
        while (n > 1 && cur.next != null) {
            cur = cur.next;
            n--;
        }
        if (n > 1) {
            return null;
        }else {
            p2 = cur.next;
            pos2 = cur.next.next;
        }
        if (p1.next == p2) {
            pre1.next = p2;
            p2.next = p1;
            p1.next = pos2;
        }else {
            pre1.next = p2;
            p2.next = p1.next;
            p1.next = pos2;
            cur.next = p1;
        }
        return dummy.next;
                
    }
    
    public ListNode mySwapNodes2(ListNode head, int v1, int v2) {
        if (head == null || v1 == v2) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode pre1 = null;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == v1 || cur.next.val == v2) {
                if (p1 == null) {
                    p1 = cur.next;
                    pre1 = cur;
                }else {
                    ListNode pos2 = cur.next.next;
                    p2 = cur.next;
                    pre1.next = p2;
                    if (p1 == cur) {
                        p2.next = p1;
                        p1.next = pos2;
                    }else {
                        p2.next = p1.next;
                        p1.next = pos2;
                        cur.next = p1;
                    }
                    return dummy.next;
                }
            }
            cur = cur.next;
        }
        return dummy.next;
                
                
    }
}
