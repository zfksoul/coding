package algorithms.stack;

import java.util.Stack;

public class TwoStackImplementQueue {
    public static class Queue<T>{
        private Stack<T> stackPush;
        private Stack<T> stackPop;
        public Queue(){
            this.stackPush = new Stack<>();
            this.stackPop = new Stack<>();
        }
        public void add(T newOne){
            stackPush.push(newOne);
        }
        public T poll(){
            if (stackPush.empty() && stackPop.empty()){
                throw new RuntimeException("queue is empty");
            } else if (stackPop.empty()){
                while (!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }
        public T peek(){
            if (stackPush.empty() && stackPop.empty()){
                throw new RuntimeException("queue is empty");
            } else if (stackPop.empty()){
                while (!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

}
