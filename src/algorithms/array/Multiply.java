package algorithms.array;

import java.util.Arrays;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
 * 从左到右算 B[i]=A[0]*A[1]*...*A[i-1]
 * 从右到左算B[i]*=A[i+1]*...*A[n-1]
 *
 */
public class Multiply {
    public static void main(String[] args){
        Multiply o = new Multiply();
        int[] arr = {0,2,3,4,5};
        System.out.println(Arrays.toString(o.myMultiply(arr)));
    }
    public int[] myMultiply(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = 1;
        int tmp = 1;
        for (int i = 1; i < arr.length; i++){
            tmp *= arr[i - 1];
            res[i] = tmp;
        }
        tmp = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--){
            res[i] *= tmp;
            tmp *= arr[i];
        }
        return res;
    }

}
