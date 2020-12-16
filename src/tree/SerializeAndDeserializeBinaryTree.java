package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 先根遍历方式序列化，根-左-右，不能定义函数外的变量
 *    10
 *   2  -3009
 *  4 5 6 7009
 */
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(-3009);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7009);
        node1.left = node2;
        node1.right =node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        SerializeAndDeserializeBinaryTree o = new SerializeAndDeserializeBinaryTree();
        StringBuilder s = o.serialize(node1);
        System.out.println(s);
        TreeNode t = o.deserialize(s);
        System.out.print(o.inOrder(t));
    }

    private List<Integer> inOrder(TreeNode root) {
        LinkedList<TreeNode> st = new LinkedList<>();
        TreeNode p = root;
        List<Integer> list = new ArrayList<>();
        while (p != null || st.size() > 0){
            while (p != null){
                st.push(p);
                p = p.left;
            }
            p = st.pop();
            list.add(p.val);
            p = p.right;
        }
        return list;
    }

    //先序遍历序列化
    public StringBuilder serialize(TreeNode root){
        StringBuilder res = new StringBuilder();
        preOrder(root,res);
        return new StringBuilder(res.substring(0,res.length()-1));
    }
    private void preOrder(TreeNode root, StringBuilder res) {
        if (root == null){
            res.append("#,");
            return;
        }
        LinkedList<TreeNode> st = new LinkedList<>();
        while (root != null || !st.isEmpty()){
            while (root != null){
                res.append(root.val + ",");
                st.push(root);
                root = root.left;
            }
            res.append("#,");
            root = st.poll();
            root = root.right;
        }
        res.append("#,");
    }

    private void dfs(TreeNode root, StringBuilder res) {
        if (root == null){
            res.append("#,");
            return;
        }
        res.append(Integer.toString(root.val)+",");
        dfs(root.left,res);
        dfs(root.right,res);
    }

    //反序列化
    public TreeNode deserialize(StringBuilder data){
        int[] u = {0};//坐标的引用，初始坐标为0
        return dfs2(data,u);
    }

    private TreeNode dfs1(StringBuilder data, int[] u) {
        if (data.charAt(u[0]) == '#'){
            u[0] += 2;//跳过'#'和','
            return null;
        }

        boolean isMinus = false;//有可能是负数
        if (data.charAt(u[0]) == '-'){
            isMinus = true;
            u[0]++;
        }
        int t = 0;
        char d;
        while (u[0] < data.length() && (d = data.charAt(u[0])) != ','){
            t = t * 10 + d - '0';
            u[0]++;
        }
        u[0]++;//跳过','
        if (isMinus) t = -t;
        TreeNode root = new TreeNode(t);
        root.left = dfs1(data,u);
        root.right = dfs1(data,u);
        return root;
    }
    private TreeNode dfs2(StringBuilder data, int[] u) {
        if (data.charAt(u[0]) == '#'){
            u[0] += 2;
            return null;
        }
        boolean isMinus = false;
        if (data.charAt(u[0]) == '-'){
            isMinus = true;
            u[0]++;
        }
        int t = 0;
        char d;
        while (u[0] < data.length() && (d = data.charAt(u[0])) != ','){
            t = t * 10 + d - '0';
            u[0]++;
        }
        u[0]++;
        if (isMinus){
            t = -t;
        }
        TreeNode node = new TreeNode(t);
        node.left = dfs2(data, u);
        node.right = dfs2(data, u);
        return node;
    }
}
