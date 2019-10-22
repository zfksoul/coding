package algorithms;

import java.util.Stack;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月20日 下午10:01:28
 * 
 */
public class Solution21 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        if (pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> st = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            st.push(pushA[i]);
            while (!st.isEmpty()) {
                if (st.peek() == popA[j]) {
                    st.pop();
                    j++;
                } else {
                    break;
                }
            }
        }
        return st.isEmpty();
    }

    public boolean IsPopOrder1(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        if (pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        int j = 0;
        while (i < pushA.length) {
            while (i < pushA.length) {
                if (pushA[i] != popA[j]) {
                    st.push(pushA[i]);
                    i++;
                } else {
                    i++;
                    j++;
                    break;
                }
            }
            while (j < popA.length) {
                if (st.peek() == popA[j]) {
                    st.pop();
                    j++;
                } else {
                    break;
                }
            }
        }
        while (j < popA.length) {
            if (st.peek() == popA[j]) {
                st.pop();
                j++;
            } else {
                break;
            }
        }
        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
