package algorithms.tree;

import java.util.HashMap;

/**
 * 给定二叉树，返回累加和为sum的最大节点长度
 */
public class LongestPathSum {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node4.left = node2;
        node4.right = node6;
        node2.left = node1;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        LongestPathSum o = new LongestPathSum();
        System.out.println(o.getMaxLength(node4, 6));
    }
    public int getMaxLength(TreeNode head, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);//头结点从1开始，所以累加和为0的节点为0
        return preOrder1(head, k, 0, 1, 0, map);
    }

    private int preOrder1(TreeNode head, int k, int preSum, int level, int maxLen, HashMap<Integer, Integer> map) {
        if (head == null){
            return maxLen;
        }
        int sum = preSum + head.value;
        if (!map.containsKey(sum)){
            map.put(sum, level);
        }
        if (map.containsKey(sum - k)){
            maxLen = Math.max(maxLen, level - map.get(sum - k));
        }
        maxLen = preOrder1(head.left, k, sum, level + 1, maxLen, map);
        maxLen = preOrder1(head.right, k, sum, level + 1, maxLen, map);
        if (map.get(sum) == level){
            map.remove(sum);
        }
        return maxLen;
    }

    public int preOrder(TreeNode head, int k, int sum, int level, int maxLen, HashMap<Integer, Integer> map) {
        if (head == null){
            return maxLen;
        }
        int curSum = sum + head.value;
        if (!map.containsKey(curSum)){
            map.put(curSum, level);
        }
        if (map.containsKey(curSum - k)){
            maxLen = Math.max(maxLen, level - map.get(curSum - k));
        }
        maxLen = preOrder(head.left, k, curSum, level + 1, maxLen, map);
        maxLen = preOrder(head.right, k, curSum, level + 1, maxLen, map);
        if (level == map.get(curSum)){//说明是本层加入的这个值，离开本层要删除
            map.remove(curSum);
        }
        return maxLen;
    }
}
