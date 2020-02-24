package offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution37 {
    public int GetNumberOfK(int [] array , int k) {
        int cnt = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == k) cnt++;
        }
        return cnt;
    }
}
