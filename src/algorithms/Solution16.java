package algorithms;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月20日 上午9:34:35
 * 
 */
public class Solution16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode node = null;
        if(list1.val <= list2.val) {
            node = list1;
            node.next = Merge(list1.next,list2);
        }else {
            node = list2;
            node.next = Merge(list1,list2.next);
        }
        return node;
    }

    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode node = null;
        if (list1.val <= list2.val) {
            node = list1;
            list1 = list1.next;
        } else {
            node = list2;
            list2 = list2.next;
        }
        ListNode p = node;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                node = node.next;
                list1 = list1.next;
            } else {
                node.next = list2;
                node = node.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            node.next = list1;
        } else if (list2 != null) {
            node.next = list2;
        }
        return p;
    }
}
