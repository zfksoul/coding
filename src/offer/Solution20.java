package offer;

import java.util.Stack;

/**
* 
*
* @author zfk
* @date 2019年10月20日 下午8:28:11 
* 
*/
public class Solution20 {
    int min = Integer.MAX_VALUE;
    Stack<Integer> st1 = new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();
    public static void main(String[] args) {
        Solution20 so = new Solution20();
        so.push(3);
        System.out.println(so.min());
        so.push(4);
        System.out.println(so.min());
        so.push(2);
        System.out.println(so.min());
    }
    public void push(int node) {
        min = (min <= node) ? min : node;
        st2.push(min);
        st1.push(node);
    }
    
    public void pop() {
        st1.pop();
        st2.pop();
    }
    
    public int top() {
        return st1.peek();
    }
    
    public int min() {
        return st2.peek();
    }   
}
