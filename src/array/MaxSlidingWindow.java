package array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 单调栈：查找每个数左侧第一个比它小的数
 * 单调队列：滑动窗口中的最值
 *
 * 给定数组nums，有大小为k的滑动窗口，返回滑动窗口中最大值
 */
public class MaxSlidingWindow {
    public static void main(String[] args){
        MaxSlidingWindow o = new MaxSlidingWindow();
        int[] arr = {4,3,5,4,3,3,6,7};
        System.out.println(Arrays.toString(o.getMaxWindow(arr,3)));
    }

    public int[] getMaxWindow(int[] arr, int w){
        if (arr == null || w < 1 || arr.length < w) return null;
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w){
                qmax.pollFirst();
            }
            if (i >= w - 1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
