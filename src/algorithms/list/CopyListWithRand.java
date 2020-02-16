package algorithms.list;

public class CopyListWithRand {
    public static void main(String[] args){
        CopyListWithRand o = new CopyListWithRand();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node1.rand = node3;
        node2.rand = node1;
        node3.rand = node1;
        ListNode copyNode = o.copy2(node1);
        while (copyNode != null){
            System.out.println(copyNode);
            copyNode = copyNode.next;
        }
    }
    private ListNode copy1(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode cur = head;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = new ListNode(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        ListNode curCopy = null;
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        cur = head;
        ListNode res = head.next;
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
    private ListNode copy2(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode next = null;
        ListNode p = head;
        ListNode q = null;
        while (p != null){
            next = p.next;
            q = new ListNode(p.value);
            p.next = q;
            q.next = next;
            p = next;
        }
        p = head;
        while (p != null){
            p.next.rand = p.rand == null ? null : p.rand.next;
            p = p.next.next;
        }
        p = head;
        q = head.next;
        ListNode res = head.next;
        while (p != null){
            p.next = p.next.next;
            p = p.next;
            q.next = p == null ? null : p.next;
            q = q.next;
        }
        return res;

    }

    private ListNode copy(ListNode node1) {
        ListNode cur = node1;
        while (cur != null){
            ListNode p = new ListNode(cur.value);
            p.next = cur.next;
            cur.next = p;
            cur = cur.next.next;
        }
        cur = node1;
        ListNode copy;
        while (cur != null){
            copy = cur.next;
            copy.rand = cur.rand == null ? cur.rand.next : null;
            cur = cur.next.next;
        }
        cur = node1;
        copy = cur.next;
        ListNode n;
        while (cur != null){
            n = cur.next;
            cur.next = n.next;
            n.next = cur.next != null ? cur.next.next : null;
            cur = cur.next;
        }
        return copy;
    }
}
