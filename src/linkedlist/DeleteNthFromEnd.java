package linkedlist;

/**
* 
*
* @author zfk
* @date 2019年10月26日 下午7:11:13 
* 删除链表中倒数第n个节点
*/
public class DeleteNthFromEnd {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        DeleteNthFromEnd o = new DeleteNthFromEnd();
        n1 = o.myDeleteNthFromEnd(n1, 5);
        System.out.println(n1);
        while(n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }
    
    public ListNode myDeleteNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1 );
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        while(n > 0 && q.next!= null) {
            q = q.next;
            n--;
        }
        if (n > 0) {
            return null;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
    public ListNode myDeleteNthFromEnd1(ListNode head, int n) {
        if (head == null || n <= 0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        while (n > 0 && q.next != null){
            q = q.next;
            n--;
        }
        if (n > 0){
            return null;
        }
        while (q.next != null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }

}
