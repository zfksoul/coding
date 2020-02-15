package algorithms.list;

public class MergeTwoList {
    public static void main(String[] args){
        MergeTwoList o = new MergeTwoList();
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node7 = new ListNode(7);
        node1.next = node3;
        node3.next = node5;
        node5.next = node7;
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode node8 = new ListNode(8);
        node2.next = node4;
        node4.next = node6;
        node6.next = node8;
        o.Merge(node1, node2);
        while (node1 != null){
            System.out.println(node1);
            node1 = node1.next;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        } else if (list2 == null){
            return list1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (list1 != null && list2 != null){
            if (list1.value <= list2.value){
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            } else {
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }
        }
        if (list1 != null){
            p.next = list1;
        }
        if (list2 != null){
            p.next = list2;
        }
        return dummy.next;
    }
}
