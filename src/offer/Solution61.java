package offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Solution61 {
    public static void main(String[] args) {
        Solution61 o = new Solution61();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        //System.out.println(o.Deserialize(o.Serialize1(node1)));
        System.out.println(o.Serialize(node1));
    }
    String Serialize1(TreeNode head) {
        if (head == null){
            return "#!";
        }
        String res = head.val + "!";
        res += Serialize1(head.left);
        res += Serialize1(head.right);
        return res;
    }

    //层次遍历
    String Serialize(TreeNode head) {
        if (head == null){
            return "#!";
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(head);
        TreeNode cur = null;
        StringBuilder str = new StringBuilder();
        str.append(head.val).append("!");
        while (!q.isEmpty()){
            cur = q.poll();
            if (cur.left != null){
                q.offer(cur.left);
                str.append(cur.left.val).append("!");
            } else {
                str.append("#!");
            }
            if (cur.right != null){
                q.offer(cur.right);
                str.append(cur.right.val).append("!");
            } else {
                str.append("#!");
            }
        }
        return str.toString();
    }
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0){
            return null;
        }
        String[] s = str.split("!");
        Queue<TreeNode> q = new LinkedList<>();
        int index = 0;
        if ("#".equals(s[0])){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(s[index++]));
        if (head != null){
            q.offer(head);
        }
        TreeNode cur = null;
        while (!q.isEmpty()){
            cur = q.poll();
            cur.left = generate(s[index++]);
            cur.right = generate(s[index++]);
            if (cur.left != null){
                q.offer(cur.left);
            }
            if (cur.right != null){
                q.offer(cur.right);
            }
        }
        return head;
    }
    TreeNode generate(String str){
        if ("#".equals(str)){
            return null;
        }
        return new TreeNode(Integer.valueOf(str));
    }



    /*
    //中序遍历
    String Serialize(TreeNode head) {
        if (head == null){
            return "#!";
        }
        Stack<TreeNode> st = new Stack<>();
        StringBuilder str = new StringBuilder();
        while (!st.isEmpty() || head != null){
            if (head != null){
                st.push(head);
                head = head.left;
            } else {
                str.append("#!");
                head = st.pop();
                str.append(head.val).append("!");
                head = head.right;
            }
        }
        str.append("#!");
        return str.toString();
    }*/



    /*
    //先序遍历
    String Serialize(TreeNode head) {
        if (head == null){
            return "#!";
        }
        Stack<TreeNode> st = new Stack<>();
        StringBuilder str = new StringBuilder();
        while (!st.isEmpty() || head != null){
            if (head != null){
                str.append(head.val).append("!");
                st.push(head);
                head = head.left;
            } else {
                str.append("#!");
                head = st.pop();
                head = head.right;
            }
        }
        str.append("#!");
        return str.toString();
    }
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0){
            return null;
        }
        String[] s = str.split("!");
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < s.length; i++){
            q.offer(s[i]);
        }
        TreeNode res = process(q);
        return res;
    }
    TreeNode process(Queue<String> q){
        String s = q.poll();
        if ("#".equals(s)){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(s));
        head.left = process(q);
        head.right = process(q);
        return head;
    }*/

}
