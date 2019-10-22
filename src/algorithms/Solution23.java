package algorithms;

/**
 * 
 *
 * @author zfk
 * @date 2019年10月21日 下午11:26:55
 * 
 */
public class Solution23 {
    public static void main(String[] args) {
        Solution23 so = new Solution23();
        int[] arr = { 5, 7, 6, 9, 11, 10, 8 };
        System.out.println(so.VerifySquenceOfBST(arr));
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return fun(sequence, 0, sequence.length - 1);
    }

    public boolean fun(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int m = start;
        for (; m < end; m++) {
            if (sequence[m] > sequence[end]) {
                break;
            }
        }
        for (int i = m; i < end; i++) {
            if (sequence[i] < sequence[end]) {
                return false;
            }
        }
        return fun(sequence, start, m - 1) && fun(sequence, m, end - 1);
    }

    public boolean fun1(int[] sequence, int i, int j) {
        if (i >= j) {
            return true;
        }
        boolean left = true;
        int m = i;
        for (int k = i; k < j; k++) {
            if (sequence[k] < sequence[j]) {
                if (left) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (left) {
                    m = k;
                    left = false;
                } else {
                    continue;
                }
            }
        }
        return fun(sequence, i, m - 1) && fun(sequence, m, j - 1);
    }
}
