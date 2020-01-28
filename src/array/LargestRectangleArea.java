package array;

import java.util.Stack;

/**
 * 单调栈：查找每个数左侧第一个比它小的数
 * 单调队列：滑动窗口中的最值
 *
 * 柱状图中最大矩形
 */
public class LargestRectangleArea {
    public static void main(String[] args){
        LargestRectangleArea o = new LargestRectangleArea();
        int[] height = {2,1,5,6,2,3};
        System.out.println(o.maxArea(height));
    }

    public int maxArea(int[] height){
        if (height == null || height.length == 0) return 0;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < height.length; i++){
            while (!st.empty() && height[i] <= height[st.peek()]){
                int j = st.pop();
                int k = st.empty() ? -1 : st.peek();
                int cur = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, cur);
            }
            st.push(i);
        }
        while (!st.empty()){
            int j = st.pop();
            int k = st.empty() ? -1 : st.peek();
            int cur = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, cur);
        }
        return maxArea;
    }
}
