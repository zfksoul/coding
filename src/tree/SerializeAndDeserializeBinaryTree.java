package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//先根遍历方式序列化，根-左-右
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
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
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        List<Integer> list = new ArrayList<>();
        while (p != null || st.size() != 0){
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
        dfs1(root,res);
        return res;
    }

    private void dfs1(TreeNode root, StringBuilder res) {
        if (root == null){
            res.append("#,");
            return;
        }
        res.append(Integer.toString(root.val)+",");
        dfs1(root.left,res);
        dfs1(root.right,res);
    }

    public TreeNode deserialize(StringBuilder data){
        int u = 0;
        return dfs2(data,u);
    }

    private TreeNode dfs2(StringBuilder data, int u) {
        if (data.charAt(u) == '#'){
            u += 2;
            return null;
        }
        int t = 0;
        boolean isMinus = false;
        if (data.charAt(u) == '-'){
            isMinus = true;
            u++;
        }
        while (data.charAt(u) != ','){
            t = t * 10 + data.charAt(u) - '0';
            u++;
        }
        u++;
        if (isMinus) t = -t;
        TreeNode root = new TreeNode(t);
        root.left = dfs2(data,u);
        root.right = dfs2(data,u);
        return root;
    }
}
