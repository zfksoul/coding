package linkedlist;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月26日 下午11:15:09
 * 
 */
public class ReverseList {

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
        ReverseList o = new ReverseList();
        n1 = o.myReverseList(n1);
        System.out.println(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }

    public ListNode myReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode a = null;
        ListNode b;
        while (head != null) {
            b = head.next;
            head.next = a;
            a = head;
            head = b;
        }
        return a;
    }

}
