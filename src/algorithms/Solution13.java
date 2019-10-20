package algorithms;

import java.util.Arrays;

/**
 * 
 *
 * @author zfk
 * 
 * @date 2019年10月19日 下午4:22:41
 * 
 */
public class Solution13 {

    public static void main(String[] args) {
        Solution13 so = new Solution13();
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr));
        so.reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void reOrderArray(int[] array) {
        if(array == null || array.length == 0) {
            return;
        }
        int m = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                int tmp = array[i];
                int j = i;
                while (j > m) {
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = tmp;
                m = j+1;
            }
        }
    }
    public void reOrderArray1(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int i = 0;
        int j = 0;
        while (i < array.length && j < array.length) {
            if ((array[i] & 1) == 1) {
                i++;
                j++;
            }else if ((array[j] & 1) == 0) {
                j++;
            }else {
                int tmp = array[j];
                for (int x = j-1; x >= i; x--) {
                    array[x+1] = array[x];
                }
                array[i] = tmp;
                i++;
                j++;
            }
        }
    }
}
