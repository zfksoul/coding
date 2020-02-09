package algorithms.stack;

import java.util.LinkedList;

public class TwoQueueImplementStack {
    public static class Stack<T>{
        private LinkedList<T> q1;
        private LinkedList<T> q2;
        public Stack(){
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }
        public void push(T newOne){
            q1.add(newOne);
        }
        public T pop(){
            if (isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            while (q1.size() > 1){
                q2.add(q1.poll());
            }
            T value = q1.poll();
            while (!q2.isEmpty()){
                q1.add(q2.poll());
            }
            return value;
        }
        public boolean isEmpty(){
            return q1.isEmpty();
        }
        public int size(){
            return q1.size();
        }

    }
}
