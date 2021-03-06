package algorithms.array;

import java.util.Stack;

/**
 * 给定矩阵m，值只有0和1，求全是1的最大矩形中1的数量
 */
public class MaxSubMatrix {
    public static void main(String[] args){
        MaxSubMatrix o = new MaxSubMatrix();
        int[][] m = {{1,0,1,1},
                     {1,1,1,1},
                     {1,1,1,0}};
        System.out.println(o.maxSize(m));
        System.out.println(o.maxSize1(m));
        System.out.println(o.maxSize2(m));
    }


    public int maxSize1(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[m[0].length];
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){
                height[j] = m[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, getSize1(height));
        }
        return maxArea;
    }

    private int getSize1(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < height.length; i++){
            while (!st.empty() && height[i] <= height[st.peek()]){
                int j = st.pop();
                int k = st.empty() ? -1 : st.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            st.push(i);
        }
        while (!st.empty()){
            int j = st.pop();
            int k = st.empty() ? -1 : st.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    public int maxSize(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0){
            return 0;
        }
        int shorts = m.length < m[0].length ? m.length : m[0].length;
        int longs = m.length < m[0].length ? m[0].length : m.length;
        boolean rowmore = m.length < m[0].length ? false : true;
        int[] help = new int[shorts];
        Stack<Integer> st = new Stack<>();
        int size = 0;
        //System.out.println(Arrays.toString(help));
        for (int i = 0; i < longs; i++){
            for (int j = 0; j < shorts; j++){
                if (rowmore){
                    help[j] = m[i][j] == 0 ? 0 : help[j] + m[i][j];
                } else {
                    help[j] = m[j][i] == 0 ? 0 : help[j] + m[j][i];
                }
            }
            size = Math.max(size, getSize(help, st));
        }
        return size;
    }

    public int getSize(int[] help, Stack<Integer> st) {
        int size = 0;
        int max = 0;
        int cur = 0;
        for (int i = 0; i < help.length; i++){
            while (!st.empty() && help[st.peek()] >= help[i]){
                cur = help[st.pop()];
                size = st.empty() ? cur * i : cur * (i - st.peek() - 1);
                max = Math.max(max, size);
            }
            st.push(i);
        }
        while (!st.empty()){
            cur = help[st.pop()];
            size = st.empty() ? cur * help.length : cur * (help.length - st.peek() - 1);
            max = Math.max(max, size);
        }
        return max;
    }
    private int maxSize2(int[][] m) {
        if (m  == null || m.length == 0 || m[0] == null || m[0].length == 0){
            return -1;
        }
        int more = m.length < m[0].length ? m[0].length : m.length;
        int less = m.length < m[0].length ? m.length : m[0].length;
        boolean rowmore = m.length < m[0].length ? false : true;
        int[] help = new int[less];
        int maxSize = 0;
        for (int i = 0; i < more; i++){
            for (int j = 0; j < less; j++){
                if (rowmore){
                    help[j] = m[i][j] == 0 ? 0 : help[j] + m[i][j];
                } else {
                    help[j] = m[j][i] == 0 ? 0 : help[j] + m[j][i];
                }
            }
            maxSize = Math.max(maxSize, getSize2(help));
        }
        return maxSize;
    }

    private int getSize2(int[] help) {
        if (help == null || help.length == 0) return -1;
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i = 0; i < help.length; i++){
            while (!st.isEmpty() && help[st.peek()] >= help[i]){
                int j = st.pop();
                int len = st.isEmpty() ? i : i - st.peek() - 1;
                max = Math.max(max, len * help[j]);
            }
            st.push(i);
        }
        while (!st.isEmpty()){
            int j = st.pop();
            int len = st.isEmpty() ? help.length : help.length - st.peek() - 1;
            max = Math.max(max, len * help[j]);
        }
        return max;
    }
}
