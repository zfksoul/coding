package linkedlist;

/**
* 
*
* @author zfk
* @date 2019年10月20日 上午10:57:10 
* 
*/
public class ListNode {
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
