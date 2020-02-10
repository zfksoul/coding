package algorithms.list;

public class JosephusKill {
    public ListNode find(ListNode head, int m){
        if (head == null || head.next == head){
            return head;
        }
        ListNode last = head;
        while (last.next != head){
            last = last.next;
        }
        int count = 0;
        while (last != head){
            if (++count == m){
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return last;
    }

    /**
     * 节点编号(B)：1,2,3,...,i-1,i,1,2,3...
     * 报数(A)：   1,2,3,...,i-1,i,
     *            i+1,i+2,...,2i,
     *            2i+1,2i+2,.,3i,
     * 公式1：B=(A-1)%i+1
     *
     * 编号s被删除，环节点数量从i变成i-1
     * 删除前：...s-2,s-1,s,s+1,s+2,...
     * 删除后：...i-2,i-1,   1, 2,...
     * 环数量为i的节点编号为old
     * 环数量为i-1的节点编号为new
     * 公式2：old=(new+s-1)%i+1   new+s相当于旧环的报数，转换成编号用公式1
     *
     * 报数到m被删除，A=m
     * 被删除节点编号s=B=(m-1)%i+1，带入公式2
     * old=(new+m-1)%i+1
     * Num(i-1)——new
     * Num(i)——old
     *
     */
    public ListNode find1(ListNode head, int m){
        if (head == null || head.next == head || m < 1){
            return head;
        }
        ListNode cur = head.next;
        int tmp = 1;
        while (cur != head){//计算环节点数量
            tmp++;
            cur = cur.next;
        }
        tmp = getLive(tmp, m);//找到保留的节点编号
        while (--tmp != 0){
            head = head.next;
        }
        head.next = head;
        return head;
    }

    private int getLive(int i, int m) {
        if (i == 1){
            return 1;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }
}
