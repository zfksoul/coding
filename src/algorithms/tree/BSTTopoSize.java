package algorithms.tree;

import java.util.HashMap;

/**
 * 给定二叉树，找到二叉搜索树的最大拓扑
 */
public class BSTTopoSize {
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
        BSTTopoSize o = new BSTTopoSize();
        System.out.println(o.getBSTTopoSize(node4));
    }
    //贡献记录
    class Record{
        public int l;
        public int r;
        public Record(int left, int right){
            this.l = left;
            this.r = right;
        }
    }
    public int getBSTTopoSize(TreeNode head){
        if (head == null){
            return 0;
        }
        HashMap<TreeNode, Record> map = new HashMap<>();//记录以该节点为头结点的贡献记录
        return posOrder(head, map);
    }

    /**
     * @return 以head为头时，最大搜索二叉树的大小
     */
    private int posOrder(TreeNode head, HashMap<TreeNode, Record> map) {
        if (head == null){
            return 0;
        }
        int lmax = posOrder(head.left, map);//左子树最大拓扑节点数
        int rmax = posOrder(head.right, map);//右子树最大拓扑节点数
        modifyMap(head.left, head.value, map, true);//以head为新头结点，修改左子树拓扑贡献记录
        modifyMap(head.right, head.value, map, false);//以head为新头结点，修改右子树拓扑贡献记录
        Record lrec = map.get(head.left);//以head为头结点时，左子树的拓扑贡献记录
        Record rrec = map.get(head.right);//以head为头结点时，右子树的拓扑贡献记录
        int l = lrec == null ? 0 : lrec.l +lrec.r + 1;
        int r = rrec == null ? 0 : rrec.l + rrec.r + 1;
        map.put(head, new Record(l, r));
        return Math.max(l + r + 1, Math.max(lmax, rmax));
    }

    /**
     * @param n 原来遍历的子树头部
     * @param value 新头部的值
     * @param map
     * @param isLeft 左子树为true，右子树为false
     * @return 本次修改需要减掉多少节点
     */
    private int modifyMap(TreeNode n, int value, HashMap<TreeNode, Record> map, boolean isLeft) {
        if (n == null || !map.containsKey(n)){
            return 0;
        }
        Record rec = map.get(n);
        if ((isLeft && n.value > value) || (!isLeft && n.value < value)){
            map.remove(n);
            return rec.l + rec.r + 1;
        } else {
            int minus = modifyMap(isLeft ? n.right : n.left, value, map, isLeft);
            if (isLeft){
                rec.r = rec.r - minus;
            } else {
                rec.l = rec.l - minus;
            }
            map.put(n, rec);
            return minus;
        }
    }

}
