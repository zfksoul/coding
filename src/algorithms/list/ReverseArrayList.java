package algorithms.list;

import java.util.ArrayList;

/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */

/**
 * 给定链表，返回相反方向的数组
 */
public class ReverseArrayList {
    public static void main(String[] args){
        ReverseArrayList o = new ReverseArrayList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(o.printListFromTailToHead(node1));
        while (node1 != null){
            System.out.println(node1);
            node1 = node1.next;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        if (head == null){
            return res;
        }
        ListNode tail = reverse(head);
        ListNode p = tail;
        while (p != null){
            res.add(p.value);
            p = p.next;
        }
        reverse(tail);
        return res;
    }
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        ListNode q = null;
        ListNode r = null;
        while (p != null){
            r = p.next;
            p.next = q;
            q = p;
            p = r;
        }
        return q;
    }
}
