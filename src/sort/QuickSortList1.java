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
        ListNode h1 = myQuickSortList(dummy.next);//partition后，head位置已经改变
        ListNode h2 = myQuickSortList(head2);
        dummy.next = h1;//h1有可能为null，用dummy做头结点连接
        p = dummy;
        while (p.next != null) {
            p = p.next;
        }
        p.next = pivot;
        pivot.next = h2;
        return dummy.next;
    }
    public ListNode partition(ListNode dummy) {
        if (dummy.next == null || dummy.next.next == null) {
            return dummy.next;
        }
        ListNode prePivot = dummy;
        ListNode preP = dummy.next;
        ListNode preI = preP;
        while (preI.next != null){
            if (preI.next.val < prePivot.next.val) {
                if (preP.next == preI){//如果preP和preI相邻，交换后preI不需要后移
                    swap(preP,preI);
                } else {
                    swap(preP,preI);
                    preI = preI.next;
                }
                preP = preP.next;
            } else {
                preI = preI.next;
            }
        }
        ListNode prePreP = dummy;
        ListNode p = preP.next;//preP和Pivot交换后，找不到P
        while (prePreP.next != preP) {
            prePreP = prePreP.next;
        }
        if (prePivot.next == prePreP){//如果prePivot和prePreP相邻，交换后，prePreP改变位置
            swap(prePivot, prePreP);
            return prePreP;
        } else {
            swap(prePivot, prePreP);
            return prePreP.next;
        }
    }

    public void swap(ListNode preN1, ListNode preN2) {
        if (preN1 == preN2) {
            return;
        }
        ListNode n1 = preN1.next;
        ListNode n2 = preN2.next;
        ListNode posN1 = n1.next;
        ListNode posN2 = n2.next;
        if (n1.next == n2) {
            preN1.next = n2;
            n2.next = n1;
            n1.next = posN2;
        }else if(n2.next == n1){
            preN2.next = n1;
            n1.next = n2;
            n2.next = posN1;
        }else {
            preN1.next = n2;
            n2.next = posN1;
            preN2.next = n1;
            n1.next = posN2;
        }
    }
}
