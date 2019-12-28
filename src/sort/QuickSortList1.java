package sort;

/**
* 
*
* @author zfk
* @date 2019年11月3日 下午8:13:50 
* 
*/
public class QuickSortList1 {

    public static void main(String[] args) {
        QuickSortList1 o = new QuickSortList1();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
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
        ListNode node = o.myQuickSortList(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
    
    //基于链表实现的快速排序
    public ListNode myQuickSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pivot = partition(dummy);
        ListNode head2 = pivot.next;
        ListNode p = dummy;
        while (p.next != pivot) {
            p = p.next;
        }
        p.next = null;
        ListNode h1 = myQuickSortList(dummy.next);
        ListNode h2 = myQuickSortList(head2);
        dummy.next = h1;
        ListNode n1 = dummy;
        while (n1.next != null) {
            n1 = n1.next;
        }
        n1.next = pivot;
        pivot.next = h2;
        return dummy.next;
    }
    public ListNode partition(ListNode dummy) {
        if (dummy.next == null || dummy.next.next == null) {
            return dummy.next;
        }
        ListNode prePivot = dummy;
        ListNode preP = dummy.next;
        for (ListNode preI = preP; preI.next != null; preI = preI.next) {
            if (preI.next.val < prePivot.next.val) {
                swap(preP,preI);
                preP = preP.next;
            }
        }
        ListNode prePreP = dummy;
        ListNode p = preP.next;
        while (prePreP.next != preP) {
            prePreP = prePreP.next;
        }
        swap(prePivot,prePreP);
        while (preP.next != p) {
            preP = preP.next;
        }
        return preP;
    }
    public void swap(ListNode preN1, ListNode preN2) {
        if (preN1 == preN2) {
            return;
        }
        ListNode n1 = preN1.next;
        ListNode n2 = preN2.next;
        
        ListNode k = n2.next;
        if (n1.next == n2) {
            preN1.next = n2;
            n2.next = n1;
            n1.next = k; 
        }else {
            preN1.next = n2;
            n2.next = n1.next;
            n1.next = k;
            preN2.next = n1; 
        }
    }
}
