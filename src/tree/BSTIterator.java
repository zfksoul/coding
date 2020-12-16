package tree;

import java.util.LinkedList;
import java.util.Stack;

//迭代器，中序遍历，时间复杂度O(1)，空间复杂度O(h)，h是树的高度，所以不能直接求中序遍历放到数组中
public class BSTIterator {

    private LinkedList<TreeNode> st = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    //平均时间复杂度O(1)，遍历一遍二叉树时间复杂度O(n)，调用n次next()，每次时间复杂度O(1)
    public int next(){
        TreeNode p = st.pop();
        int res = p.val;
        p = p.right;
        while (p != null){
            st.push(p);
            p = p.left;
        }
        return res;
    }
    public Boolean hasNext(){
        return !st.isEmpty();
    }
}
