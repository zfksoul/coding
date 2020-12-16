package tree;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

//由前序遍历和中序遍历构造二叉树
public class ConstructBinaryTree {
    Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        ConstructBinaryTree o = new ConstructBinaryTree();
        TreeNode root = o.buildTree(preorder,inorder);
        System.out.println(o.inOrder(root));
    }

    private List<Integer> inOrder(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (p != null || st.size() > 0){
            while (p != null){
                st.push(p);
                p = p.left;
            }
            p = st.peek();
            st.pop();
            list.add(p.val);
            p = p.right;
        }
        return list;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder){
        int n = preorder.length;
        for (int i = 0; i < n; i++) map.put(inorder[i],i);
        return dfs1(preorder,inorder,0,n-1,0,n-1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) return null;
        int val = preorder[pl];
        int k = map.get(val);
        int len = k - il;
        TreeNode root = new TreeNode(val);
        root.left = dfs(preorder,inorder,pl+1,pl+len,il,k-1);
        root.right = dfs(preorder,inorder,pl+len+1,pr,k+1,ir);
        return root;
    }
    private TreeNode dfs1(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr){
            return null;
        }
        int val = preorder[pl];
        int k = map.get(val);
        int len = k - il;
        TreeNode node = new TreeNode(val);
        node.left = dfs1(preorder, inorder, pl + 1, pl + len, il, k - 1);
        node.right = dfs1(preorder, inorder, pl + len + 1, pr, k + 1, ir);
        return node;
    }
}
