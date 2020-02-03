package algorithms.others;

import java.util.HashMap;

/**
 * 时间复杂度O(n)
 */
public class MessageBox {
    private HashMap<Integer, ListNode> headMap;
    private HashMap<Integer, ListNode> tailMap;
    private int lastPrint;

    public static void main(String[] args){
        MessageBox o = new MessageBox();
        o.receive(2);
        o.receive(3);
        o.receive(4);
        o.receive(1);
        o.receive(6);
        o.receive(5);
    }
    public MessageBox(){
        headMap = new HashMap<>();
        tailMap = new HashMap<>();
        lastPrint = 0;
    }
    public void receive(int num){
        if (num < 1){
            return;
        }
        ListNode cur = new ListNode(num);
        headMap.put(num, cur);
        tailMap.put(num, cur);
        if (tailMap.containsKey(num - 1)){
            tailMap.get(num - 1).next = cur;
            tailMap.remove(num - 1);
            headMap.remove(num);
        }
        if (headMap.containsKey(num + 1)){
            cur.next = headMap.get(num + 1);
            tailMap.remove(num);
            headMap.remove(num + 1);
        }
        if (headMap.containsKey(lastPrint + 1)){
            print();
        }
    }

    private void print() {
        ListNode node = headMap.get(++lastPrint);
        headMap.remove(lastPrint);
        while (node != null){
            System.out.print(node.value + " ");
            node = node.next;
            lastPrint++;
        }
        tailMap.remove(--lastPrint);
        System.out.println();
    }
}
