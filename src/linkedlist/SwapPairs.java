package linkedlist;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月26日 下午10:35:38
 * 将2个相邻节点交换，最后如果是单个节点则不交换
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        SwapPairs o = new SwapPairs();
        n1 = o.mySwapPairs(n1);
        System.out.println(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }

    public ListNode mySwapPairs(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        head = node;
        ListNode p = null;
        ListNode q = null;
        while (node.next != null && node.next.next != null) {
            p = node.next;
            q = p.next;
            node.next = q;
            p.next = q.next;
            q.next = p;
            node = p;
        } 
        return head.next;
    }

}
