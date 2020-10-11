package linkedlist;

import it.tt.Pair;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月27日 上午11:14:33 
 * 找到循环链表的入口节点
 */
public class DetectCycle {

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
        n6.next = n5;
        DetectCycle o = new DetectCycle();
        // n1 = o.myGetIntersectionNode1(n1, n11);
        n1 = o.myDetectCycle2(n1);
        System.out.println(n1);
    }

    public ListNode myDetectCycle1(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while (f != null) {
            f = f.next;
            s = s.next;
            if (f != null) {
                f = f.next;
            } else {
                return null;
            }
            if (s == f) {
                s = head;
                while (s != f) {
                    s = s.next;
                    f = f.next;
                }
                return s;
            }
        }
        return null;
    }

    public ListNode myDetectCycle2(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while (f != null){
            f = f.next;
            s = s.next;
            if (f != null){
                f = f.next;
            } else {
                return null;
            }
            if (f == s){
                s = head;
                while (f != s){
                    f = f.next;
                    s = s.next;
                }
                return s;
            }
        }
        return null;
    }
}
