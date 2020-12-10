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
        int fc, sc;
        for (int l = 1; l < n; l *= 2) {// 每一段的长度
            ListNode cur = dummy;//第一个节点可能换位置，所以begin不能指向第一个节点
            for (int begin = 0; begin + l < n; begin += l * 2) {// 判断本轮迭代是否结束
                // begin + l < n：最后如果只有一段链表则不需要调整，但是数组不能这么判断
                ListNode f = cur.next;// 第一段开始
                ListNode s = cur.next;
                for (int k = 0; k < l; k++) {
                    s = s.next;// 第二段开始
                }
                fc = 0;// 遍历第一段
                sc = 0;// 遍历第二段
                while (fc < l && sc < l && s != null) {// 合并一组
                    if (f.val <= s.val) {
                        cur.next = f;
                        f = f.next;
                        fc++;
                    } else {
                        cur.next = s;
                        s = s.next;
                        sc++;
                    }
                    cur = cur.next;
                }
                /*while (fc < l) {// 合并剩余部分
                    cur.next = f;
                    cur = cur.next;
                    f = f.next;
                    fc++;
                }*/
                if (fc < l){
                    cur.next = f;
                    while (fc < l){
                        cur = cur.next;
                        fc++;
                    }
                }
                /*while (sc < l && s != null) {
                    cur.next = s;
                    cur = cur.next;
                    s = s.next;
                    sc++;
                }*/
                if (sc < l){
                    cur.next = s;
                    while (sc < l && s != null){
                        cur = cur.next;
                        s = s.next;
                        sc++;
                    }
                }
                cur.next = s;// 连接下一组的第一个节点
            }
        }
        return dummy.next;
    }
    public ListNode myMergeSortListdu1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        int n = 0;
        while (cur != null){
            n++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int fc, sc;
        for (int l = 1; l < n; l *= 2){
            cur = dummy;
            for (int begin = 0; begin + l < n; begin += l * 2){
                ListNode f = cur.next;
                ListNode s = cur.next;
                for (int i = 0; i < l; i++){
                    s = s.next;
                }
                fc = 0;
                sc = 0;
                while (fc < l && sc < l && s != null){
                    if (f.val <= s.val){
                        cur.next = f;
                        f = f.next;
                        fc++;
                    } else {
                        cur.next = s;
                        s = s.next;
                        sc++;
                    }
                    cur = cur.next;
                }
                while (fc < l){
                    cur.next = f;
                    f = f.next;
                    cur = cur.next;
                    fc++;
                }
                while (sc < l && s != null){
                    cur.next = s;
                    s = s.next;
                    cur = cur.next;
                    sc++;
                }
                cur.next = s;
            }
        }
        return dummy.next;
    }



}
