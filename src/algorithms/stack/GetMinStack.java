package algorithms.stack;

import java.util.Stack;

public class GetMinStack {
    public static class MyStack1{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }
        public void push(Integer newNum){
            if (this.stackMin.empty()){
                this.stackMin.push(newNum);
            } else if (newNum <= this.getmin()){
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public Integer getmin() {
            if (this.stackMin.empty()){
                throw new RuntimeException("stack is empty");
            }
            return this.stackMin.peek();
        }

        public Integer pop(){
            if (this.stackData.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            int value = this.stackData.pop();
            if (value == this.getmin()){
                this.stackMin.pop();
            }
            return value;
        }
    }
}
