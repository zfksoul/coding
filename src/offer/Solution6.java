package offer;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月16日 下午10:01:47
 * 
 */
public class Solution6 {
    public static void main(String[] args) {
        int[] array = { 3, 4, 5, 6, 1, 2 };
        Solution6 so = new Solution6();
        System.out.println(so.minNumberInRotateArray(array));
    }

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int i = 0;
        int j = array.length - 1;
        while (i + 1 != j) {
            int m = (i + j) / 2;
            if (array[m] >= array[i]) {
                i = m;
            } else if (array[m] <= array[j]) {
                j = m;
            }
        }
        return array[j];
    }
}
