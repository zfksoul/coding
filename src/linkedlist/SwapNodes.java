package linkedlist;

/**
* 
*
* @author zfk
* @date 2019年11月4日 下午9:15:31 
* 交换第m和第n个节点,m<n
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
        ListNode p1 = null;//m节点
        ListNode p2 = null;//n节点
        ListNode pre1 = null;//m前一个节点
        ListNode pos2 = null;//n后一个节点
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
    
    public ListNode mySwapNodes2(ListNode head, int m, int n) {
        if (head == null || m == n){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1;
        ListNode p2;
        ListNode pre1;
        ListNode pos2;
        ListNode cur = dummy;
        while (m > 1 && cur.next != null){
            m--;
            cur = cur.next;
        }
        if (m > 1){
            return null;
        }
        pre1 = cur;
        p1 = cur.next;
        cur = dummy;
        while (n > 1 && cur.next != null){
            n--;
            cur = cur.next;
        }
        if (n > 1){
            return null;
        }
        p2 = cur.next;
        pos2 = p2.next;
        if (p1.next == p2){
            pre1.next = p2;
            p2.next = p1;
            p1.next = pos2;
        } else {
            pre1.next = p2;
            p2.next = p1.next;
            p1.next = pos2;
            cur.next = p1;
        }
        return dummy.next;
    }
}
