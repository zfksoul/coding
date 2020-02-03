package algorithms.others;

import java.util.HashMap;

/**
 * LRU(Least Recently Used)将最近最久未使用的删除
 * LFU(Least Frequently Used)最近最少使用，将访问频率最小的删除
 */
public class MyCahe<K, V> {
    private HashMap<K, Node<V>> keyNodeMap;
    private HashMap<Node<V>, K> nodeKeyMap;
    private NodeDoubleLinkedList<V> nodeList;
    private int capacity;
    public static void main(String[] args){
        MyCahe<String, Integer> o = new MyCahe<>(3);
        o.set("a",1);
        o.set("b",2);
        o.set("c",3);
        o.set("d",4);
    }
    public MyCahe(int capacity){
        if (capacity < 1){
            throw new RuntimeException("should be more than 0");
        }
        this.keyNodeMap = new HashMap<>();
        this.nodeKeyMap = new HashMap<>();
        this.nodeList = new NodeDoubleLinkedList<>();
        this.capacity = capacity;
    }
    public V get(K key){
        if (this.keyNodeMap.containsKey(key)){
            Node<V> res = this.keyNodeMap.get(key);
            this.nodeList.moveNodeToTail(res);
            return res.value;
        }
        return null;
    }
    public void set(K key, V value){
        if (this.keyNodeMap.containsKey(key)){
            Node<V> node = this.keyNodeMap.get(key);
            node.value = value;
            this.nodeList.moveNodeToTail(node);
        } else {
            Node<V> newNode = new Node<V>(value);
            this.keyNodeMap.put(key, newNode);
            this.nodeKeyMap.put(newNode, key);
            this.nodeList.add(newNode);
            if (this.keyNodeMap.size() == this.capacity + 1){
                this.removeMostUnusedCache();
            }
        }
    }

    private void removeMostUnusedCache() {
        Node<V> removeNode = this.nodeList.removeHead();
        K removeKey = this.nodeKeyMap.get(removeNode);
        this.nodeKeyMap.remove(removeNode);
        this.keyNodeMap.remove(removeKey);
    }
}
class Node<V>{
    public V value;
    public Node<V> last;
    public Node<V> next;
    public Node(V value){
        this.value = value;
    }
}
class NodeDoubleLinkedList<V>{
    private Node<V> head;
    private Node<V> tail;
    public NodeDoubleLinkedList(){
        this.head = null;
        this.tail = null;
    }
    public void add(Node<V> node){
        if (node == null){
            return;
        }
        if (this.head == null){
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.last = this.tail;
            this.tail = node;
        }
    }
    public void moveNodeToTail(Node<V> node){
        if (this.tail == node){
            return;
        }
        if (this.head == node){
            this.head = node.next;
            this.head.last = null;
        } else {
            node.last = node.next;
            node.next.last = node.last;
        }
        node.last = this.tail;
        node.next = null;
        this.tail.next = node;
        this.tail = node;
    }

    public Node<V> removeHead() {
        if (this.head == null){
            return null;
        }
        Node<V> res = this.head;
        if (this.head == this.tail){
            this.head = null;
            this.tail = null;
        } else {
            this.head = res.next;
            res.next = null;
            this.head.last = null;
        }
        return res;
    }
}
