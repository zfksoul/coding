package linkedlist;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月27日 上午9:46:07
 * 找到2个单链表的交点
 */
public class GetIntersectionNode {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n11 = new ListNode(6);
        ListNode n12 = new ListNode(6);
        ListNode n13 = new ListNode(6);
        ListNode n14 = new ListNode(6);
        ListNode n15 = new ListNode(6);
        n14.next = n15;
        n11.next = n12;
        n12.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        GetIntersectionNode o = new GetIntersectionNode();
        // n1 = o.myGetIntersectionNode1(n1, n11);
        n1 = o.myGetIntersectionNode2(n13, n14);
        System.out.println(n1);
        System.out.println(n1.val);
        /*
         * while (n1 != null) { System.out.println(n1.val); n1 = n1.next; }
         */
    }

    public ListNode myGetIntersectionNode3(ListNode head1, ListNode head2) {
        ListNode p = head1;
        ListNode q = head2;
        while (p != q) {
            if (p != null) p = p.next;
            else p = head2;
            if (q != null) q = q.next;
            else q = head1;
        }
        return p;
    }

    public ListNode myGetIntersectionNode1(ListNode head1, ListNode head2) {
        ListNode p = head1;
        ListNode q = head2;
        while (p != q) { //java中null == null返回true
            if (p.next != null && q.next != null) {
                p = p.next;
                q = q.next;
            } else if (p.next == null && q.next != null) {
                p = head2;
                q = q.next;
            } else if (p.next != null && q.next == null) {
                p = p.next;
                q = head1;
            } else {
                return null;
            }
        }
        return p;
    }
    public ListNode myGetIntersectionNode2(ListNode head1, ListNode head2) {
        ListNode p = head1;
        ListNode q = head2;
        while (p != q){
            if (p != null) {
                p = p.next;
            } else {
                p = head2;
            }
            if (q != null){
                q = q.next;
            } else {
                q = head1;
            }
        }
        return p;
    }


}
