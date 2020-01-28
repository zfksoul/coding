package offer;

import java.util.ArrayList;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月12日 下午8:25:58
 * 
 */
public class Solution3 {

    public static void main(String[] args) {
        ListNode node = null;
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        Solution3 so = new Solution3();
        // ArrayList<Integer> arr = new ArrayList<Integer>();
        // System.out.println(arr);
        System.out.println(so.printListFromTailToHead(node));
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ListNode p = null;
        ListNode q = null;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (listNode == null) {
            return null;
        }
        while (listNode != null) {
            p = listNode;
            listNode = listNode.next;
            p.next = q;
            q = p;
        }
        while (q != null) {
            arr.add(q.val);
            q = q.next;
        }
        return arr;
    }

}


