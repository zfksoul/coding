package algorithms.list;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public static void main(String[] args){
        DeleteDuplication o = new DeleteDuplication();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        System.out.println(o.deleteDuplication(n1));
    }
    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null){
            ListNode q = p.next;
            while (q != null && q.value == p.next.value){
                q = q.next;
            }
            if (p.next.next == q){
                p = p.next;
            } else {
                p.next = q;
            }
        }
        return dummy.next;
    }
}
