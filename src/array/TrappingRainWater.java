package array;

import java.util.Stack;

/**
 * 单调栈：查找每个数左侧第一个比它小的数
 * 单调队列：滑动窗口中的最值
 *
 * 给定n个非负整数表示的每个宽度为1的柱子高度，计算下雨后能接多少水
 * input:[0,1,0,2,1,0,1,3,2,1,2,1]
 * output:6
 */
public class TrappingRainWater {
    public static void main(String[] args){
        TrappingRainWater o = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(o.trap(height));
    }

    public int trap(int[] height){
        int res = 0;
        Stack<Integer> st = new Stack<>();
        //找左侧第一个比i柱子高的过程中，把面积一层层算出来
        for (int i = 0; i < height.length; i++){
            int last = 0;//存上一层的高度，用于求高度差
            while (!st.empty() && height[st.peek()] <= height[i]){
                int t = st.pop();
                res += (i - t - 1) * (height[t] - last);
                last = height[t];
            }
            if (!st.empty()) res += (i - st.peek() - 1) * (height[i] - last);
            st.push(i);
        }
        return res;
    }
}
