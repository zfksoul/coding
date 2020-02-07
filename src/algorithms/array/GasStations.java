package algorithms.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定数组a[i]表示i到i+1的距离，b[i]表示i站的油量
 * 求出从哪个站出发可以走完一圈
 */
public class GasStations {
    public static void main(String[] args){
        GasStations o = new GasStations();
        int[] a = {4,6,4,3,3};
        int[] b = {7,4,2,2,5};
        int[] t = {3,-2,-2,-1,2};
        int[] x = {};
        System.out.println(Arrays.toString(o.getStation1(a, b)));
        System.out.println(o.getStation(a, b));
    }
    public boolean[] getStation1(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0 || a.length != b.length){
            return null;
        }
        int n = a.length;
        int[] h = new int[n * 2 - 1];
        h[0] = b[0] - a[0];
        LinkedList<Integer> qmin = new LinkedList<>();
        qmin.addLast(0);
        for (int i = 1; i < n; i++){
            h[i] = h[i - 1] + b[i] - a[i];
            while (!qmin.isEmpty() && h[qmin.peekLast()] >= h[i]){
                qmin.pollLast();
            }
            qmin.addLast(i);
        }
        boolean[] res = new boolean[n];
        res[0] = h[qmin.peekFirst()] < 0 ? false : true;
        for (int i = n; i < h.length; i++){
            if (qmin.peekFirst() <= i - n){
                qmin.pollFirst();
            }
            h[i] = h[i - 1] + b[i - n] - a[i - n];
            while (!qmin.isEmpty() && h[qmin.peekLast()] >= h[i]){
                qmin.pollLast();
            }
            qmin.addLast(i);
            res[i - n + 1] = h[qmin.peekFirst()] - h[i - n] < 0 ? false : true;
        }
        return res;
    }
    public int getStation(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length || a.length == 0){
            return -1;
        }
        LinkedList<Integer> q = new LinkedList<>();
        int res = 0;
        int w = a.length;
        int[] help = new int[a.length * 2];
        help[0] = b[0] - a[0];
        for (int i = 1; i < a.length; i++){
            help[i] = help[i - 1] + b[i] - a[i];
        }
        for (int i = a.length; i < help.length; i++){
            help[i] += help[i - 1];
        }
        for (int i = 0; i < help.length; i++){
            while (!q.isEmpty()){
                if (help[q.peekLast()] >= help[i]){
                    q.pollLast();
                } else {
                    break;
                }
            }
            q.addLast(i);
            if (q.peekFirst() <= i - w){
                q.pollFirst();
            }
            if (i == w - 1 && q.peekFirst() == 0 && help[0] >= 0){
                return 0;
            }
            if (i >= w && help[q.peekFirst()] - help[i - w] >= 0){
                return q.peekFirst() - w + 1;
            }
        }
        return -1;
    }
}
