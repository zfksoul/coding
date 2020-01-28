package offer;

/**
* 
*
* @author zfk
* @date 2019年10月20日 上午9:34:35 
* 
*/
public class Solution15 {
    public ListNode ReverseList(ListNode head) {
        ListNode node = head;
        ListNode p = null;
        while (head != null) {
            node = head;
            head = head.next;
            node.next = p;
            p = node;
        }
        return node;
    }
}
