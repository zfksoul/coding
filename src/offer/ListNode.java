package offer;

/**
* 
*
* @author zfk
* @date 2019年10月20日 上午10:57:10 
* 
*/
public class ListNode {
    int val;
    ListNode next = null;

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    ListNode(int val) {
        this.val = val;
    }
}
