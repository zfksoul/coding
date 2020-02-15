package algorithms.stack;

import java.util.Stack;

/**
 * 用2个栈实现一个队列
 */
public class TwoStackImplementQueue1 {
    public static class Queue<T>{
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack1.isEmpty() && stack2.isEmpty()){
                throw new RuntimeException("queue is empty");
            } else if (!stack2.isEmpty()){
                return stack2.pop();
            } else {
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }

        }
    }

}
