package algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 单调栈：查找每个数左侧第一个比它小的数
 * 单调队列：滑动窗口中的最值
 *
 * 给定数组和窗口大小，求窗口中最大值
 */
public class MaxSlidingWindow {
    public static void main(String[] args){
        MaxSlidingWindow o = new MaxSlidingWindow();
        int[] arr = {4,3,5,4,3,3,6,7};
        System.out.print(Arrays.toString(o.getMaxWindow1(arr, 3)));
        System.out.print(Arrays.toString(o.getMaxWindow(arr, 3)));
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
        if (arr == null || w < 1 || arr.length < w){
            return new int[]{};
        }
        int[] res = new int[arr.length - w + 1];
        LinkedList<Integer> list = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]){
                list.pollLast();
            }
            list.addLast(i);
            if (list.peekFirst() == i - w){
                list.pollFirst();
            }
            if (i >= w - 1){
                res[index++] = arr[list.peekFirst()];
            }
        }
        return res;
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length == 0 || size < 1 || size > num.length){
            return res;
        }
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < num.length; i++){
            while (!q.isEmpty() && num[i] >= num[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
            if (q.getFirst() <= i - size){
                q.removeFirst();
            }
            if (i >= size - 1){
                res.add(num[q.getFirst()]);
            }
        }
        return res;
    }
}
