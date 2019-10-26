package algorithms;

import java.util.LinkedList;
import java.util.Queue;

import javax.xml.soap.Node;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月23日 下午11:40:43
 * 
 */
public class Solution26 {

    public TreeNode Convert(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode node = process(head);
        head = node.right;
        node.right = null;
        return head;
    }

    public TreeNode process(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode left = process(head.left);
        TreeNode right = process(head.right);
        if (left != null && right != null) {
            right.right.left = head;
            head.right = right.right;
            right.right = left.right;
            left.right = head;
            head.left = left;
            return right;

        } else if (left != null) {
            head.right = left.right;
            head.left = left;
            left.right = head;
            return head;
        } else if (right != null) {
            head.right = right.right;
            right.right.left = head;
            right.right = head;
            return right;
        } else {
            head.right = head;
            return head;
        }
    }

    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        inOrderToQueue(pRootOfTree, queue);
        TreeNode head = queue.poll();
        TreeNode p = head;
        TreeNode next = null;
        while (!queue.isEmpty()) {
            next = queue.poll();
            p.right = next;
            next.left = p;
            p = next;
        }
        return head;
    }

    public void inOrderToQueue(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) {
            return;
        }
        inOrderToQueue(node.left, queue);
        queue.offer(node);
        inOrderToQueue(node.right, queue);
    }
}
