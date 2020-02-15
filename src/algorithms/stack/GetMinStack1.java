package algorithms.stack;

import java.util.Stack;

public class GetMinStack1 {
    public static void main(String[] args){
        MyStack1 st = new MyStack1();
        st.push(3);
        System.out.println(st.min());
        st.push(4);
        System.out.println(st.min());
        st.push(2);
        System.out.println(st.min());
        st.push(3);
        System.out.println(st.min());
        st.pop();
        System.out.println(st.min());
        st.pop();
        System.out.println(st.min());
        st.pop();
        System.out.println(st.min());
        st.push(0);
        System.out.println(st.min());

    }
    public static class MyStack1{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;
        public MyStack1(){
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }
        public void push(int node) {
            stackData.push(node);
            if (stackMin.isEmpty()){
                stackMin.push(node);
            } else if (node <= stackMin.peek()){
                stackMin.push(node);
            }
        }

        public void pop() {
            int top = stackData.pop();
            if (top <= stackMin.peek()){
                stackMin.pop();
            }
        }

        public int top() {
            return stackData.peek();
        }

        public int min() {
            return stackMin.peek();
        }
    }
}
