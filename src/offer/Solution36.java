package offer;

import binarysearch.FindDuplicate1;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class Solution36 {
    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n11 = new ListNode(11);
        ListNode n12 = new ListNode(12);
        ListNode n13 = new ListNode(13);
        ListNode n14 = new ListNode(14);
        ListNode n15 = new ListNode(15);
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n4;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        Solution36 o = new Solution36();
        System.out.println(o.FindFirstCommonNode(n1, n11));
    }
    public ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null){
            return null;
        }
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != p2){
            if (p1 == null){
                p1 = head2;
            } else {
                p1 = p1.next;
            }
            if (p2 == null){
                p2 = head1;
            } else {
                p2 = p2.next;
            }
            /*//如果没有相交会造成循环
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == null){
                p1 = head2;
            }
            if (p2 == null){
                p2 = head1;
            }*/



        }
        return p1;
    }
}
