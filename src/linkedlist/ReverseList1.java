package linkedlist;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月26日 下午11:15:09
 * 翻转链表，以n个节点为一组
 * 
 */
public class ReverseList1 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        ReverseList1 o = new ReverseList1();
        n1 = o.myReverseList1(n1, 3);
        System.out.println(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }

    public ListNode myReverseList(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }
        ListNode p = null;
        ListNode q = head;
        ListNode r;
        int cnt = 1;
        while (true){
            while (q.next != null && cnt < n){//q指向段尾
                q = q.next;
                cnt++;
            }
            if (q.next == null){
                q.next = p;
                return head;
            } else {
                r = q.next;
                q.next = p;
                p = head;
                head = r;
                q = r;
                cnt = 1;
            }
        }
    }
    public ListNode myReverseList1(ListNode head, int n) {
        if (head == null || n <= 0){
            return null;
        }
        ListNode a = null;
        ListNode b = head;
        ListNode c;
        int cnt = 1;
        while (true){
            while (b.next != null && cnt < n){
                b = b.next;
                cnt++;
            }
            if (b.next == null){
                b.next = a;
                return head;
            } else {
                c = b.next;
                b.next = a;
                a = head;
                head = c;
                b = c;
                cnt = 1;
            }
        }
    }

}
