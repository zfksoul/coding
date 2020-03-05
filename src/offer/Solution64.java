package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 */
public class Solution64 {
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
