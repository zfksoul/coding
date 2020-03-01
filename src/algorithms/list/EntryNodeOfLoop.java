package algorithms.list;

import java.util.List;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        while (f.next != null && f.next.next != null){
            f = f.next.next;
            s = s.next;
            if (f == s){
                f = head;
                while (f != s){
                    f = f.next;
                    s = s.next;
                }
                return f;
            }
        }
        return null;
    }
}
