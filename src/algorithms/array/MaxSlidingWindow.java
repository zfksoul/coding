package algorithms.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 单调栈：查找每个数左侧第一个比它小的数
 * 单调队列：滑动窗口中的最值
 */
public class MaxSlidingWindow {
    public static void main(String[] args){
        MaxSlidingWindow o = new MaxSlidingWindow();
        int[] arr = {4,3,5,4,3,3,6,7};
        System.out.print(Arrays.toString(o.getMaxWindow1(arr, 3)));
    }
    private int[] getMaxWindow1(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w){
            return null;
        }
        LinkedList<Integer> q = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            while (!q.isEmpty() && arr[q.peekLast()] <= arr[i]){
                q.pollLast();
            }
            q.addLast(i);
            if (q.peekFirst() == i - w){
                q.pollFirst();
            }
            if (i >= w - 1){
                res[index++] = arr[q.peekFirst()];
            }
        }
        return res;
    }

    private int[] getMaxWindow(int[] arr, int w) {
        LinkedList<Integer> q = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int k = 0;
        for (int i = 0; i < arr.length; i++){
            while (!q.isEmpty() && arr[q.peekLast()] <= arr[i]){
                q.removeLast();
            }
            q.addLast(i);
            if (q.peekFirst() < k){
                q.removeFirst();
            }
            if (i >= w - 1) {
                res[k++] = arr[q.peekFirst()];
            }
        }
        return res;
    }
}
