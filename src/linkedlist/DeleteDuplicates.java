package linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月26日 下午8:37:26
 * 删除链表中重复的节点
 *
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        DeleteDuplicates o = new DeleteDuplicates();
        n1 = o.myDeleteDuplicates2(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }

    public ListNode myDeleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
    public ListNode myDeleteDuplicates2(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode p = head;
        while (p.next != null){
            if (p.val == p.next.val){
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
