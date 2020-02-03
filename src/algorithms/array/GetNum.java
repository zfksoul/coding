package algorithms.array;

import java.util.LinkedList;

/**
 * 最大值减最小值小于等于num的子数组数量
 * 单调栈：查找每个数左侧第一个比它小的数
 * 单调队列：滑动窗口中的最值
 */
public class GetNum {
    public static void main(String[] args){
        GetNum o = new GetNum();
        int[] arr = {4,3,5,0,3,3,6,7};
        System.out.println(o.myGetNum(arr, 3));
        System.out.println(o.myGetNum1(arr, 3));
    }
    public int myGetNum1(int[] arr, int num) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length){
            while (j < arr.length){
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num){
                    break;
                }
                j++;
            }
            if (qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            res += j - i;
            i++;
        }
        return res;
    }

    public int myGetNum(int[] arr, int num) {
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    break;
                }
                j++;
            }
            res += j - i;
            i++;
            if (qmax.peekFirst() < i) {
                qmax.pollFirst();
            }
            if (qmin.peekFirst() < i) {
                qmin.pollFirst();
            }
        }
        return res;
    }
}
