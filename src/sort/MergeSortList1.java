package sort;

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
        ListNode node = o.myMergeSortList2(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    // 自顶向下+链表
    // 时间复杂度O（nlogn）
    // 空间复杂度O(logn)：使用链表就不需要辅助空间把有序序列归并，对链表指针操作就可以
    public ListNode myMergeSortList1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode f = head.next;
        ListNode s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        ListNode h = s.next;
        s.next = null;
        myMergeSortList1(head);
        myMergeSortList1(h);
        return merge1(head, h);
    }

    public ListNode merge1(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (n1.val <= n2.val) {
            n1.next = merge1(n1.next, n2);
            return n1;
        } else {
            n2.next = merge1(n1, n2.next);
            return n2;
        }
    }
    
    public ListNode myMergeSortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = head;
        ListNode f = head.next;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode begin = s.next;
        s.next = null;
        head = myMergeSortList2(head);
        begin = myMergeSortList2(begin);
        return merge2(head,begin);
    }
    public ListNode merge2(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                cur.next = n1;
                n1 = n1.next;
            }else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        if (n1 == null) {
            cur.next = n2;
        }
        if (n2 == null) {
            cur.next = n1;
        }
        return dummy.next;
    }

}
