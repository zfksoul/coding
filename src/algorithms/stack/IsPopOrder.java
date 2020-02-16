package algorithms.stack;

import java.util.Stack;

public class IsPopOrder {
    public static void main(String[] args){
        IsPopOrder o = new IsPopOrder();
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        System.out.println(o.myIsPopOrder(pushA, popA));
    }
    public boolean myIsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || pushA.length == 0 || popA == null || popA.length != pushA.length){
            return false;
        }
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < pushA.length){
            st.push(pushA[i++]);
            while (!st.empty()){
                if (st.peek() == popA[j]){
                    st.pop();
                    j++;
                } else {
                    break;
                }
            }
        }
        return st.empty();
    }
}
