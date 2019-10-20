package algorithms;

import java.util.Stack;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月16日 下午8:40:38
 * 
 */
public class Solution5 {

    public static void main(String[] args) {

    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int num) {
        stack1.push(num);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }

}
