package algorithms.list;

public class ListNode {
    public int value;
    public ListNode next;
    public ListNode rand;

    public ListNode(int i) {
        value = i;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
    }
}
