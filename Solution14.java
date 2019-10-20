package algorithms;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月19日 下午4:24:49
 * 
 */
public class Solution14 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        while (k > 1) {
            k--;
            p = p.next;
            if (p == null) {
                return null;
            }
        }
        while (p.next != null && q.next != null) {
            p = p.next;
            q = q.next;
        }
        return q;

    }

}
