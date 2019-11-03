package Sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月28日 下午9:31:07
 * 
 */
public class MergeSortList1 {

    public static void main(String[] args) {
        MergeSortList1 o = new MergeSortList1();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode node = o.myMergeSortList1(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    // 自顶向下+链表
    // 时间复杂度O（nlogn）
    // 空间复杂度O(logn)：使用链表就不需要辅助空间把有序序列归并，对链表指针操作就可以
    public ListNode myMergeSortList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode c = dummy;
        ListNode p1 = head;
        ListNode p2 = s.next;
        s.next = null;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                c.next = p1;
                c = c.next;
                p1 = p1.next;
            } else {
                c.next = p2;
                c = c.next;
                p2 = p2.next;
            }
        }
        if (p1 != null) {
            c.next = p1;
        }
        if (p2 != null) {
            c.next = p2;
        }
        return dummy.next;
    }

}
