package algorithms.array;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 找出所有和为S的连续正数序列
 * 至少包括两个数
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> myFindContinuousSequence(int n) {
        int sum = 1;
        int i = 1;
        int j = 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        tmp.addLast(1);
        while (i <= n && j <= n){
            if (sum < n){
                sum += ++j;
                tmp.addLast(j);
            } else if (sum > n){
                sum -= i++;
                tmp.removeFirst();
            } else {
                if (tmp.size() >= 2) res.add(new ArrayList<>(tmp));
                sum -= i++;
                tmp.removeFirst();
            }
        }
        return res;
    }
}
