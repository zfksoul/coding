package algorithms.tree;

import java.util.HashMap;

/**
 * 给定二叉树，返回累加和为sum的最大节点长度
 */
public class LongestPathSum {

    public int getMaxLength(TreeNode head, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);//头结点从1开始，所以累加和为0的节点为0
        return preOrder(head, k, 0, 1, 0, map);
    }

    /**
     *
     */
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
        if (level == map.get(curSum)){
            map.remove(curSum);
        }
        return maxLen;
    }
}
