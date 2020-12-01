package linkedlist;

/**
* 
*
* @author zfk
* @date 2019年10月26日 下午9:23:52 
* 从右边翻转第n个节点
* 1,2,3,4,5-->4,5,1,2,3
*/
public class RotateRight {

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
        RotateRight o = new RotateRight();
        n1 = o.myRotateRight1(n1,4);
        System.out.println(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }
    public ListNode myRotateRight(ListNode head, int k) {
        if (head == null || k < 0){
            return null;
        }
        ListNode p = head, q = head;
        int n = 0;
        while(p != null) {
            p = p.next;
            n++;
        }
        p = head;
        k %= n;
        while(k > 0) {
            q = q.next;
            k--;
        }
        while(q.next != null) {
            q = q.next;
            p = p.next;
        }
        q.next = head;
        head = p.next;
        p.next = null;
        return head;
    }

    public ListNode myRotateRight1(ListNode head, int k) {
        if (head == null || k < 0){
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        int cnt = 1;
        while (p.next != null){
            p = p.next;
            cnt++;
        }
        k %= cnt;
        p = head;
        while (k > 0){
            q = q.next;
            k--;
        }
        while (q.next != null){
            p = p.next;
            q = q.next;
        }
        q.next = head;
        head = p.next;
        p.next = null;
        return head;
    }

}
