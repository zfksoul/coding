package array;

import java.util.Stack;

public class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> stMin = new Stack<>();
    MinStack(){}
    public void push(int x){
        st.push(x);
        if (stMin.empty()) stMin.push(x);
        else stMin.push(Math.min(x,stMin.peek()));
    }
    public void pop(){
        st.pop();
        stMin.pop();
    }
    public int top(){
        return st.peek();
    }
    public int getMin(){
        return stMin.peek();
    }

}
