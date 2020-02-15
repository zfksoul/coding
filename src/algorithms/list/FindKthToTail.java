package algorithms.list;

public class FindKthToTail {
    public static void main(String[] args){
        FindKthToTail o = new FindKthToTail();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = o.myFindKthToTail(node1, 5);
        System.out.println(node);
    }
    public ListNode myFindKthToTail(ListNode head,int k) {
        if (head == null || k < 0){
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        while (k > 1 && f.next != null){
            f = f.next;
            k--;
        }
        if (k > 1){
            return null;
        }
        while (f.next != null){
            f = f.next;
            s = s.next;
        }
        return s;
    }
}
