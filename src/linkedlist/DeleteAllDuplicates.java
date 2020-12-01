package linkedlist;

/**
 * 把所有重复元素删除：把一段扫描出来，如果段长度大于1，全部删除
 */
public class DeleteAllDuplicates {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        DeleteAllDuplicates o = new DeleteAllDuplicates();
        n1 = o.myDeleteAllDuplicates2(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }
    private ListNode myDeleteAllDuplicates1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null){
            ListNode q = p.next;
            while (q != null && q.val == p.next.val){
                q = q.next;
            }
            if (p.next.next == q){//q指向了下一组数的起始位置
                p = p.next;
            } else {
                p.next = q;
            }
        }
        return dummy.next;
    }
    private ListNode myDeleteAllDuplicates2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null){
            ListNode q = p.next;
            while (q != null && q.val == p.next.val){
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

