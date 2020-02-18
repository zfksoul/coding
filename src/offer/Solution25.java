package offer;

/**
* 
* 复杂链表的复制
* @author zfk
* @date 2019年10月23日 下午9:47:20 
* 
*/
public class Solution25 {
    public RandomListNode Clone(RandomListNode pHead) {
        
        if(pHead==null) {
            return null;
        }
        RandomListNode p = pHead;
        while(p!=null) {
            RandomListNode node = new RandomListNode(p.label);
            node.next=p.next;
            p.next=node;
            p=node.next;
        }
        p=pHead;
        while(p!=null) {
            if(p.random!=null) {
                p.next.random=p.random.next;
            }
            p=p.next.next;
        }
        RandomListNode head = pHead.next;
        p = pHead;
        RandomListNode q = p.next;
        while(p!=null) {
            p.next=q.next;
            p=p.next;
            if(p!=null) {
                q.next=p.next;
                q=p.next;
            }
        }
        return head;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}