package algorithms.others;

import java.util.Arrays;

/**
 * 蓄水池算法
 */
public class GetKNumsRand {
    public static void main(String[] args){
        GetKNumsRand o = new GetKNumsRand();
        System.out.println(Arrays.toString(o.myGetKNumsRand(4, 100)));
    }

    public int[] myGetKNumsRand(int k, int max) {
        if (k < 1 || max < 1){
            return null;
        }
        int shorts = Math.min(k, max);
        int[] res = new int[shorts];
        for (int i = 0; i < shorts; i++){
            res[i] = i + 1;
        }
        for (int i = k + 1; i <= max; i++){
            if (getRand(i) <= k){
                res[getRand(k) - 1] = i;
            }
        }
        return res;
    }
    public int getRand(int max){
        return (int) (Math.random() * max + 1);
    }
}
