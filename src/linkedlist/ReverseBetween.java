package linkedlist;

/**
* 
*
* @author zfk
* @date 2019年10月26日 下午11:47:15 
* 将链表中第m到n个节点反转
*/
public class ReverseBetween {

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
        ReverseBetween o = new ReverseBetween();
        n1 = o.myReverseBetween(n1,3,6);
        System.out.println(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }
    
    public ListNode myReverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (m == n) return head; 
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        while(m > 1 && p.next != null) {
            p = p.next;//p指向交换区间的前一个节点
            m--;
        }
        if (m > 1) {
            return null;
        }
        while(n >= 0 && q != null) {
            q = q.next;//q指向交换区间的下一个节点
            n--;
        }
        if (n >= 0) {
            return null;
        }
        ListNode a = p.next;
        ListNode b = a.next;
        while (b != q) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        p.next.next = q;
        p.next = a;
        return dummy.next;
    }

}
