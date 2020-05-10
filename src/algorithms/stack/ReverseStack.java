package algorithms.stack;

import java.util.Stack;

/**
 * 仅用递归函数和栈操作逆序一个栈
 */
public class ReverseStack {
    public static void main(String[] args){
        ReverseStack o = new ReverseStack();
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(2);
        st.push(1);
        System.out.print(st);
        o.myReverseStack(st);
        System.out.print(st);
        o.reverse(st);
        System.out.print(st);
    }
    public void reverse(Stack<Integer> st){
        if (st.empty()){
            return;
        }
        int i = getAndRemoveLast1(st);
        reverse(st);
        st.push(i);
    }

    public int getAndRemoveLast1(Stack<Integer> st) {
        int res = st.pop();
        if (st.empty()){
            return res;
        } else {
            int last = getAndRemoveLast1(st);
            st.push(res);
            return last;
        }
    }

    public void myReverseStack(Stack<Integer> st) {
        if (st == null || st.isEmpty()) return;
        int last = getAndRemoveLast(st);
        myReverseStack(st);
        st.push(last);
    }

    public int getAndRemoveLast(Stack<Integer> st) {
        int cur = st.pop();
        if (st.isEmpty()){
            return cur;
        } else {
            int last = getAndRemoveLast(st);
            st.push(cur);
            return last;
        }
    }
}
