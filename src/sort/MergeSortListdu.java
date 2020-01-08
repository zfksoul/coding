package sort;

import java.util.LinkedList;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月28日 下午9:31:07
 * 
 */
public class MergeSortListdu {

    public static void main(String[] args) {
        MergeSortListdu o = new MergeSortListdu();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(2);
        /*
         * ListNode node6 = new ListNode(4); ListNode node7 = new ListNode(6); ListNode
         * node8 = new ListNode(8);
         */
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        /*
         * node5.next = node6; node6.next = node7; node7.next = node8;
         */
        ListNode node = o.myMergeSortListdu1(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    // 自底向上+链表
    // 时间复杂度分析：整个链表总共遍历 logn次，每次遍历的复杂度是 O(n)，所以总时间复杂度是 O(nlogn)。
    // 空间复杂度分析：整个算法没有递归，迭代时只会使用常数个额外变量，所以额外空间复杂度是 O(1)
    public ListNode myMergeSortListdu(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        int n = 0;
        for (ListNode p = head; p != null; p = p.next) {//计算链表长度
            n++;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (int i = 1; i < n; i *= 2) {// 每一段的长度
            ListNode begin = dummy;//第一个节点可能换位置，所以begin不能指向第一个节点
            for (int j = 0; j + i < n; j += i * 2) {// 判断本轮迭代是否结束
                // j + i < n：最后如果只有一段链表则不需要调整，但是数组不能这么判断
                ListNode first = begin.next;// 第一段开始
                ListNode second = first;
                for (int k = 0; k < i; k++) {
                    second = second.next;// 第二段开始
                }
                int f = 0;// 遍历第一段
                int s = 0;// 遍历第二段
                while (f < i && s < i && second != null) {// 合并一组
                    if (first.val <= second.val) {
                        begin.next = first;
                        begin = begin.next;
                        first = first.next;
                        f++;
                    } else {
                        begin.next = second;
                        begin = begin.next;
                        second = second.next;
                        s++;
                    }
                }
                /*while (f < i) {// 合并剩余部分
                    begin.next = first;
                    begin = begin.next;
                    first = first.next;
                    f++;
                }*/
                if (f < i){
                    begin.next = first;
                    while (f < i){
                        begin = begin.next;
                        f++;
                    }
                }
                /*while (s < i && second != null) {
                    begin.next = second;
                    begin = begin.next;
                    second = second.next;
                    s++;
                }*/
                if (s < i){
                    begin.next = second;
                    while (s < i && second != null){
                        begin = begin.next;
                        second = second.next;
                        s++;
                    }
                }
                begin.next = second;// 连接下一组的第一个节点
            }
        }
        return dummy.next;
    }
    public ListNode myMergeSortListdu1(ListNode head) {
        if (head == null || head.next == null) return head;
        int n = 0;
        for (ListNode p = head; p != null; p = p.next){
            n++;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin;
        ListNode first;
        ListNode second;
        for (int i = 1; i < n; i *= 2){
            begin = dummy;
            for (int j = 0; j + i < n; j += i * 2){
                first = begin.next;
                second = begin.next;
                for (int m = 0; m < i; m++){
                    second = second.next;
                }
                int f = 0;
                int s = 0;
                while (f < i && s < i && second != null){
                    if (first.val <= second.val){
                        begin.next = first;
                        begin = begin.next;
                        first = first.next;
                        f++;
                    } else {
                        begin.next = second;
                        begin = begin.next;
                        second = second.next;
                        s++;
                    }
                }
                if (f < i){
                    begin.next = first;
                    while (f < i && first != null){
                        begin = begin.next;
                        first = first.next;
                        f++;
                    }
                }
                if (s < i){
                    begin.next = second;
                    while (f < i && second != null){
                        begin = begin.next;
                        second = second.next;
                        s++;
                    }
                }
                begin.next = second;
            }
        }
        return dummy.next;
    }



}
