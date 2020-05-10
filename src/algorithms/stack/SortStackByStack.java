package algorithms.stack;

import java.util.Stack;

//用一个栈实现另一个栈的排序
public class SortStackByStack {
    public static void main(String[] args){
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);
        System.out.println(st);
        sort(st);
        System.out.println(st);
        sort1(st);
        System.out.println(st);
    }
    public static void sort(Stack<Integer> st){
        if (st == null || st.isEmpty()) return;
        Stack<Integer> help = new Stack<>();
        while (!st.isEmpty()){
            int tmp = st.pop();
            while (!help.isEmpty() && help.peek() < tmp){
                st.push(help.pop());
            }
            help.push(tmp);
        }
        while (!help.isEmpty()){
            st.push(help.pop());
        }
    }
    public static void sort1(Stack<Integer> st){
        if (st == null || st.isEmpty()) return;
        Stack<Integer> help = new Stack<>();
        while (!st.isEmpty()){
            int tmp = st.pop();
            while (!help.isEmpty() && help.peek() < tmp){
                st.push(help.pop());
            }
            help.push(tmp);
        }
        while (!help.isEmpty()){
            st.push(help.pop());
        }
    }
}
