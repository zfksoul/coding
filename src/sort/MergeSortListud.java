package sort;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月28日 下午9:31:07
 * 
 */
public class MergeSortListud {

    public static void main(String[] args) {
        MergeSortListud o = new MergeSortListud();

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(11);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(10);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode node = o.myMergeSortListud1(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    // 自顶向下+链表
    // 时间复杂度O（nlogn）
    // 空间复杂度O(logn)：使用链表就不需要辅助空间把有序序列归并，对链表指针操作就可以
    public ListNode myMergeSortListud1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode f = head;//快指针，f起始位置比s多1，确保s位于（l+r）/2，而不是（l+r+1）/2
        ListNode s = head;//慢指针
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }
        ListNode head2 = s.next;
        s.next = null;
        head = myMergeSortListud1(head);
        head2 = myMergeSortListud1(head2);
        return merge1(head, head2);
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
    

    public ListNode myMergeSortListud2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode f = head;
        ListNode s = head;
        while (f.next != null && f.next.next != null){
            f = f.next.next;
            s = s.next;
        }
        ListNode head2 = s.next;
        s.next = null;
        head = myMergeSortListud2(head);
        head2 = myMergeSortListud2(head2);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (head != null && head2 != null){
            if (head.val <= head2.val){
                cur.next = head;
                head = head.next;
                cur = cur.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
                cur = cur.next;
            }
        }
        if (head != null) cur.next = head;
        if (head2 != null) cur.next = head2;
        return dummy.next;
    }
    public ListNode myMergeSortListud3(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode f = head;
        ListNode s = head;
        while (f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }
        ListNode head2 = s.next;
        s.next = null;
        head = myMergeSortListud3(head);
        head2 = myMergeSortListud3(head2);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (head != null && head2 != null){
            if (head.val <= head2.val){
                cur.next = head;
                head = head.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head != null){
            cur.next = head;
        }
        if (head2 != null){
            cur.next = head2;
        }
        return dummy.next;
    }
}
