package algorithms.tree;


import java.util.LinkedList;
import java.util.Queue;

public class SerialByPre {
    public static void main(String[] args){
        SerialByPre o = new SerialByPre();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        System.out.println(o.mySerialByPre(node1));
        System.out.println(o.serialBylevel(node1));
    }
    public String mySerialByPre(TreeNode head){
        if (head == null){
            return "#!";
        }
        String res = head.value + "!";
        res += mySerialByPre(head.left);
        res += mySerialByPre(head.right);
        return res;
    }
    public TreeNode reconByPreString(String preStr){
        String[] values = preStr.split("!");
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < values.length; i++){
            q.offer(values[i]);
        }
        return reconPreOrder(q);
    }

    public TreeNode reconPreOrder(Queue<String> q) {
        String value = q.poll();
        if (value.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconPreOrder(q);
        head.right = reconPreOrder(q);
        return head;
    }
    public String serialBylevel(TreeNode head){
        if (head == null){
            return "#!";
        }
        String res = head.value + "!";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(head);
        while (!q.isEmpty()){
            head = q.poll();
            if (head.left != null){
                res += head.left.value + "!";
                q.offer(head.left);
            } else {
                res += "#!";
            }
            if (head.right != null){
                res += head.right.value + "!";
                q.offer(head.right);
            } else {
                res += "#!";
            }
        }
        return res;
    }
    public TreeNode reconByLevelString(String levelStr){
        String[] values = levelStr.split("!");
        int index = 0;
        TreeNode head = generateNodeByString(values[index++]);
        Queue<TreeNode> q = new LinkedList<>();
        if (head != null){
            q.offer(head);
        }
        TreeNode node = null;
        while (!q.isEmpty()){
            node = q.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null){
                q.offer(node.left);
            }
            if (node.right != null){
                q.offer(node.right);
            }
        }
        return head;
    }

    public TreeNode generateNodeByString(String value) {
        if (value.equals("#")){
            return null;
        }
        return new TreeNode(Integer.valueOf(value));
    }
}
