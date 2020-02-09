package algorithms.array;

import java.util.Stack;

public class WaterProblem {
    public static void main(String[] args){
        WaterProblem o = new WaterProblem();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(o.getWater(arr));
        System.out.println(o.getWater1(arr));
        System.out.println(o.getWater2(arr));
    }
    public int getWater2(int[] arr) {
        if (arr == null || arr.length < 3){
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        int res = 0;
        int k;
        int lmax;
        for (int i = 0; i < arr.length; i++){
            while (!st.empty() && arr[st.peek()] <= arr[i]){
                k = st.pop();
                if (!st.empty()){
                    lmax = st.peek();
                    res += (Math.min(arr[lmax], arr[i]) - arr[k]) * (i - lmax - 1);
                }
            }
            st.push(i);
        }
        return res;
    }
    public int getWater1(int[] arr) {
        if (arr == null || arr.length < 3){
            return 0;
        }
        int lmax = arr[0];
        int rmax = arr[arr.length - 1];
        int l = 0;
        int r = arr.length - 2;
        int value = 0;
        while (l <= r){
            if (lmax <= rmax){
                value += Math.max(0, lmax - arr[l]);
                lmax = Math.max(lmax, arr[l++]);
            } else {
                value += Math.max(0, rmax - arr[r]);
                rmax = Math.max(rmax, arr[r--]);
            }
        }
        return value;
    }

    public int getWater(int[] arr) {
        if (arr == null || arr.length < 3){
            return 0;
        }
        int l = 1;
        int r = arr.length - 2;
        int lmax = arr[0];
        int rmax = arr[arr.length - 1];
        int res = 0;
        while (l <= r){
            if (lmax < rmax){
                res += lmax - arr[l] > 0 ? lmax - arr[l] : 0;
                lmax = Math.max(lmax, arr[l++]);
            } else {
                res += rmax - arr[r] > 0 ? rmax - arr[r] : 0;
                rmax = Math.max(rmax, arr[r--]);
            }
        }
        return res;
    }
}
