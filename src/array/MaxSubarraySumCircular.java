package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 环形子数组最大和
 * 将环展开，长度为2n，窗口长度为[1,n]的窗口内数字和最大值
 * 求以i为结尾的长度为1-n的数组前缀和，
 * 对于以i结尾的子数组，其最优答案是 sum[i]−min(sum[j]),i−n<=j<i
 * 在所有以i结尾的子数组中找到最大值即为答案。
 */
public class MaxSubarraySumCircular {
    public static void main(String[] args){
        MaxSubarraySumCircular o = new MaxSubarraySumCircular();
        int[] arr = {1,-2,3,-2};
        System.out.println(o.myMaxSubarraySumCircular(arr));
    }

    public int myMaxSubarraySumCircular(int[] arr){
        int n = arr.length;
        int[] arr2 = new int[n*2];
        int k = 0;
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < n; j++){
                arr2[k++] = arr[j];
            }
        }
        int[] sum = new int[n*2+1];//sum[i]表示[0,i-1]数组和
        for (int i = 1; i <= n*2; i++){
            sum[i] = sum[i-1] + arr2[i-1];
        }
        int res = Integer.MIN_VALUE;
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(0);//第0个位置，前缀和为0，sum[0]==0
        for (int i = 1; i <= n * 2; i++){
            if (!list.isEmpty() && i - n > list.peekFirst()) list.pollFirst();//第一个位置超出n限制，弹出
            if (!list.isEmpty()) res = Math.max(res, sum[i] - sum[list.peekFirst()]);//更新答案
            while (!list.isEmpty() && sum[list.peekLast()] >= sum[i]) list.pollLast();//单调递增队列
            list.addLast(i);
        }
        return res;
    }
}
